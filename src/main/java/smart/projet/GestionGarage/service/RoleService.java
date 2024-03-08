package smart.projet.GestionGarage.service;

import java.util.List;
import smart.projet.GestionGarage.entity.Role;

public interface RoleService {

    public List<Role> getAllRoles();

    public Role getRoleById(long id);

    public Role createRole(Role role);

    public Role updateRole(Role updatedRole);
    
    public void deleteRole(long id);
}
