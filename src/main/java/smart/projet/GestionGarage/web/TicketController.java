package smart.projet.GestionGarage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smart.projet.GestionGarage.entity.Ticket;
import smart.projet.GestionGarage.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    @Autowired
    private TicketService service;
    
    @PostMapping("/create")
    public ResponseEntity<Object> createTicket(@RequestBody Ticket ticket){
            return service.createTicket(ticket);
    }
}
