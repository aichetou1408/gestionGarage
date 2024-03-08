package smart.projet.GestionGarage.config;

import java.security.Permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import smart.projet.GestionGarage.dao.PermissionRepository;
import smart.projet.GestionGarage.dao.RoleRepository;
import smart.projet.GestionGarage.dao.ClientRepository;
import smart.projet.GestionGarage.entity.Client;
import smart.projet.GestionGarage.entity.Permission;
import smart.projet.GestionGarage.entity.Role;

import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.Optional;

@Component
public class PermissionInitializer implements ApplicationRunner{

    @Autowired
    private final PermissionRepository permissionRepository;

    @Autowired
    private final RoleRepository roleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public PermissionInitializer(PermissionRepository permissionRepository, RoleRepository roleRepository, ClientRepository ClientInfoRepository, PasswordEncoder passwordEncoder){
        this.permissionRepository = permissionRepository;
        this.roleRepository = roleRepository;
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public void run(ApplicationArguments args) {
        String[] perm_list = { "list_role", "view_role", "create_role", "update_role", "delete_role",
                "list_permission", "view_permission", "create_permission", "update_permission", "delete_permission",
                "list_client", "update_Client_password", "update_Client_role", "delete_Client", 
                "update_Client_password", "get_profile", "update_profile", "create_Admin", "view_Admin", 
        };
    
        for(String perm : perm_list){
            createPermissionIfNotFound(perm);
            
        }
    }
}
