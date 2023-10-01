package uniandes.edu.co.hotelAndes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelAndes.modelo.Hotel;
import uniandes.edu.co.hotelAndes.modelo.PlanConsumo;

import java.util.Collection;

public interface PlanesConsumoRepository extends JpaRepository<PlanConsumo, Integer> {

    @Query(value = "SELECT * FROM planes_consumo", nativeQuery = true)
    Collection<PlanConsumo> darPlanesConsumo();

    @Query(value = "SELECT * FROM planes_consumo WHERE id = :id", nativeQuery = true)
    Hotel darPlanconsumo(@Param("id") long id);


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO planes_consumo (id, tipoplan, descuento, hoteles_id, descuento1) VALUES ( hotel_andes_sequence.nextval, :tipoplan, :descuento, :hoteles_id, :descuento1)", nativeQuery = true)
    void insertarPlanConsumo(@Param("tipoplan") String tipoplan, @Param("descuento") Float descuento, @Param("hoteles_id") long hoteles_id);

}
