package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.HabilidadRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habilidad")
public class HabilidadController {
    private final HabilidadRepository HabilidadRepository;

    HabilidadController(HabilidadRepository HabilidadRepository) {
        this.HabilidadRepository = HabilidadRepository;
    }

    // crear C
    @PostMapping()
    public Habilidad crear(@RequestBody Habilidad habilidad) {
        return HabilidadRepository.crear(habilidad);
    }

    // get R
    @GetMapping()
    public List<Habilidad> getAllHabilidad() {
        return HabilidadRepository.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    public Habilidad show(@PathVariable ObjectId id) {
        return HabilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateHabilidad(@RequestBody Habilidad habilidad, @PathVariable ObjectId id) {
        return HabilidadRepository.update(habilidad, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable ObjectId id) {
        HabilidadRepository.delete(id);
    }
}
