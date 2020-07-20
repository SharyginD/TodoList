package my.project.service;

import my.project.domain.Role;
import my.project.domain.dto.User;
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

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    private List<User> listDTO = Arrays.asList(
            new User(1, "Login 1", "Password 1", Role.ROLE_USER),
            new User(2, "Login 2", "Password 2", Role.ROLE_USER));

    private List<UserEntity> listEntity = Arrays.asList(
            new UserEntity(1, "Login 1", "Password 1", Role.ROLE_USER),
            new UserEntity(2, "Login 2", "Password 2", Role.ROLE_USER));

    @Test
    public void getAllTest() {
        Mockito.when(repository.findAll()).thenReturn(listEntity);
        Assert.assertEquals(service.getAll(), listDTO);
    }

    @Test
    public void SuccessSaveTest() {
        User user = new User(1, "Login 1", "Password 1", Role.ROLE_USER);
        UserEntity entity = new UserEntity(1, "Login 1", "Password 1", Role.ROLE_USER);
        Mockito.when(repository.save(entity)).thenReturn(entity);
        Assert.assertEquals(service.save(user), user);
    }

    @Test(expected = NonUniqueUserException.class)
    public void failedSaveTest() {
        User user = new User(1, "Login 1", "Password 1", Role.ROLE_USER);
        UserEntity entity = new UserEntity(1, "Login 1", "Password 1", Role.ROLE_USER);
        Mockito.when(repository.save(entity)).thenThrow(NonUniqueUserException.class);
        Assert.assertEquals(service.save(user), user);
    }
}
