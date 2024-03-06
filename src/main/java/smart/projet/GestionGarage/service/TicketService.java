package smart.projet.GestionGarage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import smart.projet.GestionGarage.dao.TicketRepository;
import smart.projet.GestionGarage.entity.TicketEntity;

@Service

public class TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    public ResponseEntity<Object> createTicketEntity(TicketEntity ticketEntity){
        try{
            ticketRepository.save(ticketEntity); 

            return ResponseEntity.ok().body("Ticket a ete cree");
        }catch (Exception e){
            
            return ResponseEntity.internalServerError().build();
        }
    }
}
    