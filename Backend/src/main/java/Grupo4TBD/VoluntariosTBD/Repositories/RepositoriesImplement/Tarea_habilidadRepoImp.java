package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Tarea_habilidadRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Tarea_habilidadRepoImp implements Tarea_habilidadRepository {
    private final String DB = "tarea_habilidad";
    @Autowired
    MongoDatabase database;

    @Override
    public Tarea_habilidad crear(Tarea_habilidad tarea_habilidad) {
        MongoCollection<Tarea_habilidad> collection = database.getCollection(DB, Tarea_habilidad.class);
        tarea_habilidad.set_id(new ObjectId());
        collection.insertOne(tarea_habilidad);
        return tarea_habilidad;
    }

    @Override
    public List<Tarea_habilidad> getAll() {
        MongoCollection<Tarea_habilidad> collection = database.getCollection(DB, Tarea_habilidad.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Tarea_habilidad show(ObjectId id) {
        MongoCollection<Tarea_habilidad> collection = database.getCollection(DB, Tarea_habilidad.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Tarea_habilidad tarea_habilidad, ObjectId id) {
        MongoCollection<Tarea_habilidad> collection = database.getCollection(DB, Tarea_habilidad.class);
        collection.replaceOne(new Document("_id", id), tarea_habilidad);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Tarea_habilidad> collection = database.getCollection(DB, Tarea_habilidad.class);
        collection.deleteOne(new Document("_id", id));
    }
}
