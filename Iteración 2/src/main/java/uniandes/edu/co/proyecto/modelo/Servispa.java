package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="servispas")

public class Servispa {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idservispas;

    private Integer duracion;
    private Integer costo;
    private Date fecha;
    //FK
    @ManyToOne
    @JoinColumn(name="servicios", referencedColumnName = "idservicio")
    private Spa spa;


    // Constructor
    public Servispa(Integer duracion, Integer costo, Date fecha, Spa spa)
    {
        this.duracion = duracion;
        this.costo = costo;
        this.fecha = fecha;
        this.spa = spa;
    }


    public Servispa(){;}


    // Getters
    public Integer getIdservispas(){
        return idservispas;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public Integer getCosto() {
        return costo;
    }

    public Date getFecha() {
        return fecha;
    }

    public Spa getSpa() {
        return spa;
    }


    // Setters
    public void setIdservispas(Integer idservispas){
        this.idservispas = idservispas;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setSpa(Spa spa) {
        this.spa = spa;
    }

}
