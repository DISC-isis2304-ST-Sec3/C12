package uniandes.edu.co.hotelAndes.modelo;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "servicios_spa")
public class Servicio_SPA {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int duracion;
    private int costo;
    private Date fecha;
    private Date hora;

    @OneToOne
    @JoinColumn(name = "spa_id", referencedColumnName = "id")
    private SPA spa;

    public Servicio_SPA() {
        
    }

    public Servicio_SPA(int duracion, int costo, Date fecha, Date hora, SPA spa) {
        this.duracion = duracion;
        this.costo = costo;
        this.fecha = fecha;
        this.hora = hora;
        this.spa = spa;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
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

    public SPA getSpa() {
        return spa;
    }

    public void setSpa(SPA spa) {
        this.spa = spa;
    }

    @Override
    public String toString() {
        return "Servicio_SPA{" +
                "id=" + id +
                ", duracion=" + duracion +
                ", costo=" + costo +
                ", fecha=" + fecha +
                ", hora=" + hora +
                ", spa=" + spa +
                '}';
    }
}
