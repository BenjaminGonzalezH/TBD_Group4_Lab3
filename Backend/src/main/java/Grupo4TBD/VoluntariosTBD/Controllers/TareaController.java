package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea;
import Grupo4TBD.VoluntariosTBD.Repositories.TareaRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea")
public class TareaController {
    private final Grupo4TBD.VoluntariosTBD.Repositories.TareaRepository TareaRepository;

    TareaController(TareaRepository TareaRepository) {
        this.TareaRepository = TareaRepository;
    }

    // crear C
    @PostMapping()
    public Tarea crear(@RequestBody Tarea tarea) {
        return TareaRepository.crear(tarea);
    }

    // get R
    @GetMapping()
    public List<Tarea> getAllTarea() {
        return TareaRepository.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    public Tarea show(@PathVariable ObjectId id) {
        return TareaRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateTarea(@RequestBody Tarea tarea, @PathVariable ObjectId id) {
        return TareaRepository.update(tarea, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable ObjectId id) {
        TareaRepository.delete(id);
    }
}
