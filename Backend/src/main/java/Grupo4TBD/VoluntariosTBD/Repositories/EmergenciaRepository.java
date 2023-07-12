package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Emergencia;
import org.bson.types.ObjectId;

import java.util.List;


public interface EmergenciaRepository {
    //Create
    Emergencia crear(Emergencia emergencia);

    //Read
    List<Emergencia> getAll();

    Emergencia show(ObjectId id);

    //Update
    String update(Emergencia emergencia, ObjectId id);

    //Delete
    void delete(ObjectId id);
}
