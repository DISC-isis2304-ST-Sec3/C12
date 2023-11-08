package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Alojamiento;
import uniandes.edu.co.proyecto.modelo.Plan;

public interface AlojamientoRepo extends JpaRepository <Alojamiento, Integer> {

    // Creation
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO alojamientos (idalojamiento, activa, checkin, checkout, acompanantes, plan) VALUES (parranderos_sequence.nextval, :activa, :checkin, :checkout, :acompanantes, :plan)", nativeQuery = true)
    void insertarAlojamiento(@Param("activa") String activa, @Param("checkin") Date checkin, @Param("checkout") Date checkout, 
                            @Param("acompanantes")Integer acompanantes, @Param("plan") Plan plan);


    // Read
    @Query(value = "SELECT * FROM alojamientos", nativeQuery = true)
    Collection<Alojamiento> darAlojamientos();

    @Query(value = "SELECT * FROM alojamientos WHERE idalojamiento = :idalojamiento", nativeQuery = true)
    Alojamiento darAlojamiento(@Param("idalojamiento") int idalojamiento);


    // Update
    @Modifying
    @Transactional
    @Query(value = "UPDATE alojamientos SET activa=:activa, checkin=:checkin, checkout=:checkout, acompanantes=:acompanantes, plan=:plan WHERE idalojamiento=:idalojamiento", nativeQuery = true)
    void actualizarAlojamiento(@Param("idalojamiento") int idalojamiento, @Param("activa") String activa, @Param("checkin") Date checkin, 
                            @Param("checkout") Date checkout, @Param("acompanantes")Integer acompanantes, @Param("plan") Plan plan);


    // Delete
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM alojamientos WHERE idalojamiento =: idalojamiento", nativeQuery = true)
    void eliminarAlojamiento(@Param("idalojamiento") int idalojamiento);

}


