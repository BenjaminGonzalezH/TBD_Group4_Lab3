package Grupo4TBD.VoluntariosTBD.Services;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea;
import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.TareaRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
    public Tarea create(Tarea tarea){
        return tareaRepository.create(tarea);
    }

    //Read
    public List<Tarea> getAll(){
        return tareaRepository.getAll();
    }

    public Tarea show(ObjectId id){
        return tareaRepository.show(id);
    }

    //Update
    public String update(Tarea tarea, ObjectId id){
        return tareaRepository.update(tarea, id);
    }

    //Delete
    public void delete(ObjectId id){
        tareaRepository.delete(id);
    }
}
