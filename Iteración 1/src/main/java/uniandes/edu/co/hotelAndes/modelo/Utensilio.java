package uniandes.edu.co.hotelAndes.modelo;
import jakarta.persistence.*;

@Entity
@Table(name = "utensilios")
public class Utensilio extends Servicio {
    private boolean devuelto;
    private boolean estado;

    public Utensilio() {
    
    }

    public Utensilio(String horarioInicial, String horarioFinal, Reserva reserva, String nombre, String costo, String cargado, String existe, boolean devuelto, boolean estado) {
        super(horarioInicial, horarioFinal, reserva, nombre, costo, cargado, existe);
        this.devuelto = devuelto;
        this.estado = estado;
    }

    public boolean getDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Utensilio{" +
                "devuelto=" + devuelto +
                ", estado=" + estado +
                "} " + super.toString();
    }
}
