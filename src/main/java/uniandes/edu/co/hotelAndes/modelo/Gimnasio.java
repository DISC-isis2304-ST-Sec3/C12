package uniandes.edu.co.hotelAndes.modelo;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "gimnasios")
public class Gimnasio extends Servicio {
    private int capacidad;
    private String maquinas;
    private Date horaInicio;
    private Date horaFin;

    public Gimnasio() {
        
    }

    public Gimnasio(String horarioInicial, String horarioFinal, Reserva reserva, String nombre, String costo, String cargado, String existe, int capacidad, String maquinas, Date horaInicio, Date horaFin) {
        super(horarioInicial, horarioFinal, reserva, nombre, costo, cargado, existe);
        this.capacidad = capacidad;
        this.maquinas = maquinas;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(String maquinas) {
        this.maquinas = maquinas;
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
        return "Gimnasio{" +
                "capacidad=" + capacidad +
                ", maquinas='" + maquinas + '\'' +
                ", horaInicio=" + horaInicio +
                ", horaFin=" + horaFin +
                "} " + super.toString();
    }
}
