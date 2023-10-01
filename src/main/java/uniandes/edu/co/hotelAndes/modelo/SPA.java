package uniandes.edu.co.hotelAndes.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "spas")
public class SPA extends Servicio {
    private int capacidad;

    public SPA() {
        
    }

    public SPA(String horarioInicial, String horarioFinal, Reserva reserva, String nombre, String costo, String cargado, String existe, int capacidad) {
        super(horarioInicial, horarioFinal, reserva, nombre, costo, cargado, existe);
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "SPA{" +
                "capacidad=" + capacidad +
                "} " + super.toString();
    }
}
