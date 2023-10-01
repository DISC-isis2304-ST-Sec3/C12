package uniandes.edu.co.hotelAndes.modelo;


import jakarta.persistence.*;

@Entity
@Table(name="planes_consumo")
public class PlanConsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String tipoplan;

    private Float descuento;

    @ManyToOne
    @JoinColumn(name="hoteles_id", referencedColumnName = "id")
    private Hotel hoteles_id;


    public PlanConsumo(){;}

    public PlanConsumo(long id, String tipoPlan, Float descuento, Hotel hotel_id) {
        this.id = id;
        this.tipoplan = tipoPlan;
        this.descuento = descuento;
        this.hoteles_id = hotel_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipoplan() {
        return tipoplan;
    }

    public void setTipoplan(String tipoPlan) {
        this.tipoplan = tipoPlan;
    }

    public Float getDescuento() {
        return descuento;
    }

    public void setDescuento(Float descuento) {
        this.descuento = descuento;
    }

    public Hotel getHotel_id() {
        return hoteles_id;
    }

    public void setHotel_id(Hotel hotel_id) {
        this.hoteles_id = hotel_id;
    }


    @Override
    public String toString() {
        return "Plan_consumo{" +
                "id=" + id +
                ", tipoPlan='" + tipoplan + '\'' +
                ", descuento=" + descuento +
                ", hotel_id=" + hoteles_id +
                '}';
    }
}
