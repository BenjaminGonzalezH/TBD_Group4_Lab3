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
import java.util.Arrays;
import java.util.List;

@Repository
public class VoluntarioRepoImp implements VoluntarioRepository {
    private final String DB = "voluntario";
    @Autowired
    MongoDatabase database;

    @Override
    public Voluntario crear(Voluntario voluntario) {
        MongoCollection<Voluntario> collection = database.getCollection(DB, Voluntario.class);
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
        return collection.find(new Document("id", id)).first();
    }


    @Override
    public String update(Voluntario voluntario, ObjectId id) {
        MongoCollection<Voluntario> collection = database.getCollection(DB, Voluntario.class);
        collection.replaceOne(new Document("id", id), voluntario);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Voluntario> collection = database.getCollection(DB, Voluntario.class);
        collection.deleteOne(new Document("id", id));
    }

    @Override
    public List<Voluntario> obtenerVoluntariosPorTarea(String tarea) {
        MongoCollection<Document> collection = database.getCollection("ranking");

        // Obtiene voluntarios de la tarea
        List<Document> pipeline = Arrays.asList(
                new Document("$match",
                        new Document("tarea", tarea)
                ),
                new Document("$lookup",
                        new Document("from", "voluntario")
                                .append("localField", "voluntario")
                                .append("foreignField", "nombre")
                                .append("as", "voluntariosRegistrados")
                ),
                new Document("$unwind", "$voluntariosRegistrados"),
                new Document("$project",
                        new Document("_id", "$voluntariosRegistrados._id")
                                .append("nombre", "$voluntariosRegistrados.nombre")
                )
        );

        // Convierte documentos a lista
        List<Voluntario> voluntarios = new ArrayList<>();
        List<Document> results = collection.aggregate(pipeline).into(new ArrayList<>());
        for (Document doc : results) {
            ObjectId id = doc.getObjectId("id");
            String nombre = doc.getString("nombre");
            voluntarios.add(new Voluntario(id, nombre));
        }

        return voluntarios;
    }
}
