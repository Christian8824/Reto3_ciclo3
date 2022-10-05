/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_ciclo3.demo.Servicio;

import Reto3_ciclo3.demo.Modelo.Room;
import Reto3_ciclo3.demo.Repositorio.RoomRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Christian
 */

@Service

public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    
    //Importar Métodos del Repositorio
    public List<Room> getAll(){
        return roomRepository.getAll();
    }
    
    public Optional<Room> getRoom(int id){
        return roomRepository.getRoom(id);
    }
    
    public Room save(Room room){
        if (room.getId() == null){
            return roomRepository.save(room);
        }else {
            Optional<Room> room1 = roomRepository.getRoom(room.getId());
            if(room1.isEmpty()){
                return roomRepository.save(room);
            }else {
                return room;
            }
        }
    }
}
