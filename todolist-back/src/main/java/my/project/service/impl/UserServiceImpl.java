package my.project.service.impl;

import my.project.domain.dto.User;
import my.project.domain.entity.UserEntity;
import my.project.exception.customException.NonUniqueUserException;
import my.project.repository.UserRepository;
import my.project.service.UserService;
import my.project.utils.Decoder;
import my.project.utils.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private UserMapper mapper;
    private Decoder decoder;

    @Autowired
    public UserServiceImpl(UserRepository repository, UserMapper mapper, Decoder decoder) {
        this.repository = repository;
        this.mapper = mapper;
        this.decoder = decoder;
    }

    @Override
    public Collection<User> getAll() {
        Iterable<UserEntity> list = repository.findAll();
        List<User> todoList = new ArrayList<>();
        for (UserEntity element : list) {
            todoList.add(mapper.toDTO(element));
        }
        return todoList;
    }

    @Override
    public User save(User user) {
        user = decoder.decode(user);
        UserEntity userEntity = mapper.toEntity(user);
        if (repository.existsByLogin(user.getLogin())) {
            throw new NonUniqueUserException("User with login = " + user.getLogin() + " already exists");
        }
        return mapper.toDTO(repository.save(userEntity));
    }
}
