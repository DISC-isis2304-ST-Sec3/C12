package uniandes.edu.co.proyecto.repositorio;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{}")
    List<Product> findAllProducts();

    @Query("{ 'name' : ?0 }")
    Product findByName(String name);


}
