package uniandes.edu.co.hotelAndes.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelAndes.modelo.Ocupada;

import java.util.Collection;


public interface OcupadaRepository  extends JpaRepository<Ocupada, Integer>{

    @Query(value = "SELECT * FROM cuentas", nativeQuery = true)
    Collection<Ocupada> darCuentas();

    @Query(value = "SELECT * FROM cuentas WHERE habitaciones_id = :habitaciones_id AND usuarios_id = :usuarios_id", nativeQuery = true)
    Ocupada darOcupadasPorId(@Param("habitaciones_id") Integer habitaciones_id, @Param("usuarios_id") Integer usuarios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gustan WHERE habitaciones_id = :habitaciones_id AND usuarios_id = :usuarios_id", nativeQuery = true)
    void eliminarOcupadas(@Param("habitaciones_id") Integer habitaciones_id, @Param("usuarios_id") Integer usuarios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gustan SET habitaciones_id = :habitaciones_id_actualizado, usuarios_id = :usuarios_id_actualizado WHERE habitaciones_id = :habitaciones_id AND usuarios_id = :usuarios_id", nativeQuery = true)
    void actualizarOcupadas(@Param("habitaciones_id") Integer habitaciones_id, @Param("usuarios_id") Integer usuarios_id, @Param("habitaciones_id_actualizado") Integer habitaciones_id_actualizado, @Param("usuarios_id_actualizado") Integer usuarios_id_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gustan (habitaciones_id, usuarios_id) VALUES (:habitaciones_id, :usuarios_id)", nativeQuery = true)
    void insertarOcupadas(@Param("habitaciones_id") Integer habitaciones_id, @Param("usuarios_id") Integer usuarios_id);

}
