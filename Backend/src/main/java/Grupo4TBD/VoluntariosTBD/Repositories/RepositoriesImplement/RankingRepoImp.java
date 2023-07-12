package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Ranking;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.RankingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RankingRepoImp implements RankingRepository {
    @Override
    public Ranking crear(Ranking ranking) {

    }

    @Override
    public List<Ranking> getAll() {

    }

    @Override
    public List<Ranking> show(Integer id) {

    }

    @Override
    public String update(Ranking ranking, Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Voluntario> seleccionarVoluntarioPorTarea(Integer id_tarea) {
    }
}
