package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Estado_tarea;
import org.bson.types.ObjectId;

import java.util.List;


public interface Estado_tareaRepository {
    //Create
    Estado_tarea crear(Estado_tarea estadoTarea);

    //Read
    List<Estado_tarea> getAll();

    Estado_tarea show(ObjectId id);

    //Update
    String update(Estado_tarea estadoTarea, ObjectId id);

    //Delete
    void delete(ObjectId id);
}
