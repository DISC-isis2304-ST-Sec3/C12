package uniandes.edu.co.hotelAndes.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelAndes.modelo.Reunion;

import java.util.Collection;

public interface ReunionRepository extends JpaRepository<Reunion, Long> {

    @Query(value = "SELECT * FROM reuniones", nativeQuery = true)
    Collection<Reunion> darReuniones();

    @Query(value = "SELECT * FROM reuniones WHERE id = :id", nativeQuery = true)
    Reunion darReunion(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reuniones (id, horario_inicial, horario_final, reserva_id, nombre, costo, cargado, existe, capacidad, costo_adicional, fecha, hora, duracion) " +
            "VALUES ( reunion_andes_sequence.nextval, :horarioInicial, :horarioFinal, :reservaId, :nombre, :costo, :cargado, :existe, :capacidad, :costoAdicional, :fecha, :hora, :duracion)",
            nativeQuery = true)
    void insertarReunion(@Param("horarioInicial") String horarioInicial, @Param("horarioFinal") String horarioFinal,
                        @Param("reservaId") long reservaId, @Param("nombre") String nombre, @Param("costo") String costo,
                        @Param("cargado") String cargado, @Param("existe") String existe, @Param("capacidad") int capacidad,
                        @Param("costoAdicional") int costoAdicional, @Param("fecha") java.sql.Date fecha,
                        @Param("hora") java.sql.Timestamp hora, @Param("duracion") int duracion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE reuniones SET horario_inicial = :horarioInicial, horario_final = :horarioFinal, " +
            "reserva_id = :reservaId, nombre = :nombre, costo = :costo, cargado = :cargado, existe = :existe, " +
            "capacidad = :capacidad, costo_adicional = :costoAdicional, fecha = :fecha, hora = :hora, duracion = :duracion " +
            "WHERE id = :id", nativeQuery = true)
    void actualizarReunion(@Param("id") long id, @Param("horarioInicial") String horarioInicial, @Param("horarioFinal") String horarioFinal,
                           @Param("reservaId") long reservaId, @Param("nombre") String nombre, @Param("costo") String costo,
                           @Param("cargado") String cargado, @Param("existe") String existe, @Param("capacidad") int capacidad,
                           @Param("costoAdicional") int costoAdicional, @Param("fecha") java.sql.Date fecha,
                           @Param("hora") java.sql.Timestamp hora, @Param("duracion") int duracion);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reuniones WHERE id = :id", nativeQuery = true)
    void eliminarReunion(@Param("id") long id);
}
