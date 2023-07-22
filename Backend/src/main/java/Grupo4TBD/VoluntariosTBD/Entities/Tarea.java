package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Tarea {
    @BsonId
    private ObjectId id;
    private String nombre;
    private String descrip;
    private Integer cant_vol_requeridos;
    private Integer cant_vol_inscritos;
    private Integer id_emergencia;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String emergencia;
    private List<String> nombre_voluntario;
}
