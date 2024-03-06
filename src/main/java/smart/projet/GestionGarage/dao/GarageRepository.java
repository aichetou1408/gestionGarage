package smart.projet.GestionGarage.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import smart.projet.GestionGarage.entity.GarageEntity;

@Repository
public interface GarageRepository extends JpaRepository<GarageEntity, Long>{

    
}