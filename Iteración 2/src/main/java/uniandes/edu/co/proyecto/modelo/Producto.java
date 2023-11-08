package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")

public class Producto {

    // Atributos
    @Id //PK
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idproducto;

    private String nombre;
    private Integer precio;
    //FK
    @ManyToOne
    @JoinColumn(name="bar", referencedColumnName = "idservicio")
    private Bar bar;
    @ManyToOne
    @JoinColumn(name="restaurante", referencedColumnName = "idservicio")
    private Restaurante restaurante;
    @ManyToOne
    @JoinColumn(name="tienda", referencedColumnName = "idservicio")
    private Tienda tienda;


    // Constructor
    public Producto(String nombre, Integer precio, Bar bar, Restaurante restaurante, Tienda tienda)
    {
        this.nombre = nombre;
        this.precio = precio;
        this.bar = bar;
        this.restaurante = restaurante;
        this.tienda = tienda;
    }


    public Producto(){;}


    // Getters
    public Integer getIdproducto(){
        return idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public Bar getBar() {
        return bar;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public Tienda getTienda() {
        return tienda;
    }


    // Setters
    public void setIdproducto(Integer idproducto){
        this.idproducto = idproducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public void setBar(Bar bar) {
        this.bar = bar;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

}
