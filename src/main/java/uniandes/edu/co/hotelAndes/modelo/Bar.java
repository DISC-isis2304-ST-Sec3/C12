package uniandes.edu.co.hotelAndes.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="bares")
public class Bar extends Servicio{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String estilo;

    @ManyToOne
    @JoinColumn(name="ServicioID", referencedColumnName = "id")
    private Servicio servicioID;

    @ManyToOne
    @JoinColumn(name="ProductosProductosID", referencedColumnName = "id")
    private Producto productoProductoID;

    public Bar(){;}

    public Bar(Integer id, String estilo, Producto productoProductoID)
    {
        this.id = id;
        this.estilo = estilo;
        this.productoProductoID = productoProductoID;
    }

}
