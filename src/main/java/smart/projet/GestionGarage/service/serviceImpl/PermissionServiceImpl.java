package smart.projet.GestionGarage.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import smart.projet.GestionGarage.dao.PermissionRepository;
import smart.projet.GestionGarage.entity.Permission;
import smart.projet.GestionGarage.service.PermissionService;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission createPermission(Permission permission) {
        permissionRepository.save(permission);
    }
    
    @Override
    public Permission getPermissionById(long id) {
        return permissionRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Permission not found"));
    }
    @Override
    public Permission updatePermission(long id, Permission updatedPermission){
        Optional<Permission> optionalPermission = permissionRepository.findById(id);
        if (optionalPermission.isPresent()) {
            Permission permission = optionalPermission.get();
            permission.setName(updatedPermission.getName());
            return permissionRepository.save(permission);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Permission not found");
        }
    }
    @Override
    public Boolean deletePermission(long id){
        permissionRepository.deleteById(id);
        return true;
    }


}
