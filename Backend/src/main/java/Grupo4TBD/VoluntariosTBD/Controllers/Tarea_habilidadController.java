package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Tarea_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Tarea_habilidadRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tarea_habilidad")
public class Tarea_habilidadController {
    private final Tarea_habilidadRepository Tarea_habilidadRepository;

    Tarea_habilidadController(Tarea_habilidadRepository Tarea_habilidadRepository) {
        this.Tarea_habilidadRepository = Tarea_habilidadRepository;
    }

    // crear C
    @PostMapping()
    public Tarea_habilidad crear(@RequestBody Tarea_habilidad tarea_habilidad) {
        return Tarea_habilidadRepository.crear(tarea_habilidad);
    }

    // get R
    @GetMapping()
    public List<Tarea_habilidad> getAllTarea_habilidad() {
        return Tarea_habilidadRepository.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    public Tarea_habilidad show(@PathVariable ObjectId id) {
        return Tarea_habilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateTarea_habilidad(@RequestBody Tarea_habilidad tarea_habilidad, @PathVariable ObjectId id) {
        return Tarea_habilidadRepository.update(tarea_habilidad, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable ObjectId id) {
        Tarea_habilidadRepository.delete(id);
    }
}
