package uniandes.edu.co.hotelAndes.modelo;

import java.io.Serializable;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class CuentaPK implements Serializable {

    @ManyToOne
    @JoinColumn(name="id_habitacion", referencedColumnName = "id")
    private Habitacion id_habitacion;

    @ManyToOne
    @JoinColumn(name="id_servicio", referencedColumnName = "id")
    private Servicio id_servicio;

    public CuentaPK(Habitacion id_habitacion, Servicio id_servicio) {
        super();
        this.id_habitacion = id_habitacion;
        this.id_servicio = id_servicio;
    }

    public Habitacion getId_habitacion() {
        return id_habitacion;
    }

    public Servicio getId_servicio() {
        return id_servicio;
    }

    public void setId_habitacion(Habitacion id_habitacion) {
        this.id_habitacion = id_habitacion;
    }

    public void setId_servicio(Servicio id_servicio) {
        this.id_servicio = id_servicio;
    }

    
}
