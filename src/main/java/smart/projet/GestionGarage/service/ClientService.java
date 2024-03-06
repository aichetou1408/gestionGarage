package smart.projet.GestionGarage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import smart.projet.GestionGarage.dao.ClientRepository;
import smart.projet.GestionGarage.dao.TicketRepository;
import smart.projet.GestionGarage.dto.ClientTicket;
import smart.projet.GestionGarage.entity.ClientEntity;
import smart.projet.GestionGarage.entity.TicketEntity;


@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public ResponseEntity<Object> createClientEntity(ClientEntity clientEntity){
        try{
            clientRepository.save(clientEntity); 

            return ResponseEntity.ok().body("Client a ete cree");
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        
    }

    public ResponseEntity<Object> updateClientEntity(ClientEntity clientEntity, Long id){
        Optional<ClientEntity> optionalClientEntity = clientRepository.findById(id);
        if (optionalClientEntity.isPresent()) {
            var newClientEntity = optionalClientEntity.get();
            newClientEntity.setNom_Cli(clientEntity.getNom_Cli());
            newClientEntity.setPrenom_Cli(clientEntity.getPrenom_Cli());
            newClientEntity.setNumTel_Cli(clientEntity.getNumTel_Cli());
            newClientEntity.setAdresse_Cli(clientEntity.getAdresse_Cli());

            return ResponseEntity.ok().body(clientRepository.save(newClientEntity)); 
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Object> getClientEntities(){
        var clientEntities = clientRepository.findAll();

        return ResponseEntity.ok().body(clientEntities);
    }

    public ResponseEntity<Object> deleteClientEntity(Long id){
        Optional<ClientEntity> optionalClientEntity = clientRepository.findById(id);
        if(optionalClientEntity.isPresent()){
            clientRepository.delete(optionalClientEntity.get());

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
    public ResponseEntity<Object> findClientEntityBy(String nom_Cli){
        var clientEntity = clientRepository.findBy(nom_Cli);
        return ResponseEntity.ok().body(clientEntity);
    }

    public ResponseEntity<Object> getGarageEntities(Long id){
        Optional<ClientEntity> optionalClientEntity = clientRepository.findById(id);
        if(optionalClientEntity.isPresent()){
            var clientEntity = optionalClientEntity.get();

            List<TicketEntity> ticketEntities = ticketRepository.findByClientEntity(clientEntity);
            int totalGarageEntities = ticketEntities.size();

            var clientTicket = new ClientTicket(ticketEntities, totalTicketEntities);

            return ResponseEntity.ok().body(clientTicket);
        }

        return ResponseEntity.notFound().build();
    }
}


