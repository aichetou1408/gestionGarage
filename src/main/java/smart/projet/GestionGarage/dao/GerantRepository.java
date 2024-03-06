package smart.projet.GestionGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.projet.GestionGarage.entity.GerantEntity;

@Repository
public interface GerantRepository extends JpaRepository<Gerant, Long>{

    
}
