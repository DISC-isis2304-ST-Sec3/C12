package uniandes.edu.co.hotelAndes.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelAndes.modelo.Servicio_SPA;

import java.util.Collection;

public interface Servicio_SPARepository extends JpaRepository<Servicio_SPA, Long> {

    @Query(value = "SELECT * FROM servicios_spa", nativeQuery = true)
    Collection<Servicio_SPA> darServiciosSPA();

    @Query(value = "SELECT * FROM servicios_spa WHERE id = :id", nativeQuery = true)
    Servicio_SPA darServicioSPA(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO servicios_spa (id, duracion, costo, fecha, hora, spa_id) " +
            "VALUES ( servicio_spa_andes_sequence.nextval, :duracion, :costo, :fecha, :hora, :spaId)",
            nativeQuery = true)
    void insertarServicioSPA(@Param("duracion") int duracion, @Param("costo") int costo,
                            @Param("fecha") java.sql.Date fecha, @Param("hora") java.sql.Timestamp hora,
                            @Param("spaId") long spaId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE servicios_spa SET duracion = :duracion, costo = :costo, fecha = :fecha, " +
            "hora = :hora, spa_id = :spaId WHERE id = :id", nativeQuery = true)
    void actualizarServicioSPA(@Param("id") long id, @Param("duracion") int duracion, @Param("costo") int costo,
                               @Param("fecha") java.sql.Date fecha, @Param("hora") java.sql.Timestamp hora,
                               @Param("spaId") long spaId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM servicios_spa WHERE id = :id", nativeQuery = true)
    void eliminarServicioSPA(@Param("id") long id);
}
