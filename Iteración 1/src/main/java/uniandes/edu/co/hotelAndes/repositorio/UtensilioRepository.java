package uniandes.edu.co.hotelAndes.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import uniandes.edu.co.hotelAndes.modelo.Utensilio;

import java.util.Collection;

public interface UtensilioRepository extends JpaRepository<Utensilio, Long> {

    @Query(value = "SELECT * FROM utensilios", nativeQuery = true)
    Collection<Utensilio> darUtensilios();

    @Query(value = "SELECT * FROM utensilios WHERE id = :id", nativeQuery = true)
    Utensilio darUtensilio(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO utensilios (id, horario_inicial, horario_final, reserva_id, nombre, costo, cargado, existe, devuelto, estado) " +
            "VALUES ( utensilio_andes_sequence.nextval, :horarioInicial, :horarioFinal, :reservaId, :nombre, :costo, :cargado, :existe, :devuelto, :estado)",
            nativeQuery = true)
    void insertarUtensilio(@Param("horarioInicial") String horarioInicial, @Param("horarioFinal") String horarioFinal,
                        @Param("reservaId") long reservaId, @Param("nombre") String nombre, @Param("costo") String costo,
                        @Param("cargado") String cargado, @Param("existe") String existe, @Param("devuelto") boolean devuelto,
                        @Param("estado") boolean estado);

    @Modifying
    @Transactional
    @Query(value = "UPDATE utensilios SET horario_inicial = :horarioInicial, horario_final = :horarioFinal, " +
            "reserva_id = :reservaId, nombre = :nombre, costo = :costo, cargado = :cargado, existe = :existe, " +
            "devuelto = :devuelto, estado = :estado WHERE id = :id", nativeQuery = true)
    void actualizarUtensilio(@Param("id") long id, @Param("horarioInicial") String horarioInicial, @Param("horarioFinal") String horarioFinal,
                           @Param("reservaId") long reservaId, @Param("nombre") String nombre, @Param("costo") String costo,
                           @Param("cargado") String cargado, @Param("existe") String existe, @Param("devuelto") boolean devuelto,
                           @Param("estado") boolean estado);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM utensilios WHERE id = :id", nativeQuery = true)
    void eliminarUtensilio(@Param("id") long id);
}
