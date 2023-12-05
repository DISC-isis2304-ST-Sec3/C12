package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import uniandes.edu.co.proyecto.modelo.RoomType;

import java.util.List;

public interface RoomTypeRepository extends MongoRepository<RoomType, String> {

    // CREATE
    RoomType save(RoomType tipoHabitacion);
    
    // READ
    @Query("{ 'name' : ?0 }")
    RoomType findByName(String name);

    @Query("{}")
    List<RoomType> findAllRoomTypes();

    // DELETE
    @Query(value = "{ 'name' : ?0 }", delete = true)
    void deleteByName(String name);

    @Query(value = "{ '_id' : ?0 }", delete = true)
    void deleteById(String id);

    @Query("{_id: ?0}")
    @Update("{$push:{roomElements:{name:?1, cost:?2}}}")
    void aniadirBebidaABar(String id_roomType, String name, Integer cost);


   

}
