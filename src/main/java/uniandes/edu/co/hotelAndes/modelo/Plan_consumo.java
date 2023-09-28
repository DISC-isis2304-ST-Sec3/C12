package uniandes.edu.co.hotelAndes.modelo;


import jakarta.persistence.*;

@Entity
@Table(name="planes_consumo")
public class Plan_consumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String tipoPlan;

    private Float descuento;

    @ManyToOne
    @JoinColumn(name="hotel_id", referencedColumnName = "id")
    private Hotel hotel_id;

    private float descuento1;

    public Plan_consumo(){;}

    public Plan_consumo(long id, String tipoPlan, Float descuento, Hotel hotel_id) {
        this.id = id;
        this.tipoPlan = tipoPlan;
        this.descuento = descuento;
        this.hotel_id = hotel_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Hotel getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Hotel hotel_id) {
        this.hotel_id = hotel_id;
    }

    public float getDescuento1() {
        return descuento1;
    }

    public void setDescuento1(float descuento1) {
        this.descuento1 = descuento1;
    }

    @Override
    public String toString() {
        return "Plan_consumo{" +
                "id=" + id +
                ", tipoPlan='" + tipoPlan + '\'' +
                ", descuento=" + descuento +
                ", hotel_id=" + hotel_id +
                ", descuento1=" + descuento1 +
                '}';
    }
}
