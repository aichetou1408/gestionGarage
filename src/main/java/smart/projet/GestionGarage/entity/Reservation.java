package smart.projet.GestionGarage.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Reservation {
    
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id_Reservation;

}
