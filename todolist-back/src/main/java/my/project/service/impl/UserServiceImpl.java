package my.project.service.impl;

import my.project.domain.dto.User;
import my.project.domain.entity.UserEntity;
import my.project.exception.customException.NonUniqueUserException;
import my.project.repository.UserRepository;
import my.project.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<User> getAll() {
        Iterable<UserEntity> list = repository.findAll();
        List<User> todoList = new ArrayList();
        for (UserEntity element : list) {
            todoList.add(modelMapper.map(element, User.class));
        }
        return todoList;
    }

    @Override
    public User save(User user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
        if (repository.existsByLogin(user.getLogin())) {
            throw new NonUniqueUserException("User with login = " + user.getLogin() + " already exists");
        }
        return modelMapper.map(repository.save(userEntity), User.class);
    }
}
