package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import org.bson.types.ObjectId;

import java.util.List;

public interface UsuarioRepository {
    //Create
    Usuario crear(Usuario usuario);

    //Read
    List<Usuario> getAll();

    Usuario show(ObjectId id);

    //Update
    String update(Usuario usuario, ObjectId id);

    //Delete
    void delete(ObjectId id);

    // TODO: IMPLEMENTAR
    //Read by email
    Usuario findByEmail(String email);

    // TODO: IMPLEMENTAR
    //Read session
    Usuario getUserInSession();
}
