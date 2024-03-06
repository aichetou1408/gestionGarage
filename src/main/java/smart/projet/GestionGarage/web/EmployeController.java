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

import smart.projet.GestionGarage.entity.EmployeEntity;
import smart.projet.GestionGarage.service.EmployeService;

@RestController
@RequestMapping("/EmployeEntities")
public class EmployeController {

    @Autowired
    private EmployeService service;

    @PostMapping("/creer")
    public ResponseEntity<Object> createEmployeEntity(@RequestBody EmployeEntity employeEntity){
        return service.createEmployeEntity(employeEntity);
    }

     @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateEmployeEntity(@RequestBody EmployeEntity employeEntity, @PathVariable Long id){
            return service.updateEmployeEntity(employeEntity, id);
    }

    @GetMapping
    public ResponseEntity<Object> getEmployeEntities(){
        return service.getEmployeEntities();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteEmployeEntity(@PathVariable Long id){
            return service.deleteEmployeEntity(id);
    }

    @GetMapping("/nom_Emp")
    public ResponseEntity<Object> findEmployeEntityByName(@RequestParam String nom_Emp){
        return service.findEmployeEntityByName(nom_Emp);

    }

    @GetMapping("/{id}/ticketEntities")
    public ResponseEntity<Object> getTicketEntities(@PathVariable Long id) {
        return service.(id);
    }
    
}

