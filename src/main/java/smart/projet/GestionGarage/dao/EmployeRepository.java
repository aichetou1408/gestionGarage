package smart.projet.GestionGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.projet.GestionGarage.entity.EmployeEntity;

@Repository
public interface EmployeRepository extends JpaRepository<EmployeEntity, Long>{

    
}