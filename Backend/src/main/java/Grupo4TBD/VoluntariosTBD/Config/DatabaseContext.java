package Grupo4TBD.VoluntariosTBD.Config;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DatabaseContext {

    @Bean
    MongoDatabase database() {
        CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
        CodecRegistry fromProvider = CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry pojoCodecRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, fromProvider);

        // Configurar la autenticación
        String databaseNameAdmin = "admin";
        String databaseName = "Voluntariado";
        String username = "admin"; // Reemplaza por tu usuario
        String password = "admin"; // Reemplaza por tu contraseña
        MongoCredential credential = MongoCredential.createCredential(username, databaseNameAdmin, password.toCharArray());

        // Configurar la dirección del servidor MongoDB
        String host = "localhost"; // Reemplaza con la dirección de tu servidor
        int port = 27017; // Reemplaza con el puerto de tu servidor

        // Crear la conexión del cliente
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyToClusterSettings(builder ->
                        builder.hosts(Arrays.asList(new ServerAddress(host, port))))
                .credential(credential)
                .codecRegistry(pojoCodecRegistry)
                .build();

        // Cliente de base de datos
        MongoClient mongoClient = MongoClients.create(settings);
        MongoDatabase database = mongoClient.getDatabase(databaseName);

        return database;
    }
}
