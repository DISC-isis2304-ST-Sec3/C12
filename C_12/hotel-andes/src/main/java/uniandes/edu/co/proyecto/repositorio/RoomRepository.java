package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Aggregation;

import uniandes.edu.co.proyecto.modelo.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository extends MongoRepository<Room, String> {

    public class RespuestaGrupo{
        Integer room;
        int totalCost;
        public RespuestaGrupo(Integer room, int totalCost) {
            this.room = room;
            this.totalCost = totalCost;
        }
        public void setRoom(Integer room) {
            this.room = room;
        }
        public void setTotalCost(int totalCost) {
            this.totalCost= totalCost;
        }
        public Integer getRoom() {
            return room;
        }
        public int getTotalCost() {
            return totalCost;
        }
    }
    public interface InformacionTotalConsumoPorHabitacion {
        String getNum_Room();
        Long getTotalCost();
    }

       // CREATE
       Room save(Room room);

       // READ
       @Query("{ 'numRoom' : ?0 }")
       Room findByNumero(Integer numRoom);

       @Query("{ '_id' : ?0 }")
        Optional<Room> findById(String id);
   
       @Query("{}")
       List<Room> findAllRooms();
   
       // DELETE
       @Query(value = "{ '_id' : ?0 }", delete = true)
       void deleteByNumero(String id);
   
       // UPDATE
    //    @Query("{ 'numRoom' : ?0 }")
    //    Room updateRoom(int numRoom, Room room);


        ////RQFC1
        // @Aggregation(pipeline = {
        //     "{ $lookup: { from: 'RoomReservations', localField: '_id', foreignField: 'room', as: 'reservations' } }",
        //     "{ $unwind: '$reservations' }",
        //     "{ $unwind: '$reservations.consumptions' }",
        //     "{ $lookup: { from: 'consumptions', localField: 'reservations.consumptions', foreignField: '_id', as: 'consumptionDetails' } }",
        //     "{ $unwind: '$consumptionDetails' }",
        //     "{ $match: { 'consumptionDetails.date': { $gt: { $subtract: [ ISODate('$now'), { $multiply: [365, 24, 60, 60, 1000] } ] } } } }",
        //     "{ $group: { _id: '$numRoom', totalCost: { $sum: '$consumptionDetails.cost' } } }",
        //     "{$project: {'room':'$numRoom', totalCost:1}}"
        // })
        // List<RespuestaGrupo> findRoomConsumptionCostInLastYear();
        
       

    
    
    
    
}
