package smart.projet.GestionGarage.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import smart.projet.GestionGarage.entity.TicketEntity;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientTicket {

    private List<TicketEntity> ticketEntities;
    private int total;
    
}
