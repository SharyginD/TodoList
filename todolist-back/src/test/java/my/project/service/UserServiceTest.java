package my.project.service;

import my.project.domain.Role;
import my.project.domain.dto.Todo;
import my.project.domain.dto.User;
import my.project.domain.entity.TodoEntity;
import my.project.domain.entity.UserEntity;
import my.project.exception.customException.NonUniqueUserException;
import my.project.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

//    private List<User> listUserDTO = Arrays.asList(
//            new User(1, "Login 1", "Password 1", Role.ROLE_USER, new ArrayList<Todo>()),
//            new User(2, "Login 2", "Password 2", Role.ROLE_USER, new ArrayList<Todo>()));
//
//    private List<UserEntity> listUserEntity = Arrays.asList(
//            new UserEntity(1, "Login 1", "Password 1", Role.ROLE_USER, new ArrayList<TodoEntity>()),
//            new UserEntity(2, "Login 2", "Password 2", Role.ROLE_USER, new ArrayList<TodoEntity>()));
//
//    @Test
//    public void getAllTest() {
//        Mockito.when(repository.findAll()).thenReturn(listUserEntity);
//        Assert.assertEquals(service.getAll(), listUserDTO);
//    }
//
//    @Test
//    public void SuccessSaveTest() {
//        User user = new User(1, "Login 1", "Password 1", Role.ROLE_USER, new ArrayList<Todo>());
//        UserEntity entity = new UserEntity(1, "Login 1", "Password 1", Role.ROLE_USER, new ArrayList<TodoEntity>());
//        Mockito.when(repository.existsByLogin(user.getLogin())).thenReturn(false);
//        Mockito.when(repository.save(entity)).thenReturn(entity);
//        Assert.assertEquals(service.save(user), user);
//    }
//
//    @Test(expected = NonUniqueUserException.class)
//    public void failedSaveTest() {
//        User user = new User(1, "Login 1", "Password 1", Role.ROLE_USER, new ArrayList<Todo>());
//        UserEntity entity = new UserEntity(1, "Login 1", "Password 1", Role.ROLE_USER, new ArrayList<TodoEntity>());
//        Mockito.when(repository.existsByLogin(user.getLogin())).thenReturn(true);
//    }
}
