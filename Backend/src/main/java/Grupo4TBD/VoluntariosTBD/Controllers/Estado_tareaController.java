package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Estado_tarea;
import Grupo4TBD.VoluntariosTBD.Repositories.Estado_tareaRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado_tarea")
public class Estado_tareaController {
    private final Estado_tareaRepository Estado_tareaRepository;

    Estado_tareaController(Estado_tareaRepository Estado_tareaRepository) {
        this.Estado_tareaRepository = Estado_tareaRepository;
    }

    // crear C
    @PostMapping()
    public Estado_tarea crear(@RequestBody Estado_tarea estado_tarea) {
        return Estado_tareaRepository.crear(estado_tarea);
    }

    // get R
    @GetMapping()
    public List<Estado_tarea> getAllEstado_tarea() {
        return Estado_tareaRepository.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    public Estado_tarea show(@PathVariable ObjectId id) {
        return Estado_tareaRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateEstado_tarea(@RequestBody Estado_tarea estado_tarea, @PathVariable ObjectId id) {
        return Estado_tareaRepository.update(estado_tarea, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable ObjectId id) {
        Estado_tareaRepository.delete(id);
    }
}
