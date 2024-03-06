package smart.projet.GestionGarage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import smart.projet.GestionGarage.dao.GarageRepository;
import smart.projet.GestionGarage.entity.GarageEntity;

@Service

public class GarageService {

    @Autowired
    private GarageRepository garageRepository;

    public ResponseEntity<Object> createGarageEntity(GarageEntity garageEntity){
        try{
            garageRepository.save(garageEntity); 

            return ResponseEntity.ok().body("Garage a ete cree");
        }catch (Exception e){
            
            return ResponseEntity.internalServerError().build();
        }
    }
}
    