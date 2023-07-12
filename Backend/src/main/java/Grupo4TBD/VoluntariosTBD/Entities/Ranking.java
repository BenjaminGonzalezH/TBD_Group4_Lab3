package Grupo4TBD.VoluntariosTBD.Entities;

import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Getter
@Setter
public class Ranking {
    @BsonId
    private ObjectId _id;
    private String voluntario;
    private String tarea;
    private Integer puntaje;
    private Integer flg_invitado;
    private Integer flg_participa;
}
