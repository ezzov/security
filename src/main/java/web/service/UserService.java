package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(long id);

    void save(User user);

    void update(User user);

    void delete(long id);
}
