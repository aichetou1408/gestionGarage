package smart.projet.GestionGarage.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

public class Client {
     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    private String name;
    private String phone;
    private String mail;

    @OneToMany
    private List<User> servers;
}
