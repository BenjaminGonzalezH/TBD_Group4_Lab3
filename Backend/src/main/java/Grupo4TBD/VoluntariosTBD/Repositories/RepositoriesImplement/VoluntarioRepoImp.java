package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Models.Requerimiento;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VoluntarioRepoImp implements VoluntarioRepository {
    @Override
    public Voluntario crear(Voluntario voluntario) {
    }


    @Override
    public List<Voluntario> getAll() {
    }

    @Override
    public List<Voluntario> show(Integer id) {
    }

    @Override
    public String update(Voluntario voluntario, Integer id) {
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public Voluntario findByUsuario(Integer id_usuario) {
    }

    @Override
    public List<Requerimiento> rankingVoluntariosRequerimientosEmergencia(Integer id_emergencia) {
    }

    public Integer obtenerSiguienteId() {
    }
}
