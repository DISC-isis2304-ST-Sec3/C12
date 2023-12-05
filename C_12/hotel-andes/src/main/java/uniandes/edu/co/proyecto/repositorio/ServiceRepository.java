package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import uniandes.edu.co.proyecto.modelo.Service;

import java.util.List;

public interface ServiceRepository extends MongoRepository<Service, String> {

    //CREATE
    Service save(Service service);
   
    // READ
    @Query("{ '_id' : ?0 }")
    Service findByid(String id);

    @Query("{}")
    List<Service> findAllServices();

    // DELETE
    @Query(value = "{ '_id' : ?0 }", delete = true)
    void deleteByid(String id);

    //UPDATE
    @Query("{ '_id' : ?0 }")
    Service updateServicio(String id, Service service);

}
