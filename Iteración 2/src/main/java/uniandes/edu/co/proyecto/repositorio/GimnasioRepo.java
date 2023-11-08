package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Gimnasio;

public interface GimnasioRepo extends JpaRepository <Gimnasio, Integer> {

    // Creation
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios (idservicio, capacidad, maquinas) VALUES (parranderos_sequence.nextval, :capacidad, :maquinas)", nativeQuery = true)
    void insertarGimnasio(@Param("capacidad") Integer capacidad, @Param("maquinas") String maquinas);


    // Read
    @Query(value = "SELECT * FROM gimnasios", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasios WHERE idservicio = :idservicio", nativeQuery = true)
    Gimnasio darGimnasio(@Param("idservicio") Integer idservicio);


    // Update
    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET capacidad=:capacidad, maquinas=:maquinas WHERE idservicio=:idservicio", nativeQuery = true)
    void actualizarGimnasio(@Param("idservicio") Integer idservicio, @Param("capacidad") Integer capacidad,
                               @Param("maquinas") String maquinas);


    // Delete
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasios WHERE idservicio =: idservicio", nativeQuery = true)
    void eliminarGimnasio(@Param("idservicio") Integer idservicio);
}
