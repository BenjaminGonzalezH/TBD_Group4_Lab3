package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Estado_tarea;
import Grupo4TBD.VoluntariosTBD.Repositories.Estado_tareaRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Estado_tareaRepoImp implements Estado_tareaRepository {
    private final String DB = "estado_tarea";
    @Autowired
    MongoDatabase database;

    @Override
    public Estado_tarea crear(Estado_tarea estado_tarea) {
        MongoCollection<Estado_tarea> collection = database.getCollection(DB, Estado_tarea.class);
        collection.insertOne(estado_tarea);
        return estado_tarea;
    }

    @Override
    public List<Estado_tarea> getAll() {
        MongoCollection<Estado_tarea> collection = database.getCollection(DB, Estado_tarea.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Estado_tarea show(ObjectId id) {
        MongoCollection<Estado_tarea> collection = database.getCollection(DB, Estado_tarea.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Estado_tarea estado_tarea, ObjectId id) {
        MongoCollection<Estado_tarea> collection = database.getCollection(DB, Estado_tarea.class);
        collection.replaceOne(new Document("_id", id), estado_tarea);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Estado_tarea> collection = database.getCollection(DB, Estado_tarea.class);
        collection.deleteOne(new Document("_id", id));
    }
}
