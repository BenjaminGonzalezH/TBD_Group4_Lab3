package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class VoluntarioRepoImp implements VoluntarioRepository {
    private final String DB = "voluntario";
    @Autowired
    MongoDatabase database;

    @Override
    public Voluntario crear(Voluntario voluntario) {
        MongoCollection<Voluntario> collection = database.getCollection(DB, Voluntario.class);
        voluntario.set_id(new ObjectId());
        collection.insertOne(voluntario);
        return voluntario;
    }

    @Override
    public List<Voluntario> getAll() {
        MongoCollection<Voluntario> collection = database.getCollection(DB, Voluntario.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Voluntario show(ObjectId id) {
        MongoCollection<Voluntario> collection = database.getCollection(DB, Voluntario.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Voluntario voluntario, ObjectId id) {
        MongoCollection<Voluntario> collection = database.getCollection(DB, Voluntario.class);
        collection.replaceOne(new Document("_id", id), voluntario);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Voluntario> collection = database.getCollection(DB, Voluntario.class);
        collection.deleteOne(new Document("_id", id));
    }
}
