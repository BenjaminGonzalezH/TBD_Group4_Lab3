package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea;
import Grupo4TBD.VoluntariosTBD.Repositories.TareaRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TareaRepoImp implements TareaRepository {
    private final String DB = "tarea";
    @Autowired
    MongoDatabase database;

    @Override
    public Tarea crear(Tarea tarea) {
        MongoCollection<Tarea> collection = database.getCollection(DB, Tarea.class);
        collection.insertOne(tarea);
        return tarea;
    }

    @Override
    public List<Tarea> getAll() {
        MongoCollection<Tarea> collection = database.getCollection(DB, Tarea.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Tarea show(ObjectId id) {
        MongoCollection<Tarea> collection = database.getCollection(DB, Tarea.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Tarea tarea, ObjectId id) {
        MongoCollection<Tarea> collection = database.getCollection(DB, Tarea.class);
        collection.replaceOne(new Document("_id", id), tarea);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Tarea> collection = database.getCollection(DB, Tarea.class);
        collection.deleteOne(new Document("_id", id));
    }
}
