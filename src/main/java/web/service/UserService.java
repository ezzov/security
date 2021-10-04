package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUser(long id);

    void save(User user, List<String> roles);

    void update(User user, List<String> roles);

    void delete(long id);
}
