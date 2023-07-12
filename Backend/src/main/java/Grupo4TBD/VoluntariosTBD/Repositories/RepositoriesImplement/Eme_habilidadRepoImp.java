package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Eme_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Eme_habilidadRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Eme_habilidadRepoImp implements Eme_habilidadRepository {
    private final String DB = "eme_habilidad";
    @Autowired
    MongoDatabase database;

    @Override
    public Eme_habilidad crear(Eme_habilidad eme_habilidad) {
        MongoCollection<Eme_habilidad> collection = database.getCollection(DB, Eme_habilidad.class);
        eme_habilidad.set_id(new ObjectId());
        collection.insertOne(eme_habilidad);
        return eme_habilidad;
    }

    @Override
    public List<Eme_habilidad> getAll() {
        MongoCollection<Eme_habilidad> collection = database.getCollection(DB, Eme_habilidad.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Eme_habilidad show(ObjectId id) {
        MongoCollection<Eme_habilidad> collection = database.getCollection(DB, Eme_habilidad.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Eme_habilidad eme_habilidad, ObjectId id) {
        MongoCollection<Eme_habilidad> collection = database.getCollection(DB, Eme_habilidad.class);
        collection.replaceOne(new Document("_id", id), eme_habilidad);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Eme_habilidad> collection = database.getCollection(DB, Eme_habilidad.class);
        collection.deleteOne(new Document("_id", id));
    }
}
