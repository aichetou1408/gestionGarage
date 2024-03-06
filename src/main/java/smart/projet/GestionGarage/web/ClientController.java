package smart.projet.GestionGarage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import smart.projet.GestionGarage.entity.ClientEntity;
import smart.projet.GestionGarage.service.ClientService;

@RestController
@RequestMapping("/ClientEntities")
public class ClientController {

    @Autowired
    private ClientService service;

    @PostMapping("/creer")
    public ResponseEntity<Object> createClientEntity(@RequestBody ClientEntity clientEntity){
        return service.createClientEntity(clientEntity);
    }

     @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateClientEntity(@RequestBody ClientEntity clientEntity, @PathVariable Long id){
            return service.updateClientEntity(clientEntity, id);
    }

    @GetMapping
    public ResponseEntity<Object> getClientEntities(){
        return service.getClientEntities();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteClientEntity(@PathVariable Long id){
            return service.deleteClientEntity(id);
    }

    @GetMapping("/nom_Cli")
    public ResponseEntity<Object> findClientEntityByName(@RequestParam String nom_Cli){
        return service.findClientEntityByName(nom_Cli);

    }

    @GetMapping("/{id}/ticketEntities")
    public ResponseEntity<Object> getTicketEntities(@PathVariable Long id) {
        return service.getTicketEntities(id);
    }
    
}

