package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Repositories.VoluntarioRepository;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {
    private final VoluntarioRepository VoluntarioRepository;

    VoluntarioController(VoluntarioRepository VoluntarioRepository) {
        this.VoluntarioRepository = VoluntarioRepository;
    }

    // crear C
    @PostMapping()
    public Voluntario crear(@RequestBody Voluntario voluntario) {
        return VoluntarioRepository.crear(voluntario);
    }

    // get R
    @GetMapping()
    public List<Voluntario> getAllVoluntario() {
        return VoluntarioRepository.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    public Voluntario show(@PathVariable ObjectId id) {
        return VoluntarioRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateVoluntario(@RequestBody Voluntario voluntario, @PathVariable ObjectId id) {
        return VoluntarioRepository.update(voluntario, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable ObjectId id) {
        VoluntarioRepository.delete(id);
    }
}
