package smart.projet.GestionGarage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import smart.projet.GestionGarage.dao.EmployeRepository;
import smart.projet.GestionGarage.dao.TicketRepository;
import smart.projet.GestionGarage.dto.EmployeTicket;
import smart.projet.GestionGarage.entity.EmployeEntity;
import smart.projet.GestionGarage.entity.TicketEntity;


@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private TicketRepository ticketRepository;

    public ResponseEntity<Object> createEmployeEntity(EmployeEntity employeEntity){
        try{
            employeRepository.save(employeEntity); 

            return ResponseEntity.ok().body("Employe a ete cree");
        }catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        
    }

    public ResponseEntity<Object> updateEmployeEntity(EmployeEntity employeEntity, Long id){
        Optional<EmployeEntity> optionalEmployeEntity = employeRepository.findById(id);
        if (optionalEmployeEntity.isPresent()) {
            var newEmployeEntity = optionalEmployeEntity.get();
            newEmployeEntity.setNom_Emp(employeEntity.getNom_Emp());
            newEmployeEntity.setPrenom_Emp(employeEntity.getPrenom_Emp());
            newEmployeEntity.setNumTel_Emp(employeEntity.getNumTel_Emp());
            newEmployeEntity.setAdresse_Emp(employeEntity.getAdresse_Emp());

            return ResponseEntity.ok().body(employeRepository.save(newEmployeEntity)); 
        }

        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<Object> getEmployeEntities(){
        var employeEntities = employeRepository.findAll();

        return ResponseEntity.ok().body(employeEntities);
    }

    public ResponseEntity<Object> deleteEmployeEntity(Long id){
        Optional<EmployeEntity> optionalEmployeEntity = employeRepository.findById(id);
        if(optionalEmployeEntity.isPresent()){
            employeRepository.delete(optionalEmployeEntity.get());

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }
    public ResponseEntity<Object> findEmployeEntityByName(String nom_Emp){
        var employeEntity = employeRepository.findByName(nom_Emp);
        return ResponseEntity.ok().body(employeEntity);
    }

    public ResponseEntity<Object> getTicketEntities(Long id){
        Optional<EmployeEntity> optionalEmployeEntity = employeRepository.findById(id);
        if(optionalEmployeEntity.isPresent()){
            var employeEntity = optionalEmployeEntity.get();

            List<TicketEntity> ticketEntities = ticketRepository.findByEmployeEntity(employeEntity);
            int totalTicketEntities = ticketEntities.size();

            var employeTicket = new EmployeTicket(ticketEntities, totalTicketEntities);

            return ResponseEntity.ok().body(employeTicket);
        }

        return ResponseEntity.notFound().build();
    }
}


