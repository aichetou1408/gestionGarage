package smart.projet.GestionGarage.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import smart.projet.GestionGarage.entity.GarageEntity;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClientGarage {

    private List<GarageEntity> garageEntities;
    private int total;
    
}