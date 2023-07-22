package Grupo4TBD.VoluntariosTBD.Controllers;


import Grupo4TBD.VoluntariosTBD.Entities.Vol_habilidad;
import Grupo4TBD.VoluntariosTBD.Repositories.Vol_habilidadRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vol_habilidad")
public class Vol_habilidadController {

    private final Vol_habilidadRepository Vol_habilidadRepository;

    Vol_habilidadController(Vol_habilidadRepository Vol_habilidadRepository) {
        this.Vol_habilidadRepository = Vol_habilidadRepository;
    }

    // crear C
    @PostMapping()
    public Vol_habilidad crear(@RequestBody Vol_habilidad vol_habilidad) {
        return Vol_habilidadRepository.crear(vol_habilidad);
    }

    // get R
    @GetMapping()
    public List<Vol_habilidad> getAllVol_habilidad() {
        return Vol_habilidadRepository.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    public Vol_habilidad show(@PathVariable ObjectId id) {
        return Vol_habilidadRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateVol_habilidad(@RequestBody Vol_habilidad vol_habilidad, @PathVariable ObjectId id) {
        return Vol_habilidadRepository.update(vol_habilidad, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable ObjectId id) {
        Vol_habilidadRepository.delete(id);
    }
}
