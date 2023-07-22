package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Institucion;
import Grupo4TBD.VoluntariosTBD.Repositories.InstitucionRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InstitucionRepoImp implements InstitucionRepository {
    private final String DB = "institucion";
    @Autowired
    MongoDatabase database;

    @Override
    public Institucion crear(Institucion institucion) {
        MongoCollection<Institucion> collection = database.getCollection(DB, Institucion.class);
        collection.insertOne(institucion);
        return institucion;
    }

    @Override
    public List<Institucion> getAll() {
        MongoCollection<Institucion> collection = database.getCollection(DB, Institucion.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Institucion show(ObjectId id) {
        MongoCollection<Institucion> collection = database.getCollection(DB, Institucion.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Institucion institucion, ObjectId id) {
        MongoCollection<Institucion> collection = database.getCollection(DB, Institucion.class);
        collection.replaceOne(new Document("_id", id), institucion);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Institucion> collection = database.getCollection(DB, Institucion.class);
        collection.deleteOne(new Document("_id", id));
    }
}
