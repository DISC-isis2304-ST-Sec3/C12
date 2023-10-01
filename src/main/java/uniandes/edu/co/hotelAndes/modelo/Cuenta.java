package uniandes.edu.co.hotelAndes.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="cuentas")
public class Cuenta {

    @EmbeddedId
    private CuentaPK pk;

    public Cuenta (Habitacion id_habitacion, Servicio id_servicio){
        this.pk = new CuentaPK(id_habitacion, id_servicio);

    }

    public Cuenta(){;}

    public CuentaPK getPk() {
        return pk;
    }

    public void setPk(CuentaPK pk) {
        this.pk = pk;
    }

    
}
