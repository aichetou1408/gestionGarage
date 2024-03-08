package smart.projet.GestionGarage.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.projet.GestionGarage.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

    List<Admin> findByName(String name);
}