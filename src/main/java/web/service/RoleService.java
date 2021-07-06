package web.service;

import web.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRole(long id);

    void saveRole(Role role);

    void updateRole(Role role);

    void deleteRole(long id);

    Role loadRoleByName(String name);
}
