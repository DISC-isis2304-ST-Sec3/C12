package uniandes.edu.co.hotelAndes.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class OcupadaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_habitacion", referencedColumnName ="id")
    private Habitacion id_habitacion;

    @ManyToOne
    @JoinColumn(name="id_usuario", referencedColumnName ="id")
    private Usuario id_usuario;

    public OcupadaPK(Habitacion id_habitacion, Usuario id_usuario) {
        super();
        this.id_habitacion = id_habitacion;
        this.id_usuario = id_usuario;
    }

    public Habitacion getId_habitacion() {
        return id_habitacion;
    }

    public Usuario getId_usuario() {
        return id_usuario;
    }

    public void setId_habitacion(Habitacion id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public void setId_usuario(Usuario id_usuario) {
        this.id_usuario = id_usuario;
    }

    

    
    
}
