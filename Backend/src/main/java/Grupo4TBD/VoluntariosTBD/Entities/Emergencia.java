package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Emergencia {
    @BsonId
    private ObjectId _id;
    private String nombre;
    private String descrip;
    private Date fecha_inicio;
    private Date fecha_fin;
    private String institucion;
}
