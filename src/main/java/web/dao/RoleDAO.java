package web.dao;

import web.model.Role;

import java.util.List;

public interface RoleDAO {

    List<Role> getAllRoles();

    Role getRole(long id);

    void saveRole(Role role);

    void updateRole(Role role);

    void deleteRole(long id);

    Role loadRoleByName(String name);
}
