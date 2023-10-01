package uniandes.edu.co.hotelAndes.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ocupadas")
public class Ocupada {
    
    @EmbeddedId
    private OcupadaPK pk;

    public Ocupada (Habitacion id_habitacion, Usuario id_usuario) {
        this.pk = new OcupadaPK(id_habitacion, id_usuario);
    }

    public Ocupada(){;}

    public OcupadaPK getPk() {
        return pk;
    }

    public void setPk(OcupadaPK pk) {
        this.pk = pk;
    }

    
    
}
