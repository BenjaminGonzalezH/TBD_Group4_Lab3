package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Habilidad;
import org.bson.types.ObjectId;

import java.util.List;


public interface HabilidadRepository {
    //Create
    Habilidad crear(Habilidad habilidad);

    //Read
    List<Habilidad> getAll();

    Habilidad show(ObjectId id);

    //Update
    String update(Habilidad habilidad, ObjectId id);

    //Delete
    void delete(ObjectId id);
}
