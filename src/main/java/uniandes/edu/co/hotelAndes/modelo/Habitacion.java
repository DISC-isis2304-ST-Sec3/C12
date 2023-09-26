package uniandes.edu.co.hotelAndes.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private long numero;

    private String disponible;

    @ManyToOne
    @JoinColumn(name="hotel_id",referencedColumnName = "id")
    private Hotel hotel_id;

    @ManyToOne
    @JoinColumn(name="tipo_habitacion_id",referencedColumnName = "id")
    private Tipo_habitacion tipo_habitacion_id;

    @ManyToOne
    @JoinColumn(name="reserva_id",referencedColumnName = "id")
    private Reserva reserva_id;

    public Habitacion() {;}

    public Habitacion(long numero, String disponible, Hotel hotel_id, Tipo_habitacion tipo_habitacion_id, Reserva reserva_id) {
        this.numero = numero;
        this.disponible = disponible;
        this.hotel_id = hotel_id;
        this.tipo_habitacion_id = tipo_habitacion_id;
        this.reserva_id = reserva_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getDisponible() {
        return disponible;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public Hotel getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Hotel hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Tipo_habitacion getTipo_habitacion_id() {
        return tipo_habitacion_id;
    }

    public void setTipo_habitacion_id(Tipo_habitacion tipo_habitacion_id) {
        this.tipo_habitacion_id = tipo_habitacion_id;
    }

    public Reserva getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(Reserva reserva_id) {
        this.reserva_id = reserva_id;
    }

    @Override
    public String toString() {
        return "Habitacion{" +
                "id=" + id +
                ", numero=" + numero +
                ", disponible='" + disponible + '\'' +
                ", hotel_id=" + hotel_id +
                ", tipo_habitacion_id=" + tipo_habitacion_id +
                ", reserva_id=" + reserva_id +
                '}';
    }
}
