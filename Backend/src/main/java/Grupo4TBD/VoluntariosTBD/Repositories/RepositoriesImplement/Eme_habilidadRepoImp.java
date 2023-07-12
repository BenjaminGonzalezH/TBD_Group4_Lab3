package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Eme_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Eme_habilidadRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Eme_habilidadRepoImp implements Eme_habilidadRepository {
    @Autowired
    MongoDatabase database;
    @Override
    public Eme_habilidad crear(Eme_habilidad eme_habilidad) {

    }

    @Override
    public List<Eme_habilidad> getAll() {
        MongoCollection<Dog>
    }

    @Override
    public List<Eme_habilidad> show(Integer id) {

    }

    @Override
    public String update(Eme_habilidad eme_habilidad, Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }
}
