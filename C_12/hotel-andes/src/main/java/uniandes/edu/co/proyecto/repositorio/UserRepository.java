package uniandes.edu.co.proyecto.repositorio;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import uniandes.edu.co.proyecto.modelo.User; // Asumiendo que tienes una entidad llamada User
import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
   

    public class RespuestaServicioUsers{
        String nombre;
        String primera_reserva;
        String ultima_reserva;
        Integer cantidad;
        public RespuestaServicioUsers(String nombre, String primera_reserva, String ultima_reserva, Integer cantidad) {
            this.nombre = nombre;
            this.primera_reserva = primera_reserva;
            this.ultima_reserva = ultima_reserva;
            this.cantidad = cantidad;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getPrimera_reserva() {
            return primera_reserva;
        }
        public void setPrimera_reserva(String primera_reserva) {
            this.primera_reserva = primera_reserva;
        }
        public String getUltima_reserva() {
            return ultima_reserva;
        }
        public void setUltima_reserva(String ultima_reserva) {
            this.ultima_reserva = ultima_reserva;
        }
        public Integer getCantidad() {
            return cantidad;
        }
        public void setCantidad(Integer cantidad) {
            this.cantidad = cantidad;
        }
        
         
     }

    //RQF4
    @Aggregation(pipeline = {
        "{ $lookup: { from: 'RoomsReservations', localField: 'user_id', foreignField: 'user_id', as: 'reservations' } }",
        "{ $unwind: '$reservations' }",
        "{ $unwind: '$reservations.consumptions' }",
        "{ $match: { 'reservations.consumptions.date': { $gte: ?0, $lte: ?1 } } }",
        "{ $lookup: { from: 'Products', localField: 'reservations.consumptions.product', foreignField: '_id', as: 'productDetails' } }",
        "{ $unwind: '$productDetails' }",
        "{ $lookup: { from: 'Services', localField: 'productDetails.service', foreignField: '_id', as: 'serviceDetails' } }",
        "{ $unwind: '$serviceDetails' }",
        "{ $match: { 'serviceDetails.name': ?2 } }",
        "{ $group: { nombre: '$name', primera_reserva: { $min: '$reservations.consumptions.date' }, ultima_reserva: { $max: '$reservations.consumptions.date' }, cantidad: { $sum: 1 } } }",
        "{ $sort: { primera_reserva: 1 } }" 
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioFechaAsc(String startDate, String endDate, String serviceName);

    @Aggregation(pipeline = {
        "{ $lookup: { from: 'RoomsReservations', localField: 'user_id', foreignField: 'user_id', as: 'reservations' } }",
        "{ $unwind: '$reservations' }",
        "{ $unwind: '$reservations.consumptions' }",
        "{ $match: { 'reservations.consumptions.date': { $gte: ?0, $lte: ?1 } } }",
        "{ $lookup: { from: 'Products', localField: 'reservations.consumptions.product', foreignField: '_id', as: 'productDetails' } }",
        "{ $unwind: '$productDetails' }",
        "{ $lookup: { from: 'Services', localField: 'productDetails.service', foreignField: '_id', as: 'serviceDetails' } }",
        "{ $unwind: '$serviceDetails' }",
        "{ $match: { 'serviceDetails.name': ?2 } }",
        "{ $group: { _id: '$name', primera_reserva: { $min: '$reservations.consumptions.date' }, ultima_reserva: { $max: '$reservations.consumptions.date' }, cantidad: { $sum: 1 } } }",
        "{ $sort: { primera_reserva: -1 } }" 
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioFechaDesc(String startDate, String endDate, String serviceName);

    @Aggregation(pipeline = {
        "{ $lookup: { from: 'RoomsReservations', localField: 'user_id', foreignField: 'user_id', as: 'reservations' } }",
        "{ $unwind: '$reservations' }",
        "{ $unwind: '$reservations.consumptions' }",
        "{ $match: { 'reservations.consumptions.date': { $gte: ?0, $lte: ?1 } } }",
        "{ $lookup: { from: 'Products', localField: 'reservations.consumptions.product', foreignField: '_id', as: 'productDetails' } }",
        "{ $unwind: '$productDetails' }",
        "{ $lookup: { from: 'Services', localField: 'productDetails.service', foreignField: '_id', as: 'serviceDetails' } }",
        "{ $unwind: '$serviceDetails' }",
        "{ $match: { 'serviceDetails.name': ?2 } }",
        "{ $group: { _id: '$name', primera_reserva: { $min: '$reservations.consumptions.date' }, ultima_reserva: { $max: '$reservations.consumptions.date' }, cantidad: { $sum: 1 } } }",
        "{ $sort: { _id: 1 } }" 
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioUsuarioAsc(String startDate, String endDate, String serviceName);



    @Aggregation(pipeline = {
        "{ $lookup: { from: 'RoomsReservations', localField: 'user_id', foreignField: 'user_id', as: 'reservations' } }",
        "{ $unwind: '$reservations' }",
        "{ $unwind: '$reservations.consumptions' }",
        "{ $match: { 'reservations.consumptions.date': { $gte: ?0, $lte: ?1 } } }",
        "{ $lookup: { from: 'Products', localField: 'reservations.consumptions.product', foreignField: '_id', as: 'productDetails' } }",
        "{ $unwind: '$productDetails' }",
        "{ $lookup: { from: 'Services', localField: 'productDetails.service', foreignField: '_id', as: 'serviceDetails' } }",
        "{ $unwind: '$serviceDetails' }",
        "{ $match: { 'serviceDetails.name': ?2 } }",
        "{ $group: { _id: '$name', primera_reserva: { $min: '$reservations.consumptions.date' }, ultima_reserva: { $max: '$reservations.consumptions.date' }, cantidad: { $sum: 1 } } }",
        "{ $sort: { _id: -1 } }" 
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioUsuarioDesc(String startDate, String endDate, String serviceName);


    @Aggregation(pipeline = {
        "{ $lookup: { from: 'RoomsReservations', localField: 'user_id', foreignField: 'user_id', as: 'reservations' } }",
        "{ $unwind: '$reservations' }",
        "{ $unwind: '$reservations.consumptions' }",
        "{ $match: { 'reservations.consumptions.date': { $gte: ?0, $lte: ?1 } } }",
        "{ $lookup: { from: 'Products', localField: 'reservations.consumptions.product', foreignField: '_id', as: 'productDetails' } }",
        "{ $unwind: '$productDetails' }",
        "{ $lookup: { from: 'Services', localField: 'productDetails.service', foreignField: '_id', as: 'serviceDetails' } }",
        "{ $unwind: '$serviceDetails' }",
        "{ $match: { 'serviceDetails.name': ?2 } }",
        "{ $group: { _id: '$name', primera_reserva: { $min: '$reservations.consumptions.date' }, ultima_reserva: { $max: '$reservations.consumptions.date' }, cantidad: { $sum: 1 } } }",
        "{ $sort: { cantidad: 1 } }" 
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioAsc(String startDate, String endDate, String serviceName);

    @Aggregation(pipeline = {
        "{ $lookup: { from: 'RoomsReservations', localField: 'user_id', foreignField: 'user_id', as: 'reservations' } }",
        "{ $unwind: '$reservations' }",
        "{ $unwind: '$reservations.consumptions' }",
        "{ $match: { 'reservations.consumptions.date': { $gte: ?0, $lte: ?1 } } }",
        "{ $lookup: { from: 'Products', localField: 'reservations.consumptions.product', foreignField: '_id', as: 'productDetails' } }",
        "{ $unwind: '$productDetails' }",
        "{ $lookup: { from: 'Services', localField: 'productDetails.service', foreignField: '_id', as: 'serviceDetails' } }",
        "{ $unwind: '$serviceDetails' }",
        "{ $match: { 'serviceDetails.name': ?2 } }",
        "{ $group: { _id: '$name', primera_reserva: { $min: '$reservations.consumptions.date' }, ultima_reserva: { $max: '$reservations.consumptions.date' }, cantidad: { $sum: 1 } } }",
        "{ $sort: { cantidad: -1 } }" 
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioDesc(String startDate, String endDate, String serviceName);


    @Aggregation(pipeline = {
        "{ $lookup: { from: 'RoomsReservations', localField: 'user_id', foreignField: 'user_id', as: 'reservations' } }",
        "{ $unwind: '$reservations' }",
        "{ $unwind: '$reservations.consumptions' }",
        "{ $match: { 'reservations.consumptions.date': { $gte: ?0, $lte: ?1 } } }",
        "{ $lookup: { from: 'Products', localField: 'reservations.consumptions.product', foreignField: '_id', as: 'productDetails' } }",
        "{ $unwind: '$productDetails' }",
        "{ $lookup: { from: 'Services', localField: 'productDetails.service', foreignField: '_id', as: 'serviceDetails' } }",
        "{ $unwind: '$serviceDetails' }",
        "{ $match: { 'serviceDetails.name': ?2 } }",
        "{ $group: { _id: '$name', primera_reserva: { $min: '$reservations.consumptions.date' }, ultima_reserva: { $max: '$reservations.consumptions.date' }, cantidad: { $sum: 1 } } }"
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicio(String startDate, String endDate, String serviceName);
}

