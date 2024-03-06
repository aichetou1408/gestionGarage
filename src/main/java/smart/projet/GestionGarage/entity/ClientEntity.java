package smart.projet.GestionGarage.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class ClientEntity extends UserEntity {
    
    private String nom_Cli;
    private String prenom_Cli;
    private int numTel_Cli;
    private String adresse_Cli;

    @OneToMany
    private List<TicketEntity> ticketEntities;
}
