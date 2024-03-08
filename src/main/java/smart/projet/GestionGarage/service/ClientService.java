package smart.projet.GestionGarage.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import smart.projet.GestionGarage.entity.Client;


public interface ClientService {

    public ResponseEntity<?> addClient(Client client);

    public Client fidClientByClientname(String username);

    public void DeleteClient(Integer id);

    public boolean findClientById(Integer id);

    public List<Client> getClients();
}
