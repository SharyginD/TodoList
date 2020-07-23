package my.project.service.impl;

import my.project.domain.dto.Todo;
import my.project.domain.entity.TodoEntity;
import my.project.domain.entity.UserEntity;
import my.project.exception.customException.ResourceNotFoundException;
import my.project.repository.TodoRepository;
import my.project.repository.UserRepository;
import my.project.service.TodoService;
import my.project.utils.mapStruct.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private UserRepository userRepository;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;

    }

    @Override
    public Collection<Todo> getAll(int userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with id = " + userId + " not found"));
        return StreamSupport.stream(userEntity.getEntityList().spliterator(), false)
                .map(entity -> TodoMapper.INSTANCE.toDTO(entity))
                .collect(Collectors.toList());
    }

    @Override
    public Todo save(Todo todo, int userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with id = " + userId + " not found"));

        TodoEntity todoEntity = TodoMapper.INSTANCE.toEntity(todo);

        userEntity.getEntityList().add(todoEntity);
        todoEntity.setUser(userEntity);

        return TodoMapper.INSTANCE.toDTO(todoRepository.save(todoEntity));
    }

    @Override
    public Todo delete(int id) {

        TodoEntity todo = todoRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Note with id = " + id + " not found"));
        todoRepository.delete(todo);

        return TodoMapper.INSTANCE.toDTO(todo);
    }
}