package my.project.service;

import my.project.domain.dto.User;

import java.util.Collection;

public interface UserService {

    public Collection<User> getAll();

    public User save(User user);
}
