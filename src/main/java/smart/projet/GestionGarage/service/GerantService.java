package smart.projet.GestionTicket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import smart.projet.GestionTicket.dao.TicketRepository;
import smart.projet.GestionTicket.dao.ClientRepository;
import smart.projet.GestionTicket.dto.ClientTicket;
import smart.projet.GestionTicket.entity.ClientEntity;
import smart.projet.GestionTicket.entity.TicketEntity;

@Service
public class ClientService {
    @Autowired
    private ClientRepository ClientRepository;

    @Autowired
    private TicketRepository TicketRepository;

    public ResponseEntity<Object> createClientEntity(ClientEntity ClientEntity){
        try{
            ClientRepository.save(ClientEntity); 

            return ResponseEntity.ok().body("Client a ete cree");
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        
    }

    public ResponseEntity<Object> updateClientEntity(ClientEntity ClientEntity, Long id){
        Optional<ClientEntity> optionalClientEntity = ClientRepository.findById(id);
        if (optionalClientEntity.isPresent()) {
            var newClientEntity = optionalClientEntity.get();
            newClientEntity.setNom_Ger(ClientEntity.getNom_Ger());
            newClientEntity.setPrenom_Ger(ClientEntity.getPrenom_Ger());
            newClientEntity.setNumTel_Ger(ClientEntity.getNumTel_Ger());
            newClientEntity.setAdresse_Ger(ClientEntity.getAdresse_Ger());

            return ResponseEntity.ok().body(ClientRepository.save(newClientEntity)); 
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Object> getClientEntities(){
        var ClientEntities = ClientRepository.findAll();

        return ResponseEntity.ok().body(ClientEntities);
    }

    public ResponseEntity<Object> deleteClientEntity(Long id){
        Optional<ClientEntity> optionalClientEntity = ClientRepository.findById(id);
        if(optionalClientEntity.isPresent()){
            ClientRepository.delete(optionalClientEntity.get());

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
    public ResponseEntity<Object> findClientEntityByName(String nom_Ger){
        var ClientEntity = ClientRepository.findByName(nom_Ger);
        return ResponseEntity.ok().body(ClientEntity);
    }

    public ResponseEntity<Object> getTicketEntities(Long id){
        Optional<ClientEntity> optionalClientEntity = ClientRepository.findById(id);
        if(optionalClientEntity.isPresent()){
            var ClientEntity = optionalClientEntity.get();

            List<TicketEntity> TicketEntities = TicketRepository.findByClientEntity(ClientEntity);
            int totalTicketEntities = TicketEntities.size();

            var ClientTicket = new ClientTicket(TicketEntities, totalTicketEntities);

            return ResponseEntity.ok().body(ClientTicket);
        }

        return ResponseEntity.notFound().build();
    }
}


