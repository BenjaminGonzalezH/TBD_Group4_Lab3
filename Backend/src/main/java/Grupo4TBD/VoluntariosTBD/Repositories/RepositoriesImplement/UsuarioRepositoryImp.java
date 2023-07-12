package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Usuario;
import Grupo4TBD.VoluntariosTBD.Repositories.UsuarioRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepositoryImp implements UsuarioRepository {
    private final String DB = "usuario";
    @Autowired
    MongoDatabase database;

    @Override
    public Usuario crear(Usuario usuario) {
        MongoCollection<Usuario> collection = database.getCollection(DB, Usuario.class);
        usuario.set_id(new ObjectId());
        collection.insertOne(usuario);
        return usuario;
    }

    @Override
    public List<Usuario> getAll() {
        MongoCollection<Usuario> collection = database.getCollection(DB, Usuario.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Usuario show(ObjectId id) {
        MongoCollection<Usuario> collection = database.getCollection(DB, Usuario.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Usuario usuario, ObjectId id) {
        MongoCollection<Usuario> collection = database.getCollection(DB, Usuario.class);
        collection.replaceOne(new Document("_id", id), usuario);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Usuario> collection = database.getCollection(DB, Usuario.class);
        collection.deleteOne(new Document("_id", id));
    }

    @Override
    public Usuario findByEmail(String email) {
        MongoCollection<Usuario> collection = database.getCollection(DB, Usuario.class);
        return collection.find(new Document("email", email)).first();
    }

    @Override
    public Usuario getUserInSession() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = (String) auth.getPrincipal();
        return this.findByEmail(email);
    }
}
