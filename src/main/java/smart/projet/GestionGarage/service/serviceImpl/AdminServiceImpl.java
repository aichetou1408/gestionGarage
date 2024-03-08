package smart.projet.GestionGarage.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import smart.projet.GestionGarage.dao.AdminRepository;
import smart.projet.GestionGarage.dao.TicketRepository;
import smart.projet.GestionGarage.dto.AdminTicket;
import smart.projet.GestionGarage.entity.Admin;
import smart.projet.GestionGarage.entity.Ticket;
import smart.projet.GestionGarage.service.AdminService;


@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepository repository;

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Admin> findAll() {
        return repository.findAll();
    }

    @Override
    public Admin create(Admin admin) {
        return repository.save(admin);

    }

    @Override
    public Boolean delete(Long id) {
        Optional<Admin> adminOptional = repository.findById(id);
        if (adminOptional.isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Admin findById(Long id) {
        Optional<Admin> adminOptional = repository.findById(id);
        if (adminOptional.isPresent()) 
            return adminOptional.get();
        return null;
    }

    @Override
    public String update(Admin admin, Long id) {
        Optional<Admin> adminOptional = repository.findById(id);
        if (adminOptional.isPresent()) {
            Admin updatedAdmin = adminOptional.get();
            updatedAdmin.setName(admin.getName());
            repository.save(updatedAdmin);
            return "Admin updated !";
        }
        return "Admin not found !";
    }
    @Override
    public List<Admin> findByName(String name){
        return repository.findByName(name);

    }

    @Override
    public ResponseEntity<Object> getAdminTickets(Long idAdmin){
        Optional<Admin> optionalAdmin = repository.findById(idAdmin);
        if(optionalAdmin.isPresent()){
            var admin = optionalAdmin.get();

            List<Ticket> adminTickets = ticketRepository.findByAdmin(admin);
            var adminTicket = new AdminTicket(adminTickets.size(), adminTickets);

            return ResponseEntity.ok().body(adminTicket);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Company not found");
    }
}


