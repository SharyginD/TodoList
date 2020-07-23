package my.project.service;

import my.project.domain.dto.Todo;
import my.project.domain.entity.TodoEntity;
import my.project.domain.entity.UserEntity;
import my.project.exception.customException.ResourceNotFoundException;
import my.project.repository.TodoRepository;
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
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoServiceTest {

    @Autowired
    private TodoService service;

    @MockBean
    private TodoRepository repository;

//    private List<Todo> listDTO = Arrays.asList(
//            new Todo(1, "Note 1"),
//            new Todo(2, "Note 2"),
//            new Todo(3, "Note 3"));
//
//    private List<TodoEntity> listEntity = Arrays.asList(
//            new TodoEntity(1, "Note 1", new UserEntity()),
//            new TodoEntity(2, "Note 2", new UserEntity()),
//            new TodoEntity(3, "Note 3", new UserEntity()));

//    @Test
//    public void getAllTest() {
//        Mockito.when(repository.findAll()).thenReturn(listEntity);
//        Assert.assertEquals(service.getAll(), listDTO);
//    }
//
//    @Test
//    public void saveTest() {
//        Todo todo = new Todo(1, "Hello");
//        TodoEntity entity = new TodoEntity(1, "Hello", new UserEntity());
//        Mockito.when(repository.save(entity)).thenReturn(entity);
//        Assert.assertEquals(service.save(todo), todo);
//    }
//
//    @Test
//    public void successDeleteTest() {
//        TodoEntity entity = new TodoEntity(1, "Hello", new UserEntity());
//        Todo todo = new Todo(1, "Hello");
//        Mockito.when(repository.findById(1)).thenReturn(Optional.of(entity));
//        Assert.assertEquals(service.delete(1), todo);
//    }
//
//    @Test(expected = ResourceNotFoundException.class)
//    public void failedDeleteTest() {
//        Mockito.when(repository.findById(1)).thenThrow(new ResourceNotFoundException("error"));
//        service.delete(1);
//    }
}
