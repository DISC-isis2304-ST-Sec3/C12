package uniandes.edu.co.hotelAndes.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelAndes.modelo.Piscina;

import java.util.Collection;

public interface PiscinaRepository extends JpaRepository<Piscina, Long> {

    @Query(value = "SELECT * FROM piscinas", nativeQuery = true)
    Collection<Piscina> darPiscinas();

    @Query(value = "SELECT * FROM piscinas WHERE id = :id", nativeQuery = true)
    Piscina darPiscina(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO piscinas (id, horario_inicial, horario_final, reserva_id, nombre, costo, cargado, existe, capacidad, profundidad, hora_inicio, hora_fin) " +
            "VALUES ( piscina_andes_sequence.nextval, :horarioInicial, :horarioFinal, :reservaId, :nombre, :costo, :cargado, :existe, :capacidad, :profundidad, :horaInicio, :horaFin)",
            nativeQuery = true)
    void insertarPiscina(@Param("horarioInicial") String horarioInicial, @Param("horarioFinal") String horarioFinal,
                        @Param("reservaId") long reservaId, @Param("nombre") String nombre, @Param("costo") String costo,
                        @Param("cargado") String cargado, @Param("existe") String existe, @Param("capacidad") int capacidad,
                        @Param("profundidad") String profundidad, @Param("horaInicio") String horaInicio,
                        @Param("horaFin") String horaFin);

    @Modifying
    @Transactional
    @Query(value = "UPDATE piscinas SET horario_inicial = :horarioInicial, horario_final = :horarioFinal, " +
            "reserva_id = :reservaId, nombre = :nombre, costo = :costo, cargado = :cargado, existe = :existe, " +
            "capacidad = :capacidad, profundidad = :profundidad, hora_inicio = :horaInicio, hora_fin = :horaFin " +
            "WHERE id = :id", nativeQuery = true)
    void actualizarPiscina(@Param("id") long id, @Param("horarioInicial") String horarioInicial, @Param("horarioFinal") String horarioFinal,
                           @Param("reservaId") long reservaId, @Param("nombre") String nombre, @Param("costo") String costo,
                           @Param("cargado") String cargado, @Param("existe") String existe, @Param("capacidad") int capacidad,
                           @Param("profundidad") String profundidad, @Param("horaInicio") String horaInicio,
                           @Param("horaFin") String horaFin);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM piscinas WHERE id = :id", nativeQuery = true)
    void eliminarPiscina(@Param("id") long id);
}
