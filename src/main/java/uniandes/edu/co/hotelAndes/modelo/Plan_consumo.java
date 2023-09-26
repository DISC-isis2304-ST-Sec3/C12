package uniandes.edu.co.hotelAndes.modelo;


import jakarta.persistence.*;

@Entity
@Table(name="planes_consumo")
public class Plan_consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name="hotel_id", referencedColumnName = "id")
    private Hotel hotel_id;

    public Plan_consumo(){;}

    public Plan_consumo(String nombre, Hotel hotel_id) {
        this.nombre = nombre;
        this.hotel_id = hotel_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Hotel getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Hotel hotel_id) {
        this.hotel_id = hotel_id;
    }

    @Override
    public String toString() {
        return "Plan_consumo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", hotel_id=" + hotel_id +
                '}';
    }
}
