package smart.projet.GestionGarage.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Employe {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id_Emp;
    private String nom_Emp;
    private String prenom_Emp;
    private int numTel_Emp;
    private String adresse_Emp;
    private String role_Emp;
    
    
}
