package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.RoleDAO;
import web.model.Role;


import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    private RoleDAO roleDAO;

    @Autowired
    public void setRoleDAO(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    @Transactional(readOnly = true)
    public Role getRole(long id) {
        return roleDAO.getRole(id);
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleDAO.saveRole(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleDAO.updateRole(role);
    }

    @Override
    @Transactional
    public void deleteRole(long id) {
        roleDAO.deleteRole(id);
    }

    @Override
    @Transactional
    public Role loadRoleByName(String name) {
        return roleDAO.loadRoleByName(name);
    }
}
