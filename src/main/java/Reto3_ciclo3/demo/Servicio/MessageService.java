/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_ciclo3.demo.Servicio;

import Reto3_ciclo3.demo.Modelo.Message;
import Reto3_ciclo3.demo.Repositorio.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Christian
 */

@Service

public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    
    //Importar Métodos del Repositorio
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    
    public Message save(Message message){
        if (message.getIdMessage() == null){
            return messageRepository.save(message);
        }else {
            Optional<Message> message1 = messageRepository.getMessage(message.getIdMessage());
            if(message1.isEmpty()){
                return messageRepository.save(message);
            }else {
                return message;
            }
        }
    }
}
