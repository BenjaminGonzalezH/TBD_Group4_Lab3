package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea;
import Grupo4TBD.VoluntariosTBD.Services.TareaService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea")
public class TareaController {
    private final TareaService tareaService;

    TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    // crear C
    @PostMapping()
    public Tarea crear(@RequestBody Tarea tarea) {
        return tareaService.create(tarea);
    }

    // get R
    @GetMapping()
    public List<Tarea> getAllTarea() {
        return tareaService.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    public Tarea show(@PathVariable ObjectId id) {
        return tareaService.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateTarea(@RequestBody Tarea tarea, @PathVariable ObjectId id) {
        return tareaService.update(tarea, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable ObjectId id) {
        tareaService.delete(id);
    }
}
