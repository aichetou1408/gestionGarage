package smart.projet.GestionTicket.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private int num_Ticket;
    private String donner_par;
    private String gerer_par;

    @ManyToOne
    private ClientEntity client;

    @ManyToOne
    private EmployeEntity employe;
    
}
