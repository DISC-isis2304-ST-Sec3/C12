package uniandes.edu.co.hotelAndes.modelo;


import jakarta.persistence.*;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String horarioInicial;

    private String horarioFinal;

    @ManyToOne
    @JoinColumn(name = "reserva_id", referencedColumnName = "id")
    private Reserva reserva_id;

    public Servicio() {;}

    public Servicio(String horarioInicial, String horarioFinal, Reserva reserva_id) {
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.reserva_id = reserva_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getHorarioInicial() {
        return horarioInicial;
    }

    public void setHorarioInicial(String horarioInicial) {
        this.horarioInicial = horarioInicial;
    }

    public String getHorarioFinal() {
        return horarioFinal;
    }

    public void setHorarioFinal(String horarioFinal) {
        this.horarioFinal = horarioFinal;
    }

    public Reserva getReserva_id() {
        return reserva_id;
    }

    public void setReserva_id(Reserva reserva_id) {
        this.reserva_id = reserva_id;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", horarioInicial='" + horarioInicial + '\'' +
                ", horarioFinal='" + horarioFinal + '\'' +
                ", reserva_id=" + reserva_id +
                '}';
    }
}
