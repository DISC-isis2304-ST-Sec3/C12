package uniandes.edu.co.hotelAndes.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="ocupadas")
public class Ocupada {
    
    @EmbeddedId
    private OcupadaPK pk;

    public Ocupada (Habitacion habitacion_id, Usuario usuario_id) {
        this.pk = new OcupadaPK(habitacion_id, usuario_id);
    }

    public Ocupada(){;}

    public OcupadaPK getPk() {
        return pk;
    }

    public void setPk(OcupadaPK pk) {
        this.pk = pk;
    }

    
    
}
