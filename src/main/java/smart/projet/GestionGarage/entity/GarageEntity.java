package smart.projet.GestionTicket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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

    private int nbre_voiture;
    private String gerer_par;

    @ManyToOne
    private ClientEntity ClientEntity;

}
