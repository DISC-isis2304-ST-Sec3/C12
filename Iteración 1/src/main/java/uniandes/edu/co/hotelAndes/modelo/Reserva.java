package uniandes.edu.co.hotelAndes.modelo;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String horaReserva;

    private Date fechaInicio;

    private Date fechaFin;

    public Reserva() {;}

    public Reserva(long id, String horaReserva, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.horaReserva = horaReserva;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(String horaReserva) {
        this.horaReserva = horaReserva;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", horaReserva='" + horaReserva + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                '}';
    }
}
