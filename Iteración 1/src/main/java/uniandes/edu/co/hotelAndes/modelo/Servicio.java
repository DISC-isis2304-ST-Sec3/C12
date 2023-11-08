package uniandes.edu.co.hotelAndes.modelo;


import jakarta.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
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

    private String nombre;

    private String costo;

    private String cargado;

    private String existe;

    public Servicio() {;}

    public Servicio(String horarioInicial, String horarioFinal, Reserva reserva_id, String nombre, String costo, String cargado, String existe) {
        this.horarioInicial = horarioInicial;
        this.horarioFinal = horarioFinal;
        this.reserva_id = reserva_id;
        this.nombre = nombre;
        this.costo = costo;
        this.cargado = cargado;
        this.existe = existe;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getCargado() {
        return cargado;
    }

    public void setCargado(String cargado) {
        this.cargado = cargado;
    }

    public String getExiste() {
        return existe;
    }

    public void setExiste(String existe) {
        this.existe = existe;
    }

    @Override
    public String toString() {
        return "Servicio{" +
                "id=" + id +
                ", horarioInicial='" + horarioInicial + '\'' +
                ", horarioFinal='" + horarioFinal + '\'' +
                ", reserva_id=" + reserva_id +
                ", nombre='" + nombre + '\'' +
                ", costo='" + costo + '\'' +
                ", cargado='" + cargado + '\'' +
                ", existe='" + existe + '\'' +
                '}';
    }
}
