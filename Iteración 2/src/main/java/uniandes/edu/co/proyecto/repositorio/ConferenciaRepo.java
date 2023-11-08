package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Conferencia;

public interface ConferenciaRepo extends JpaRepository <Conferencia, Integer> {

    // Creation
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO conferencias (idservicio, capacidad, fecha, hora, duracion) VALUES (parranderos_sequence.nextval, :capacidad, :fecha, :hora, :duracion)", nativeQuery = true)
    void insertarConferencia(@Param("capacidad") Integer capacidad, @Param("fecha") Date fecha, 
                            @Param("hora") Time hora, @Param("duracion") Integer duracion);


    // Read
    @Query(value = "SELECT * FROM conferencias", nativeQuery = true)
    Collection<Conferencia> darConferencias();

    @Query(value = "SELECT * FROM conferencias WHERE idservicio = :idservicio", nativeQuery = true)
    Conferencia darConferencia(@Param("idservicio") Integer idservicio);


    // Update
    @Modifying
    @Transactional
    @Query(value = "UPDATE conferencias SET capacidad=:capacidad, fecha=:fecha, hora=:hora, duracion=:duracion WHERE idservicio=:idservicio", nativeQuery = true)
    void actualizarConferencia(@Param("idservicio") Integer idservicio, @Param("capacidad") Integer capacidad,
                               @Param("fecha") Date fecha, @Param("hora") Time hora, @Param("duracion") Integer duracion);


    // Delete
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM conferencias WHERE idservicio =: idservicio", nativeQuery = true)
    void eliminarConferencia(@Param("idservicio") Integer idservicio);
}
