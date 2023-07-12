package Grupo4TBD.VoluntariosTBD.Controllers;

import Grupo4TBD.VoluntariosTBD.Entities.Institucion;
import Grupo4TBD.VoluntariosTBD.Repositories.InstitucionRepository;
import org.bson.types.ObjectId;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/institucion")
public class InstitucionController {
    private final InstitucionRepository InstitucionRepository;

    InstitucionController(InstitucionRepository InstitucionRepository) {
        this.InstitucionRepository = InstitucionRepository;
    }

    // crear C
    @PostMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public Institucion crear(@RequestBody Institucion institucion) {
        return InstitucionRepository.crear(institucion);
    }

    // get R
    @GetMapping()
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public List<Institucion> getAllInstitucion() {
        return InstitucionRepository.getAll();
    }

    // get by id R
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public Institucion show(@PathVariable ObjectId id) {
        return InstitucionRepository.show(id);
    }

    // actualizar U
    @PutMapping("/{id}")
    @ResponseBody
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public String updateInstitucion(@RequestBody Institucion institucion, @PathVariable ObjectId id) {
        return InstitucionRepository.update(institucion, id);
    }

    // borrar D
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_COORDINADOR')")
    public void borrar(@PathVariable ObjectId id) {
        InstitucionRepository.delete(id);
    }
}
