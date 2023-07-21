package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Voluntario;
import Grupo4TBD.VoluntariosTBD.Services.VoluntarioService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voluntario")
public class VoluntarioController {
    private final VoluntarioService voluntarioService;

    @Autowired
    public VoluntarioController(VoluntarioService voluntarioService) {
        this.voluntarioService = voluntarioService;
    }

    // crear C
    @PostMapping()
    public Voluntario crear(@RequestBody Voluntario voluntario) {
        return voluntarioService.create(voluntario);
    }

    // get R
    @GetMapping()
    public List<Voluntario> getAllVoluntario() {
        return voluntarioService.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    public Voluntario show(@PathVariable ObjectId id) {
        return voluntarioService.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    public String updateVoluntario(@RequestBody Voluntario voluntario, @PathVariable ObjectId id) {
        return voluntarioService.update(voluntario, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    public void borrar(@PathVariable ObjectId id) {
        voluntarioService.delete(id);
    }

    @GetMapping("/tarea/{nombreTarea}")
    public ResponseEntity<List<Voluntario>> getVoluntariosPorTarea(@PathVariable String nombreTarea) {
        List<Voluntario> voluntarios = VoluntarioRepository.obtenerVoluntariosPorTarea(nombreTarea);
        if (voluntarios.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(voluntarios);
        }
    }
}
