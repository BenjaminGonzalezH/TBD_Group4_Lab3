package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Emergencia;
import Grupo4TBD.VoluntariosTBD.Repositories.EmergenciaRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmergenciaRepoImp implements EmergenciaRepository {
    private final String DB = "emergencia";
    @Autowired
    MongoDatabase database;

    @Override
    public Emergencia crear(Emergencia emergencia) {
        MongoCollection<Emergencia> collection = database.getCollection(DB, Emergencia.class);
        collection.insertOne(emergencia);
        return emergencia;
    }

    @Override
    public List<Emergencia> getAll() {
        MongoCollection<Emergencia> collection = database.getCollection(DB, Emergencia.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Emergencia show(ObjectId id) {
        MongoCollection<Emergencia> collection = database.getCollection(DB, Emergencia.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Emergencia emergencia, ObjectId id) {
        MongoCollection<Emergencia> collection = database.getCollection(DB, Emergencia.class);
        collection.replaceOne(new Document("_id", id), emergencia);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Emergencia> collection = database.getCollection(DB, Emergencia.class);
        collection.deleteOne(new Document("_id", id));
    }
}
