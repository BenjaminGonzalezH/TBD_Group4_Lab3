package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Institucion;
import Grupo4TBD.VoluntariosTBD.Entities.Vol_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Vol_habilidadRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class Vol_habilidadRepoImp implements Vol_habilidadRepository {
    private final String DB = "vol_habilidad";
    @Autowired
    MongoDatabase database;

    @Override
    public Vol_habilidad crear(Vol_habilidad vol_habilidad) {
        MongoCollection<Vol_habilidad> collection = database.getCollection(DB, Vol_habilidad.class);
        collection.insertOne(vol_habilidad);
        return vol_habilidad;
    }

    @Override
    public List<Vol_habilidad> getAll() {
        MongoCollection<Vol_habilidad> collection = database.getCollection(DB, Vol_habilidad.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Vol_habilidad show(ObjectId id) {
        MongoCollection<Vol_habilidad> collection = database.getCollection(DB, Vol_habilidad.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Vol_habilidad vol_habilidad, ObjectId id) {
        MongoCollection<Vol_habilidad> collection = database.getCollection(DB, Vol_habilidad.class);
        collection.replaceOne(new Document("_id", id), vol_habilidad);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Institucion> collection = database.getCollection(DB, Institucion.class);
        collection.deleteOne(new Document("_id", id));
    }
}
