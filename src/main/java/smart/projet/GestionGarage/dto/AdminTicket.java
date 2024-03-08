package smart.projet.GestionGarage.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import smart.projet.GestionGarage.entity.Ticket;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdminTicket {

    private List<Ticket> tickets;
    private int totalTickets;
    
}
