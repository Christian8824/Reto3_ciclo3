/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_ciclo3.demo.Repositorio;

import Reto3_ciclo3.demo.Interface.ReservationInterface;
import Reto3_ciclo3.demo.Modelo.Reservation;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Christian
 */

@Repository

public class ReservationRepository {
    @Autowired
    private ReservationInterface extensionesCrud;
    
    //Método para leer tabla category
    public List<Reservation> getAll(){
        return(List<Reservation>) extensionesCrud.findAll();
    }
    
    //Método 2
    public Optional<Reservation> getReservation (int id){
        return extensionesCrud.findById(id);
    }
    
    //Método Guardar
    public Reservation save (Reservation reservation){
        return extensionesCrud.save(reservation);
    }
}
