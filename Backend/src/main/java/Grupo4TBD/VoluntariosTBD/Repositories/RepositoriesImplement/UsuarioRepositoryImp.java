package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.Repositories.UsuarioRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {
    @Override
    public Usuario crear(Usuario usuario) {
    }

    @Override
    public List<Usuario> getAll() {
    }

    @Override
    public List<Usuario> show(Integer id) {
    }

    @Override
    public String update(Usuario usuario, Integer id) {
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public Usuario findByEmail(String email) {
    }

    @Override
    public Usuario getUserInSession() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) auth.getPrincipal();
        return this.findByEmail(email);
    }

    public Integer obtenerSiguienteId() {
    }
}
