package Grupo4TBD.VoluntariosTBD.Services;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoluntarioService {
    private final VoluntarioRepository voluntarioRepository;

    @Autowired
    public VoluntarioService(VoluntarioRepository voluntarioRepository) {
        this.voluntarioRepository = voluntarioRepository;
    }

    //Create
   public Voluntario create(Voluntario voluntario){
        return voluntarioRepository.create(voluntario);
   }

    //Read
    public List<Voluntario> getAll(){
        return voluntarioRepository.getAll();
    }

    public Voluntario show(ObjectId id){
        return voluntarioRepository.show(id);
    }

    //Update
    public String update(Voluntario voluntario, ObjectId id){
        return voluntarioRepository.update(voluntario, id);
    }

    //Delete
    public void delete(ObjectId id){
        voluntarioRepository.delete(id);
    }

}
