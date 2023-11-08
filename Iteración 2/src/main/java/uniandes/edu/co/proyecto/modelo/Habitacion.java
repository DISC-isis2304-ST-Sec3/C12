package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="habitaciones")

public class Habitacion {

    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idhabitacion;

    private Integer numhabitacion;
    private String disponible;
    private Integer precionoche;
    //FK
    @ManyToOne
    @JoinColumn(name="hoteles", referencedColumnName = "idhotel")
    private Hotel hotel;
    @ManyToOne
    @JoinColumn(name="tipos", referencedColumnName = "idtipo")
    private Tipo tipo;
    @ManyToOne
    @JoinColumn(name = "alojamientos", referencedColumnName = "idalojamiento")
    private Alojamiento alojamiento;


    // Constructor
    public Habitacion(Integer numhabitacion, String disponible, Integer precionoche, Hotel hotel, Tipo tipo, Alojamiento alojamiento)
    {
        this.numhabitacion = numhabitacion;
        this.disponible = disponible;
        this.precionoche = precionoche;
        this.hotel = hotel;
        this.tipo = tipo;
        this.alojamiento = alojamiento;
    }


    public Habitacion(){;}


    // Getters
    public Integer getIdhabitacion(){
        return idhabitacion;
    }

    public Integer getNumhabitacion() {
        return numhabitacion;
    }

    public String getDisponible() {
        return disponible;
    }

    public Integer getPrecionoche() {
        return precionoche;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public Alojamiento getAlojamiento() {
        return alojamiento;
    }


    // Setters
    public void setIdhabitacion(Integer idhabitacion){
        this.idhabitacion = idhabitacion;
    }

    public void setNumhabitacion(Integer numhabitacion) {
        this.numhabitacion = numhabitacion;
    }

    public void setDisponible(String disponible) {
        this.disponible = disponible;
    }

    public void setPrecionoche(Integer precionoche) {
        this.precionoche = precionoche;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void setAlojamiento(Alojamiento alojamiento) {
        this.alojamiento = alojamiento;
    }

}
