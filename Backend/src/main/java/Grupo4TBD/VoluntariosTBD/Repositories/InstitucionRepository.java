package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Institucion;
import org.bson.types.ObjectId;

import java.util.List;


public interface InstitucionRepository {
    //Create
    Institucion crear(Institucion institucion);

    //Read
    List<Institucion> getAll();

    Institucion show(ObjectId id);

    //Update
    String update(Institucion institucion, ObjectId id);

    //Delete
    void delete(ObjectId id);
}
