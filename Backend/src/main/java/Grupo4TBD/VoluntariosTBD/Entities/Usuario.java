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
public class Usuario {
    @BsonId
    private ObjectId _id;
    private String email;
    private String password;
    private String rol;
}
