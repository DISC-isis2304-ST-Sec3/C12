package uniandes.edu.co.hotelAndes.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.hotelAndes.modelo.Cuenta;

import java.util.Collection;


public interface CuentaRepository  extends JpaRepository<Cuenta, Integer>{

    @Query(value = "SELECT * FROM cuentas", nativeQuery = true)
    Collection<Cuenta> darCuentas();

    @Query(value = "SELECT * FROM cuentas WHERE habitaciones_id = :habitaciones_id AND servicios_id = :servicios_id", nativeQuery = true)
    Cuenta darCuentasPorId(@Param("habitaciones_id") Integer habitaciones_id, @Param("servicios_id") Integer servicios_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gustan WHERE habitaciones_id = :habitaciones_id AND servicios_id = :servicios_id", nativeQuery = true)
    void eliminarCuentas(@Param("habitaciones_id") Integer habitaciones_id, @Param("servicios_id") Integer servicios_id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gustan SET habitaciones_id = :habitaciones_id_actualizado, servicios_id = :servicios_id_actualizado WHERE habitaciones_id = :habitaciones_id AND servicios_id = :servicios_id", nativeQuery = true)
    void actualizarCuentas(@Param("habitaciones_id") Integer habitaciones_id, @Param("servicios_id") Integer servicios_id, @Param("habitaciones_id_actualizado") Integer habitaciones_id_actualizado, @Param("servicios_id_actualizado") Integer servicios_id_actualizado);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gustan (habitaciones_id, servicios_id) VALUES (:habitaciones_id, :servicios_id)", nativeQuery = true)
    void insertarCuentas(@Param("habitaciones_id") Integer habitaciones_id, @Param("servicios_id") Integer servicios_id);

}
