package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Models.AuthCredentials;
import Grupo4TBD.VoluntariosTBD.Models.Register;
import Grupo4TBD.VoluntariosTBD.Models.Sesion;
import Grupo4TBD.VoluntariosTBD.Models.TokenInfo;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import Grupo4TBD.VoluntariosTBD.Services.TokenUtils;
import Grupo4TBD.VoluntariosTBD.Services.UserDetailsImp;
import Grupo4TBD.VoluntariosTBD.Services.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final VoluntarioRepository voluntarioRepository;
    private final TokenUtils tokenUtils;
    private final UserDetailsServiceImpl usuarioDetailsServiceImpl;
    private final AuthenticationManager authenticationManager;

    // crear C
    @PostMapping("/register")
    public String registrar(@RequestBody Register registro) {
        Usuario usuario = new Usuario();
        usuario.setEmail(registro.getEmail());
        usuario.setRol("VOLUNTARIO"); // Rol por defecto
        usuario.setPassword(passwordEncoder().encode(registro.getPassword()));
        // Usuario ya registrado
        if (voluntarioRepository.findByUserEmail(usuario.getEmail()) != null)
            return "Email ya se encuentra registrado";
        Voluntario voluntario = new Voluntario();
        voluntario.setNombre(registro.getNombre());
        voluntario.setUsuario(usuario);
        voluntario = voluntarioRepository.crear(voluntario);
        if (voluntario == null) {
            return "ERROR: No se pudo registrar Usuario";
        }
        return "Usuario registrado exitosamente";
    }

    @GetMapping("/sesion")
    public Sesion sesion() {
        Sesion sesion = new Sesion();
        Usuario usuario = voluntarioRepository.getUserInSession();
        if (usuario == null)
            return null;
        Voluntario voluntario = voluntarioRepository.findByUserEmail(usuario.getEmail());
        if (voluntario == null)
            return null;
        sesion.setId(voluntario.get_id());
        sesion.setEmail(usuario.getEmail());
        sesion.setNombre(voluntario.getNombre());
        return sesion;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenInfo> authenticate(@RequestBody AuthCredentials authenticationReq) {
        try {
            logger.info("Autenticando al usuario {}", authenticationReq.getEmail());

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationReq.getEmail(),
                            authenticationReq.getPassword()));

            final UserDetailsImp userDetails = usuarioDetailsServiceImpl.loadUserByUsername(
                    authenticationReq.getEmail());

            final String jwt = TokenUtils.createToken(userDetails);

            Sesion sesion = new Sesion();
            Usuario usuario = voluntarioRepository.findByUserEmail(authenticationReq.getEmail()).getUsuario();

            if (usuario == null) {
                // El usuario no existe
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            Voluntario voluntario = voluntarioRepository.findByUserEmail(usuario.getEmail());

            if (voluntario == null) {
                // No se encontró el voluntario asociado al usuario
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            sesion.setId(voluntario.get_id());
            sesion.setEmail(usuario.getEmail());
            sesion.setNombre(voluntario.getNombre());

            return ResponseEntity.ok(new TokenInfo(sesion, jwt));
        } catch (AuthenticationException e) {
            // El usuario no pudo ser autenticado
            logger.error("Error de autenticación: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } catch (Exception e) {
            // Manejo de otras excepciones
            logger.error("Error al autenticar al usuario: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
