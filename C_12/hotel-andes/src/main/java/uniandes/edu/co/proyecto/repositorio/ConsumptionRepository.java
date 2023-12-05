package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Consumption;

public interface ConsumptionRepository extends MongoRepository<Consumption, String> {

    @Query("{}")
    List<Consumption> findAllConsumptions();

    // READ
    @Query("{ '_id' : ?0 }")
    Consumption findByid(String id);

    // DELETE
    @Query(value = "{ '_id' : ?0 }", delete = true)
    void deleteByid(String id);

}
