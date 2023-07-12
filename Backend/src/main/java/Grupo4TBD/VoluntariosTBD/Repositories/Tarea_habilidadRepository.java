package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea_habilidad;
import org.bson.types.ObjectId;

import java.util.List;


public interface Tarea_habilidadRepository {
    //Create
    Tarea_habilidad crear(Tarea_habilidad tareaHabilidad);

    //Read
    List<Tarea_habilidad> getAll();

    Tarea_habilidad show(ObjectId id);

    //Update
    String update(Tarea_habilidad tareaHabilidad, ObjectId id);

    //Delete
    void delete(ObjectId id);
}
