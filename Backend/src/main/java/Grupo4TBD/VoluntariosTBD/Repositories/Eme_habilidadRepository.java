package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Eme_habilidad;
import org.bson.types.ObjectId;

import java.util.List;


public interface Eme_habilidadRepository {
    //Create
    Eme_habilidad crear(Eme_habilidad eme_habilidad);

    //Read
    List<Eme_habilidad> getAll();

    Eme_habilidad show(ObjectId id);

    //Update
    String update(Eme_habilidad eme_habilidad, ObjectId id);

    //Delete
    void delete(ObjectId id);
}
