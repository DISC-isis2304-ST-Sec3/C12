package uniandes.edu.co.hotelAndes.modelo;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reuniones")
public class Reunion extends Servicio {
    private int capacidad;
    private int costoAdicional;
    private Date fecha;
    private Date hora;
    private int duracion;

    public Reunion() {
        
    }

    public Reunion(String horarioInicial, String horarioFinal, Reserva reserva, String nombre, String costo, String cargado, String existe, int capacidad, int costoAdicional, Date fecha, Date hora, int duracion) {
        super(horarioInicial, horarioFinal, reserva, nombre, costo, cargado, existe);
        this.capacidad = capacidad;
        this.costoAdicional = costoAdicional;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(int costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Reunion{" +
                "capacidad=" + capacidad +
                ", costoAdicional=" + costoAdicional +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", duracion=" + duracion +
                "} " + super.toString();
    }
}
