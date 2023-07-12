package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea;
import org.bson.types.ObjectId;

import java.util.List;


public interface TareaRepository {
    //Create
    Tarea crear(Tarea tarea);

    //Read
    List<Tarea> getAll();

    Tarea show(ObjectId id);

    //Update
    String update(Tarea tarea, ObjectId id);

    //Delete
    void delete(ObjectId id);
}
