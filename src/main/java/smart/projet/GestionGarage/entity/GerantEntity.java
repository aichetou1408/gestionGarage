package smart.projet.GestionTicket.entity;

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
    private String nom_Ger;
    private String prenom_Ger;
    private int numTel_Ger;
    private String adresse_Ger;

    @OneToMany
    private List<TicketEntity> TicketEntities;
}
