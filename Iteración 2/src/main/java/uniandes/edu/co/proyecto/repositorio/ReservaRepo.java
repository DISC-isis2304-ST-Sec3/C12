package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cuenta;
import uniandes.edu.co.proyecto.modelo.Reserva;

public interface ReservaRepo extends JpaRepository <Reserva, Integer> {

    // Creation
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO reservas (idreserva, horareserva, cuenta) VALUES (parranderos_sequence.nextval, :horareserva, :cuenta)", nativeQuery = true)
    void insertarReserva(@Param("horareserva") Date horareserva, @Param("cuenta") Cuenta cuenta);


    // Read
    @Query(value = "SELECT * FROM reservas", nativeQuery = true)
    Collection<Reserva> darReservas();

    @Query(value = "SELECT * FROM reservas WHERE idreserva = :idreserva", nativeQuery = true)
    Reserva darReserva(@Param("idreserva") Integer idreserva);


    // Update
    @Modifying
    @Transactional
    @Query(value = "UPDATE reservas SET horareserva=:horareserva, cuenta=:cuenta WHERE idreserva=:idreserva", nativeQuery = true)
    void actualizarReserva(@Param("idreserva") Integer idreserva, @Param("horareserva") Date horareserva, @Param("cuenta") Cuenta cuenta);


    // Delete
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM reservas WHERE idreserva =: idreserva", nativeQuery = true)
    void eliminarReserva(@Param("idreserva") Integer idreserva);
}
