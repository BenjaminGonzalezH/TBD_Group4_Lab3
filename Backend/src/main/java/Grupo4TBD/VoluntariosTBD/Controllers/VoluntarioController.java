package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import org.bson.types.ObjectId;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {
    private final VoluntarioRepository VoluntarioRepository;

    VoluntarioController(VoluntarioRepository VoluntarioRepository) {
        this.VoluntarioRepository = VoluntarioRepository;
    }

    // crear C
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public Voluntario crear(@RequestBody Voluntario voluntario) {
        return VoluntarioRepository.crear(voluntario);
    }

    // get R
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public List<Voluntario> getAllVoluntario() {
        return VoluntarioRepository.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public Voluntario show(@PathVariable ObjectId id) {
        return VoluntarioRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public String updateVoluntario(@RequestBody Voluntario voluntario, @PathVariable ObjectId id) {
        return VoluntarioRepository.update(voluntario, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable ObjectId id) {
        VoluntarioRepository.delete(id);
    }

    // TODO: IMPLEMENTAR
//    @GetMapping("/requerimiento/{id}")
//    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
//    public List<Requerimiento> getRankingEmergencia(@PathVariable ObjectId id) {
//        return VoluntarioRepository.rankingVoluntariosRequerimientosEmergencia(id);
//    }
}
