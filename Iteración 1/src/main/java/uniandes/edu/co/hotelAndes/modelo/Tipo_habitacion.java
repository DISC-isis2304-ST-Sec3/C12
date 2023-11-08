package uniandes.edu.co.hotelAndes.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="tipo_habitaciones")
public class Tipo_habitacion {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;

        private String tipo;

        private long capacidad;

        public Tipo_habitacion() {;}

        public Tipo_habitacion(String tipo, long capacidad) {
                this.tipo = tipo;
                this.capacidad = capacidad;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        public long getCapacidad() {
                return capacidad;
        }

        public void setCapacidad(long capacidad) {
                this.capacidad = capacidad;
        }

        @Override
        public String toString() {
                return "Tipo_habitacion{" +
                        "id=" + id +
                        ", tipo='" + tipo + '\'' +
                        ", capacidad=" + capacidad +
                        '}';
        }
}
