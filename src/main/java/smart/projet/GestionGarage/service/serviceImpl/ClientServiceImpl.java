package smart.projet.GestionGarage.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smart.projet.GestionGarage.dao.ClientRepository;
import smart.projet.GestionGarage.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEn
    
}
