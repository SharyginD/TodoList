package my.project.service.impl;

import my.project.domain.dto.User;
import my.project.domain.entity.UserEntity;
import my.project.exception.customException.NonUniqueUserException;
import my.project.repository.UserRepository;
import my.project.service.UserService;
import my.project.utils.Decoder;
import my.project.utils.mapStruct.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private Decoder decoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Decoder decoder) {
        this.userRepository = userRepository;
        this.decoder = decoder;
    }

    @Override
    public Collection<User> getAll() {
        Iterable<UserEntity> userEntities = userRepository.findAll();
        return StreamSupport.stream(userEntities.spliterator(), false)
                .map(entity -> UserMapper.INSTANCE.toDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public User save(User user) {
        user = decoder.decode(user);
        UserEntity userEntity = UserMapper.INSTANCE.toEntity(user);
        if (userRepository.existsByLogin(user.getLogin())) {
            throw new NonUniqueUserException("User with login = " + user.getLogin() + " already exists");
        }

        return UserMapper.INSTANCE.toDTO(userRepository.save(userEntity));
    }
}
