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

   @Aggregation(pipeline = {
            "{ $addFields: { 'convertedStartDate': { $dateFromString: { dateString: '?0', format: '%Y/%m/%d' } }, 'convertedEndDate': { $dateFromString: { dateString: '?1', format: '%Y/%m/%d' } } } }",
            "{ $lookup: { from: 'RoomsReservations', localField: '_id', foreignField: 'user', as: 'reservations' } }",
            "{ $unwind: { path: '$reservations', preserveNullAndEmptyArrays: true } }",
            "{ $lookup: { from: 'Consumptions', localField: 'reservations.consumptions', foreignField: '_id', as: 'consumptions' } }",
            "{ $unwind: { path: '$consumptions', preserveNullAndEmptyArrays: true } }",
            "{ $addFields: { 'consumptionDateConverted': { $dateFromString: { dateString: '$consumptions.date', format: '%Y/%m/%d' } } } }",
            "{ $match: { $expr: { $and: [ { $gte: ['$consumptionDateConverted', '$convertedStartDate'] }, { $lte: ['$consumptionDateConverted', '$convertedEndDate'] } ] } } }",
            "{ $lookup: { from: 'Products', localField: 'consumptions.products', foreignField: '_id', as: 'productDetails' } }",
            "{ $unwind: '$productDetails' }",
            "{ $lookup: { from: 'Services', localField: 'productDetails._id', foreignField: 'products', as: 'serviceDetails' } }",
            "{ $unwind: '$serviceDetails' }",
            "{ $match: { 'serviceDetails.name': ?2 } }",
            "{ $group: { _id: '$name', primerareserva: { $min: '$consumptionDateConverted' }, ultimareserva: { $max: '$consumptionDateConverted' }, cantidad: { $sum: 1 } } }",
            "{$project:{_id:1, primerareserva: 1, ultimareserva:1, cantidad:1}}",
            "{ $sort: { primerareserva: 1 } }"
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioFechaAsc(String startDate, String endDate,
            String serviceName);

    @Aggregation(pipeline = {
            "{ $addFields: { 'convertedStartDate': { $dateFromString: { dateString: '?0', format: '%Y/%m/%d' } }, 'convertedEndDate': { $dateFromString: { dateString: '?1', format: '%Y/%m/%d' } } } }",
            "{ $lookup: { from: 'RoomsReservations', localField: '_id', foreignField: 'user', as: 'reservations' } }",
            "{ $unwind: { path: '$reservations', preserveNullAndEmptyArrays: true } }",
            "{ $lookup: { from: 'Consumptions', localField: 'reservations.consumptions', foreignField: '_id', as: 'consumptions' } }",
            "{ $unwind: { path: '$consumptions', preserveNullAndEmptyArrays: true } }",
            "{ $addFields: { 'consumptionDateConverted': { $dateFromString: { dateString: '$consumptions.date', format: '%Y/%m/%d' } } } }",
            "{ $match: { $expr: { $and: [ { $gte: ['$consumptionDateConverted', '$convertedStartDate'] }, { $lte: ['$consumptionDateConverted', '$convertedEndDate'] } ] } } }",
            "{ $lookup: { from: 'Products', localField: 'consumptions.products', foreignField: '_id', as: 'productDetails' } }",
            "{ $unwind: '$productDetails' }",
            "{ $lookup: { from: 'Services', localField: 'productDetails._id', foreignField: 'products', as: 'serviceDetails' } }",
            "{ $unwind: '$serviceDetails' }",
            "{ $match: { 'serviceDetails.name': ?2 } }",
            "{ $group: { _id: '$name', primerareserva: { $min: '$consumptionDateConverted' }, ultimareserva: { $max: '$consumptionDateConverted' }, cantidad: { $sum: 1 } } }",
            "{$project:{_id:1, primerareserva: 1, ultimareserva:1, cantidad:1}}",
            "{ $sort: { primerareserva: -1 } }"
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioFechaDesc(String startDate, String endDate,
            String serviceName);

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'RoomsReservations', localField: '_id', foreignField: 'user', as: 'reservations' } }",
            "{ $unwind: { path: '$reservations' } }",
            "{ $lookup: { from: 'Consumptions', localField: 'reservations.consumptions', foreignField: '_id', as: 'consumptions' } }",
            "{ $unwind: { path: '$consumptions' } }",
            "{ $match: { 'consumptions.date': { $gte:?0, $lte: ?1 } } }",
            "{ $lookup: { from: 'Products', localField: 'consumptions.products', foreignField: '_id', as: 'productDetails' } }",
            "{ $unwind: '$productDetails' }",
            "{ $lookup: { from: 'Services', localField: 'productDetails._id', foreignField: 'products', as: 'serviceDetails' } }",
            "{ $unwind: '$serviceDetails' }",
            "{ $match: { 'serviceDetails.name': ?2 } }",
            "{ $group: { _id: '$name', primerareserva: { $min: '$consumptions.date' }, ultimareserva: { $max: '$consumptions.date' }, cantidad: { $sum: 1 } } }",
            "{$project:{_id:1, primerareserva: 1, ultimareserva:1, cantidad:1}}",
            "{ $sort: { _id: 1 } }"
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioUsuarioAsc(String startDate, String endDate,
            String serviceName);

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'RoomsReservations', localField: '_id', foreignField: 'user', as: 'reservations' } }",
            "{ $unwind: { path: '$reservations' } }",
            "{ $lookup: { from: 'Consumptions', localField: 'reservations.consumptions', foreignField: '_id', as: 'consumptions' } }",
            "{ $unwind: { path: '$consumptions' } }",
            "{ $match: { 'consumptions.date': { $gte:?0, $lte: ?1 } } }",
            "{ $lookup: { from: 'Products', localField: 'consumptions.products', foreignField: '_id', as: 'productDetails' } }",
            "{ $unwind: '$productDetails' }",
            "{ $lookup: { from: 'Services', localField: 'productDetails._id', foreignField: 'products', as: 'serviceDetails' } }",
            "{ $unwind: '$serviceDetails' }",
            "{ $match: { 'serviceDetails.name': ?2 } }",
            "{ $group: { _id: '$name', primerareserva: { $min: '$consumptions.date' }, ultimareserva: { $max: '$consumptions.date' }, cantidad: { $sum: 1 } } }",
            "{$project:{_id:1, primerareserva: 1, ultimareserva:1, cantidad:1}}",
            "{ $sort: { _id: -1 } }"
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioUsuarioDesc(String startDate, String endDate,
            String serviceName);

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'RoomsReservations', localField: '_id', foreignField: 'user', as: 'reservations' } }",
            "{ $unwind: { path: '$reservations' } }",
            "{ $lookup: { from: 'Consumptions', localField: 'reservations.consumptions', foreignField: '_id', as: 'consumptions' } }",
            "{ $unwind: { path: '$consumptions' } }",
            "{ $match: { 'consumptions.date': { $gte:?0, $lte: ?1 } } }",
            "{ $lookup: { from: 'Products', localField: 'consumptions.products', foreignField: '_id', as: 'productDetails' } }",
            "{ $unwind: '$productDetails' }",
            "{ $lookup: { from: 'Services', localField: 'productDetails._id', foreignField: 'products', as: 'serviceDetails' } }",
            "{ $unwind: '$serviceDetails' }",
            "{ $match: { 'serviceDetails.name': ?2 } }",
            "{ $group: { _id: '$name', primerareserva: { $min: '$consumptions.date' }, ultimareserva: { $max: '$consumptions.date' }, cantidad: { $sum: 1 } } }",
            "{$project:{_id:1, primerareserva: 1, ultimareserva:1, cantidad:1}}",
            "{ $sort: { cantidad: 1 } }"
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioAsc(String startDate, String endDate,
            String serviceName);

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'RoomsReservations', localField: '_id', foreignField: 'user', as: 'reservations' } }",
            "{ $unwind: { path: '$reservations' } }",
            "{ $lookup: { from: 'Consumptions', localField: 'reservations.consumptions', foreignField: '_id', as: 'consumptions' } }",
            "{ $unwind: { path: '$consumptions' } }",
            "{ $match: { 'consumptions.date': { $gte:?0, $lte: ?1 } } }",
            "{ $lookup: { from: 'Products', localField: 'consumptions.products', foreignField: '_id', as: 'productDetails' } }",
            "{ $unwind: '$productDetails' }",
            "{ $lookup: { from: 'Services', localField: 'productDetails._id', foreignField: 'products', as: 'serviceDetails' } }",
            "{ $unwind: '$serviceDetails' }",
            "{ $match: { 'serviceDetails.name': ?2 } }",
            "{ $group: { _id: '$name', primerareserva: { $min: '$consumptions.date' }, ultimareserva: { $max: '$consumptions.date' }, cantidad: { $sum: 1 } } }",
            "{$project:{_id:1, primerareserva: 1, ultimareserva:1, cantidad:1}}",
            "{ $sort: { cantidad: -1 } }"
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicioDesc(String startDate, String endDate,
            String serviceName);

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'RoomsReservations', localField: '_id', foreignField: 'user', as: 'reservations' } }",
            "{ $unwind: { path: '$reservations' } }",
            "{ $lookup: { from: 'Consumptions', localField: 'reservations.consumptions', foreignField: '_id', as: 'consumptions' } }",
            "{ $unwind: { path: '$consumptions' } }",
            "{ $match: { 'consumptions.date': { $gte:?0, $lte: ?1 } } }",
            "{ $lookup: { from: 'Products', localField: 'consumptions.products', foreignField: '_id', as: 'productDetails' } }",
            "{ $unwind: '$productDetails' }",
            "{ $lookup: { from: 'Services', localField: 'productDetails._id', foreignField: 'products', as: 'serviceDetails' } }",
            "{ $unwind: '$serviceDetails' }",
            "{ $match: { 'serviceDetails.name': ?2 } }",
            "{ $group: { _id: '$name', primerareserva: { $min: '$consumptions.date' }, ultimareserva: { $max: '$consumptions.date' }, cantidad: { $sum: 1 } } }",
            "{$project:{_id:1, primerareserva: 1, ultimareserva:1, cantidad:1}}",
    })
    List<RespuestaServicioUsers> darInformacionUsersPorServicio(String startDate, String endDate, String serviceName);
}