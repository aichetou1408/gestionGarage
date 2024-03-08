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

import smart.projet.GestionGarage.entity.Admin;
import smart.projet.GestionGarage.service.AdminService;

@RestController
@RequestMapping("/Admins")
public class AdminController {

    @Autowired
    private AdminService service;

    @PostMapping("/create")
    public ResponseEntity<Object> createAdmin(@RequestBody Admin Admin){
        return service.createAdmin(Admin);
    }

     @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateAdmin(@RequestBody Admin Admin, @PathVariable Long id){
            return service.updateAdmin(Admin, id);
    }

    @GetMapping
    public ResponseEntity<Object> getAdmins(){
        return service.getAdmins();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Object> deleteAdmin(@PathVariable Long id){
            return service.deleteAdmin(id);
    }

    @GetMapping("/name")
    public ResponseEntity<Object> findAdminByName(@RequestParam String name){
        return service.findAdminByName(name);

    }

    @GetMapping("/{id}/tickets")
    public ResponseEntity<Object> getTickets(@PathVariable Long id) {
        return service.getTickets(id);
    }
    
}

