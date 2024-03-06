package smart.projet.GestionGarage.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import smart.projet.GestionGarage.entity.GarageEntity;
import smart.projet.GestionGarage.service.GarageService;


@RestController
@RequestMapping("/garages")
public class GarageController {
    @Autowired
    private GarageService service;
    
    @PostMapping("/creer")
    public ResponseEntity<Object> createGarageEntity(@RequestBody GarageEntity garageEntity){
            return service.createGarageEntity(garageEntity);
    }
    
}
