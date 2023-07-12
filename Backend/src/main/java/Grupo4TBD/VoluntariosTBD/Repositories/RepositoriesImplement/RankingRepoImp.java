package Grupo4TBD.VoluntariosTBD.Repositories.RepositoriesImplement;

import Grupo4TBD.VoluntariosTBD.Entities.Ranking;
import Grupo4TBD.VoluntariosTBD.Repositories.RankingRepository;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RankingRepoImp implements RankingRepository {
    private final String DB = "ranking";
    @Autowired
    MongoDatabase database;

    @Override
    public Ranking crear(Ranking ranking) {
        MongoCollection<Ranking> collection = database.getCollection(DB, Ranking.class);
        ranking.set_id(new ObjectId());
        collection.insertOne(ranking);
        return ranking;
    }

    @Override
    public List<Ranking> getAll() {
        MongoCollection<Ranking> collection = database.getCollection(DB, Ranking.class);
        return collection.find().into(new ArrayList<>());
    }

    @Override
    public Ranking show(ObjectId id) {
        MongoCollection<Ranking> collection = database.getCollection(DB, Ranking.class);
        return collection.find(new Document("_id", id)).first();
    }


    @Override
    public String update(Ranking ranking, ObjectId id) {
        MongoCollection<Ranking> collection = database.getCollection(DB, Ranking.class);
        collection.replaceOne(new Document("_id", id), ranking);
        return "Actualización exitosa";
    }

    @Override
    public void delete(ObjectId id) {
        MongoCollection<Ranking> collection = database.getCollection(DB, Ranking.class);
        collection.deleteOne(new Document("_id", id));
    }
}
