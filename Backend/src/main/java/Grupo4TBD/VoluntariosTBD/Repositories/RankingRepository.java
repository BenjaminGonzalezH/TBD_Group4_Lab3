package Grupo4TBD.VoluntariosTBD.Repositories;

import Grupo4TBD.VoluntariosTBD.Entities.Ranking;
import org.bson.types.ObjectId;

import java.util.List;


public interface RankingRepository {
    //Create
    Ranking crear(Ranking ranking);

    //Read
    List<Ranking> getAll();

    Ranking show(ObjectId id);

    //Update
    String update(Ranking ranking, ObjectId id);

    //Delete
    void delete(ObjectId id);
}
