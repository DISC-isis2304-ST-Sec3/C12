package uniandes.edu.co.hotelAndes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uniandes.edu.co.hotelAndes.modelo.Hotel;
import uniandes.edu.co.hotelAndes.modelo.Usuario;

import java.util.Collection;

public interface HotelRepository extends JpaRepository<Hotel, Integer> {


    @Query(value = "SELECT * FROM hoteles", nativeQuery = true)
    Collection<Hotel> darHoteles();
}
