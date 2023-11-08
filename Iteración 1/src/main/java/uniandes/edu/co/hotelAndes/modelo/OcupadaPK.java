package uniandes.edu.co.hotelAndes.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OcupadaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="habitacion_id", referencedColumnName ="id")
    private Habitacion habitacion_id;

    @ManyToOne
    @JoinColumn(name="usuario_id", referencedColumnName ="id")
    private Usuario usuario_id;

    public OcupadaPK(Habitacion habitacion_id, Usuario usuario_id) {
        super();
        this.habitacion_id = habitacion_id;
        this.usuario_id = usuario_id;
    }

    public Habitacion getId_habitacion() {
        return habitacion_id;
    }

    public Usuario getId_usuario() {
        return usuario_id;
    }

    public void setId_habitacion(Habitacion habitacion_id) {
        this.habitacion_id = habitacion_id;
    }

    public void setId_usuario(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    

    
    
}
