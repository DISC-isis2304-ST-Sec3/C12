package uniandes.edu.co.hotelAndes.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="tiendas")
public class Tienda extends Servicio{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String tipo;

    @ManyToOne
    @JoinColumn(name="ServicioID", referencedColumnName = "id")
    private Servicio servicioID;

    @OneToMany
    @JoinColumn(name="ProductosProductosID", referencedColumnName = "id")
    private Producto productoProductoID;

    public Tienda(){;}

    public Tienda(Integer id, String tipo, Producto productoProductoID)
    {
        this.id = id;
        this.tipo = tipo;
        this.productoProductoID = productoProductoID;
    }

}
