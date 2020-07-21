package my.project.utils.mapper;

import my.project.domain.dto.Todo;
import my.project.domain.dto.User;
import my.project.domain.entity.TodoEntity;
import my.project.domain.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    private TodoMapper todoMapper;

    @Autowired
    public UserMapper(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    public UserEntity toEntity(User user) {
        List<TodoEntity> todoList = new ArrayList<>();
        if (!user.getListTodo().isEmpty()) {
            for (Todo todo : user.getListTodo()) {
                TodoEntity todoEntity = todoMapper.toEntity(todo);
                todoList.add(todoEntity);
            }
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setLogin(user.getLogin());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userEntity.setTodoEntities(todoList);

        return userEntity;
    }

    public User toDTO(UserEntity userEntity) {
        List<Todo> todoList = new ArrayList<>();
        if (!userEntity.getTodoEntities().isEmpty()) {
            for (TodoEntity todo : userEntity.getTodoEntities()) {
                Todo todoDTO = todoMapper.toDTO(todo);
                todoList.add(todoDTO);
            }
        }
        User user = new User();
        user.setId(userEntity.getId());
        user.setLogin(userEntity.getLogin());
        user.setPassword(userEntity.getPassword());
        user.setRole(userEntity.getRole());
        user.setListTodo(todoList);

        return user;
    }

}
