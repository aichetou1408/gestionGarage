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

public class EmployeEntity extends UserEntity {

    private String nom_Emp;
    private String prenom_Emp;
    private int numTel_Emp;
    private String adresse_Emp;
    private String role_Emp;

    @OneToMany
    private List<TicketEntity> ticketEntities; 
    
}
