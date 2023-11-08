package uniandes.edu.co.hotelAndes.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelAndes.modelo.SPA;

import java.util.Collection;

public interface SPARepository extends JpaRepository<SPA, Long> {

    @Query(value = "SELECT * FROM spas", nativeQuery = true)
    Collection<SPA> darSPAs();

    @Query(value = "SELECT * FROM spas WHERE id = :id", nativeQuery = true)
    SPA darSPA(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO spas (id, horario_inicial, horario_final, reserva_id, nombre, costo, cargado, existe, capacidad) " +
            "VALUES ( spa_andes_sequence.nextval, :horarioInicial, :horarioFinal, :reservaId, :nombre, :costo, :cargado, :existe, :capacidad)",
            nativeQuery = true)
    void insertarSPA(@Param("horarioInicial") String horarioInicial, @Param("horarioFinal") String horarioFinal,
                        @Param("reservaId") long reservaId, @Param("nombre") String nombre, @Param("costo") String costo,
                        @Param("cargado") String cargado, @Param("existe") String existe, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "UPDATE spas SET horario_inicial = :horarioInicial, horario_final = :horarioFinal, " +
            "reserva_id = :reservaId, nombre = :nombre, costo = :costo, cargado = :cargado, existe = :existe, " +
            "capacidad = :capacidad " +
            "WHERE id = :id", nativeQuery = true)
    void actualizarSPA(@Param("id") long id, @Param("horarioInicial") String horarioInicial, @Param("horarioFinal") String horarioFinal,
                           @Param("reservaId") long reservaId, @Param("nombre") String nombre, @Param("costo") String costo,
                           @Param("cargado") String cargado, @Param("existe") String existe, @Param("capacidad") int capacidad);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM spas WHERE id = :id", nativeQuery = true)
    void eliminarSPA(@Param("id") long id);
}
