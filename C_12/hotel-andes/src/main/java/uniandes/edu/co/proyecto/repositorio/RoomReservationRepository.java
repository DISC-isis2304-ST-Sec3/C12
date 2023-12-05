package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import uniandes.edu.co.proyecto.modelo.RoomReservation;
import org.bson.types.ObjectId;

import java.util.List;

public interface RoomReservationRepository extends MongoRepository<RoomReservation, String> {
    ;

    public class RespuestaGrupo2 {
        Integer _id;
        int totalCost;

        public RespuestaGrupo2(Integer _id, int totalCost) {
            this._id = _id;
            this.totalCost = totalCost;
        }

        public void setRoom(Integer _id) {
            this._id = _id;
        }

        public void setTotalCost(int totalCost) {
            this.totalCost = totalCost;
        }

        public Integer get_Id() {
            return _id;
        }

        public int getTotalCost() {
            return totalCost;
        }
    }

    public class RespuestaGrupo {
        Integer occupancyRate;
        String room;

        public RespuestaGrupo(String room, Integer occupancyRate) {
            this.room = room;

            if (occupancyRate == null) {
                this.occupancyRate = 0;
            } else {
                this.occupancyRate = occupancyRate;
            }

        }

        public void setRoom(String room) {
            this.room = room;
        }

        public void setOccupancyRate(Integer occupancyRate) {
            this.occupancyRate = occupancyRate;
        }

        public String getRoom() {
            return room;
        }

        public Integer getOccupancyRate() {
            // System.out.println(occupancyRate);
            return occupancyRate;
        }
    }

    public class RespuestaConsumoUsuario {
        String service_date;
        Integer room;
        Integer cost;
        String serviceName;

        public RespuestaConsumoUsuario(String service_date, Integer room, Integer cost, String serviceName) {
            this.service_date = service_date;
            this.room = room;
            this.cost = cost;
            this.serviceName = serviceName;
        }

        public String getService_date() {
            return service_date;
        }

        public void setService_date(String service_date) {
            this.service_date = service_date;
        }

        public Integer getRoom() {
            return room;
        }

        public void setRoom(Integer room) {
            this.room = room;
        }

        public Integer getCost() {
            return cost;
        }

        public void setCost(Integer cost) {
            this.cost = cost;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

    }

    public interface InformacionIndiceOcupacion {
        String getNum_Room();

        String getOcupacion();
    }

    public interface InformacionConsumoUsuario {
        String getService_date();

        String getRoom();

        String getCost();

        String getServiceName();
    }

    public interface datesDetail {
        String getEntryDate();

        String getDepartureDate();
    }

    // CREATE
    RoomReservation save(RoomReservation roomReservation);

    // READ
    @Query("{}")
    List<RoomReservation> findByRoomsReservations();

    // Buscar por fecha de salida
    @Query("{ 'departureDate' : ?0 }")
    List<RoomReservation> findByDepartureDate(String departureDate);

    // Buscar por fecha de entrada
    @Query("{ 'entryDate' : ?0 }")
    List<RoomReservation> findByEntryDate(String entryDate);

    // Buscar por fecha de entrada y salida
    @Query("{ 'entryDate' : { $gte: ?0 }, 'departureDate' : { $lte: ?1 }}")
    List<RoomReservation> findByDateRange(String startDate, String endDate);

    // Buscar reservaciones por n usuario
    @Query("{ '_id' : ?0 }")
    RoomReservation findByRoomReservation(String idReservation);

    // Buscar reservaciones por nombre de usuario
    @Query("{ 'user.name' : ?0 }")
    List<RoomReservation> findByNameUser(String user);

    // Buscar reservaciones por numero de habitación
    @Query("{ 'room.numRoom' : ?0 }")
    List<RoomReservation> findByNumRoom(Integer room);

    // Eliminar por ID de reservación
    @Query(value = "{ '_id' : ?0 }", delete = true)
    void deleteById(String idReservation);

    // // UPDATE
    // @Query(value = "{ '_id' : ?0 }")
    // RoomReservation updateRoomReservation(int idReservation, RoomReservation
    // roomReservation);

