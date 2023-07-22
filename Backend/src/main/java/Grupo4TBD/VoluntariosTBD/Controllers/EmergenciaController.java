package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Emergencia;
import Grupo4TBD.VoluntariosTBD.Repositories.EmergenciaRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emergencia")
public class EmergenciaController {
    private final EmergenciaRepository EmergenciaRepository;

    EmergenciaController(EmergenciaRepository EmergenciaRepository) {
        this.EmergenciaRepository = EmergenciaRepository;
    }

    // crear C
    @PostMapping()
    public Emergencia crear(@RequestBody Emergencia emergencia) {
        return EmergenciaRepository.crear(emergencia);
    }

    // get R
    @GetMapping("")
    public List<Emergencia> getAllEmergencia() {
        return EmergenciaRepository.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    public Emergencia show(@PathVariable ObjectId id) {
        return EmergenciaRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateEmergencia(@RequestBody Emergencia emergencia, @PathVariable ObjectId id) {
        return EmergenciaRepository.update(emergencia, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable ObjectId id) {
        EmergenciaRepository.delete(id);
    }
}
