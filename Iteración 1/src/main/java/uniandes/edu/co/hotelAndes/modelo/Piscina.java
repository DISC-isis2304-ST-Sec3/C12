package uniandes.edu.co.hotelAndes.modelo;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "piscinas")
public class Piscina extends Servicio {
    private int capacidad;
    private String profundidad;
    private Date horaInicio;
    private Date horaFin;

    public Piscina() {
        
    }

    public Piscina(String horarioInicial, String horarioFinal, Reserva reserva, String nombre, String costo, String cargado, String existe, int capacidad, String profundidad, Date horaInicio, Date horaFin) {
        super(horarioInicial, horarioFinal, reserva, nombre, costo, cargado, existe);
        this.capacidad = capacidad;
        this.profundidad = profundidad;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(String profundidad) {
        this.profundidad = profundidad;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "Piscina{" +
                "capacidad=" + capacidad +
                ", profundidad='" + profundidad + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                "} " + super.toString();
    }
}

