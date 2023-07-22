package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Eme_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Eme_habilidadRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eme_habilidad")
public class Eme_habilidadController {
    private final Eme_habilidadRepository Eme_habilidadRepository;

    Eme_habilidadController(Eme_habilidadRepository Eme_habilidadRepository) {
        this.Eme_habilidadRepository = Eme_habilidadRepository;
    }

    // crear C
    @PostMapping()
    public Eme_habilidad crear(@RequestBody Eme_habilidad eme_habilidad) {
        return Eme_habilidadRepository.crear(eme_habilidad);
    }

    // get R
    @GetMapping()
    public List<Eme_habilidad> getAllEme_habilidad() {
        return Eme_habilidadRepository.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    public Eme_habilidad show(@PathVariable ObjectId id) {
        return Eme_habilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateEme_habilidad(@RequestBody Eme_habilidad eme_habilidad, @PathVariable ObjectId id) {
        return Eme_habilidadRepository.update(eme_habilidad, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable ObjectId id) {
        Eme_habilidadRepository.delete(id);
    }

}