    // RQFC1
    @Aggregation(pipeline = {
            "{ $lookup: { from: 'Consumptions', localField: 'consumptions', foreignField: '_id', as: 'consumptions' } }",
            "{ $lookup: { from: 'Rooms', localField: 'room', foreignField: '_id', as: 'room1' } }",
            "{ $unwind: '$consumptions' }",
            "{ $unwind: '$room1' }",
            "{$project: {fechaConsumo: {$cond: {if: {$gt: ['$consumptions.date', { $dateToString: { format: '%Y-%m-%d', date: { $subtract: ['$now', { $multiply: [365, 24, 60, 60, 1000] }] } } }] }, then: {$toDate: '$consumptions.date'}, else: null}}, numRoom: '$room1.numRoom', costo: '$consumptions.cost'}}",
            "{$match: {fechaConsumo: {$ne: null}}}",
            "{$group: {_id: '$numRoom', totalCost: {$sum: '$costo'}}}"
    })
    List<RespuestaGrupo2> findRoomConsumptionCostInLastYear();

    // RQFC2
    @Aggregation({
            "{$project: {" +
                    "  entryDate: {" +
                    "    $cond: {" +
                    "      if: { $gte: ['$entryDate', { $dateToString: { format: '%Y-%m-%d', date: { $subtract: [new Date(), { $multiply: [365, 24, 60, 60, 1000] }] } } }] },"
                    +
                    "      then: { $toDate: '$entryDate' }," +
                    "      else: null" +
                    "    }" +
                    "  }," +
                    "  departureDate: { $toDate: '$departureDate' }," +
                    "  room: 1" +
                    "}}",
            "{$match: {" +
                    "  entryDate: { $ne: null }" +
                    "}}",
            "{$group: {" +
                    "  _id: '$room'," +
                    "  occupancyRate: { $sum: { $multiply: [{ $divide: [{ $subtract: ['$departureDate', '$entryDate'] }, { $multiply: [365, 24, 60, 60, 1000] }] }, 100] } }"
                    +
                    "}}",
            "{$set: {" +
                    "  occupancyRate: { $toInt: '$occupancyRate' }" +
                    "}}",
            "{$project: {" +
                    "  _id: 0," +
                    "  occupancyRate: 1," +
                    "  room: '$_id'" +
                    "}}"
    })
    List<RespuestaGrupo> calculateRoomOccupancyRates();

    @Aggregation(pipeline = {
            "{ $lookup: { from: 'Users', localField: 'user', foreignField: '_id', as: 'userInfo' } }",
            "{ $unwind: { path: '$userInfo' } }",
            "{ $match: { 'userInfo.user': ?0 } }",
            "{ $lookup: { from: 'Consumptions', localField: 'consumptions', foreignField: '_id', as: 'consumos' } }",
            "{ $unwind: { path: '$consumos' } }",
            "{ $match: { 'consumos.date': { $gte: ?1, $lte: ?2 } } }",
            "{ $lookup: { from: 'Products', localField: 'consumos.products', foreignField: '_id', as: 'productos' } }",
            "{ $unwind: { path: '$productos' } }",
            "{ $lookup: { from: 'Rooms', localField: 'room', foreignField: '_id', as: 'r' } }",
            "{ $unwind: { path: '$r' } }",
            "{ $project: { service_date: '$consumos.date', room: '$r.numRoom', cost: '$productos.cost', serviceName: '$productos.type' } }"
    })
    List<RespuestaConsumoUsuario> findCustomAggregation(String userName, String startDate, String endDate);

    // RQFC3
    @Aggregation(pipeline = {
            "{ $lookup: { from: 'Users', localField: 'user.id', foreignField: '_id', as: 'userInfo' } }",
            "{ $unwind: '$userInfo' }",
            "{ $match: { 'userInfo.user': ?0 } }",
            "{ $unwind: '$consumptions' }",
            "{ $match: { 'consumptions._id.date': { $gte: ?1, $lte: ?2 } } }",
            "{ $lookup: { from: 'products', localField: 'consumptions._id.product', foreignField: '_id', as: 'producto' } }",
            "{ $unwind: '$producto' }",
            "{ $lookup: { from: 'services', localField: 'producto.service', foreignField: '_id', as: 'servicio' } }",
            "{ $unwind: '$servicio' }",
            "{ $project: { service_date: '$consumptions._id.date', room: '$room.numRoom', cost: '$producto.cost', serviceName: '$servicio.name' } }"
    })
    List<RespuestaConsumoUsuario> darConsumosCliente(String username, String startDate,
            String endDate);

    @Query(value = "{ '_id' : ?0 }", fields = "{  'entryDate': 1, 'departureDate': 1, '_id' : 0}")
    datesDetail findDatesById(ObjectId idReservation);
}
