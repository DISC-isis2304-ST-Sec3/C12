package uniandes.edu.co.hotelAndes.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelAndes.modelo.Gimnasio;

import java.util.Collection;

public interface GimnasioRepository extends JpaRepository<Gimnasio, Long> {

    @Query(value = "SELECT * FROM gimnasios", nativeQuery = true)
    Collection<Gimnasio> darGimnasios();

    @Query(value = "SELECT * FROM gimnasios WHERE id = :id", nativeQuery = true)
    Gimnasio darGimnasio(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO gimnasios (id, horario_inicial, horario_final, reserva_id, nombre, costo, cargado, existe, capacidad, maquinas, hora_inicio, hora_fin) " +
            "VALUES ( gimnasio_andes_sequence.nextval, :horarioInicial, :horarioFinal, :reservaId, :nombre, :costo, :cargado, :existe, :capacidad, :maquinas, :horaInicio, :horaFin)",
            nativeQuery = true)
    void insertarGimnasio(@Param("horarioInicial") String horarioInicial, @Param("horarioFinal") String horarioFinal,
                        @Param("reservaId") long reservaId, @Param("nombre") String nombre, @Param("costo") String costo,
                        @Param("cargado") String cargado, @Param("existe") String existe, @Param("capacidad") int capacidad,
                        @Param("maquinas") String maquinas, @Param("horaInicio") String horaInicio,
                        @Param("horaFin") String horaFin);

    @Modifying
    @Transactional
    @Query(value = "UPDATE gimnasios SET horario_inicial = :horarioInicial, horario_final = :horarioFinal, " +
            "reserva_id = :reservaId, nombre = :nombre, costo = :costo, cargado = :cargado, existe = :existe, " +
            "capacidad = :capacidad, maquinas = :maquinas, hora_inicio = :horaInicio, hora_fin = :horaFin " +
            "WHERE id = :id", nativeQuery = true)
    void actualizarGimnasio(@Param("id") long id, @Param("horarioInicial") String horarioInicial, @Param("horarioFinal") String horarioFinal,
                           @Param("reservaId") long reservaId, @Param("nombre") String nombre, @Param("costo") String costo,
                           @Param("cargado") String cargado, @Param("existe") String existe, @Param("capacidad") int capacidad,
                           @Param("maquinas") String maquinas, @Param("horaInicio") String horaInicio,
                           @Param("horaFin") String horaFin);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM gimnasios WHERE id = :id", nativeQuery = true)
    void eliminarGimnasio(@Param("id") long id);
}
