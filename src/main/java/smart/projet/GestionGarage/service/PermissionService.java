package smart.projet.GestionGarage.service;

import java.util.List;
import smart.projet.GestionGarage.entity.Permission;

public interface PermissionService {

    public List<Permission> getAllPermissions();

    public Permission createPermission(Permission permission);

    public Permission getPermissionById(long id);

    public Permission updatePermission(long id, Permission updatedPermission);

    public Boolean deletePermission(long id);
}
