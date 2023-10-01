package uniandes.edu.co.hotelAndes.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="restaurantes")
public class Restaurante extends Servicio{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String estilo;

    @ManyToOne
    @JoinColumn(name="ServicioID", referencedColumnName = "id")
    private Servicio servicioID;

    @OneToMany
    @JoinColumn(name="ProductosProductosID", referencedColumnName = "id")
    private Producto productoProductoID;

    public Restaurante(){;}

    public Restaurante(Integer id, String estilo, Producto productoProductoID)
    {
        this.id = id;
        this.estilo = estilo;
        this.productoProductoID = productoProductoID;
    }

}
