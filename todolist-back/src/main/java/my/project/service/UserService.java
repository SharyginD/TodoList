package my.project.service;

import my.project.domain.dto.User;

import java.util.Collection;

public interface UserService {

    Collection<User> getAll();

    User save(User user);
}
