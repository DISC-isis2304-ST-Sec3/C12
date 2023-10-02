package uniandes.edu.co.hotelAndes.modelo;
<<<<<<< Updated upstream
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "conferencias")
public class Conferencia extends Servicio {
    private int capacidad;
    private Date fecha;
    private Date hora;
    private int duracion;

    public Conferencia(int capacidad, Date fecha, Date hora, int duracion) {
        this.capacidad = capacidad;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
    }

    public Conferencia() {;}
    
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
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
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", duracion=" + duracion +
                "} " + super.toString();
    }
=======

public class Conferencia {
    
>>>>>>> Stashed changes
}
