package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import org.bson.types.ObjectId;

import java.util.List;


public interface VoluntarioRepository {
    //Create
    Voluntario crear(Voluntario voluntario);

    //Read
    List<Voluntario> getAll();

    Voluntario show(ObjectId id);

    //Update
    String update(Voluntario voluntario, ObjectId id);

    //Delete
    void delete(ObjectId id);

    //
    Voluntario findByUserEmail(String email);

    // TODO: IMPLEMENTAR
    //Busca por id_habilidad el ranking de voluntarios de una emergencia
    // List<Requerimiento> rankingVoluntariosRequerimientosEmergencia(ObjectId id_habilidad);
}