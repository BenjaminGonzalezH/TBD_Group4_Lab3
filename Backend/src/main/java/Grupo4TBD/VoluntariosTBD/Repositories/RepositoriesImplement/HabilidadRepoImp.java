package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.HabilidadRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class HabilidadRepoImp implements HabilidadRepository {
    private final String DB = "habilidad";
    @Autowired
    MongoDatabase database;

    @Override
    public Habilidad crear(Habilidad habilidad) {
        MongoCollection<Habilidad> collection = database.getCollection(DB, Habilidad.class);
        habilidad.set_id(new ObjectId());
        collection.insertOne(habilidad);
        return habilidad;
    }

    @Override
    public List<Habilidad> getAll() {
        MongoCollection<Habilidad> collection = database.getCollection(DB, Habilidad.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Habilidad show(ObjectId id) {
        MongoCollection<Habilidad> collection = database.getCollection(DB, Habilidad.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Habilidad habilidad, ObjectId id) {
        MongoCollection<Habilidad> collection = database.getCollection(DB, Habilidad.class);
        collection.replaceOne(new Document("_id", id), habilidad);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Habilidad> collection = database.getCollection(DB, Habilidad.class);
        collection.deleteOne(new Document("_id", id));
    }
}
