package smart.projet.GestionGarage.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import smart.projet.GestionGarage.entity.Admin;

@Service
public interface AdminService {


    public List<Admin> findAll();

    public Admin create(Admin admin);

    public Boolean delete(Long id);

    public Admin findById(Long id);

    public String update(Admin admin, Long id);

    public List<Admin> findByName(String name);

    public ResponseEntity<Object> getAdminTickets(Long idAdmin);






}