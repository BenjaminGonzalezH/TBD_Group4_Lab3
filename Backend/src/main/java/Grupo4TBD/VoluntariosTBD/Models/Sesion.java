package Grupo4TBD.VoluntariosTBD.Models;

import lombok.Data;
import org.bson.types.ObjectId;

@Data
public class Sesion {
    private ObjectId id;
    private String email;
    private String nombre;
    private Float longitud;
    private Float latitud;
}
