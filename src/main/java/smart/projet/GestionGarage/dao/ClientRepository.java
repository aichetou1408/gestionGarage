package smart.projet.GestionGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.projet.GestionGarage.entity.Client;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

    Optional<Client> findByUsername(String username);
    
    List<Client> findByUsernameContains(String username);
   
    Optional<Client> findByEmail(String email);
    
}