package smart.projet.GestionGarage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientProfile {

    private String Clientname;
    private String email;
    private String nni;
    private String phoneNumber;
    private String address;
    
}
