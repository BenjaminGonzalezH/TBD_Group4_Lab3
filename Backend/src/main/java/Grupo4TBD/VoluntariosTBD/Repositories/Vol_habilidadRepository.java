package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Vol_habilidad;
import org.bson.types.ObjectId;

import java.util.List;


public interface Vol_habilidadRepository {
    //Create
    Vol_habilidad crear(Vol_habilidad volHabilidad);

    //Read
    List<Vol_habilidad> getAll();

    Vol_habilidad show(ObjectId id);

    //Update
    String update(Vol_habilidad volHabilidad, ObjectId id);

    //Delete
    void delete(ObjectId id);
}
