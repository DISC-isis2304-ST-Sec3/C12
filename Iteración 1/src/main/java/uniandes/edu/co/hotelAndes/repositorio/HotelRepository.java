package uniandes.edu.co.hotelAndes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelAndes.modelo.Hotel;
import uniandes.edu.co.hotelAndes.modelo.Usuario;

import java.util.Collection;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {


    @Query(value = "SELECT * FROM hoteles", nativeQuery = true)
    Collection<Hotel> darHoteles();

    @Query(value = "SELECT * FROM hoteles WHERE id = :id", nativeQuery = true)
    Hotel darHotel(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO hoteles (id, nombre, nit) VALUES ( hotel_andes_sequence.nextval, :nombre, :nit)", nativeQuery = true)
    void insertarHotel(@Param("nombre") String nombre, @Param("nit") long nit);

    @Modifying
    @Transactional
    @Query(value = "UPDATE hoteles SET nombre = :nombre, nit = :nit WHERE id = :id", nativeQuery = true)
    void actualizarHotel(@Param("id") long id, @Param("nombre") String nombre, @Param("nit") long nit);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM hoteles WHERE id = :id", nativeQuery = true)
    void eliminarHotel(@Param("id") long id);


}
