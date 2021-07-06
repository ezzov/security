package web.dao;

import web.model.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    User getUser(long id);

    void save(User user);

    void update(User user);

    void delete(long id);

    User loadUserByUsername(String name);
}
