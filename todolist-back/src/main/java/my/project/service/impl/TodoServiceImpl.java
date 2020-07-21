package my.project.service.impl;

import my.project.domain.dto.Todo;
import my.project.domain.entity.TodoEntity;
import my.project.domain.entity.UserEntity;
import my.project.exception.customException.ResourceNotFoundException;
import my.project.repository.TodoRepository;
import my.project.repository.UserRepository;
import my.project.service.TodoService;
import my.project.utils.mapper.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository repository;
    private UserRepository userRepository;
    private TodoMapper mapper;

    @Autowired
    public TodoServiceImpl(TodoRepository repository, UserRepository userRepository, TodoMapper mapper) {
        this.repository = repository;
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public Collection<Todo> getAll(int userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with id = " + userId + " not found"));

        List<Todo> todoList = new ArrayList<>();
        for (TodoEntity element : userEntity.getTodoEntities()) {
            todoList.add(mapper.toDTO(element));
        }
        return todoList;
    }

    @Override
    public Todo save(Todo todo, int userId) {
        UserEntity userEntity = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with id = " + userId + " not found"));

        TodoEntity entity = mapper.toEntity(todo);

        userEntity.getTodoEntities().add(entity);
        entity.setUser(userEntity);

        return mapper.toDTO(repository.save(entity));
    }

    @Override
    public Todo delete(int id) {

        TodoEntity todo = repository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Note with id = " + id + " not found"));
        repository.delete(todo);

        return mapper.toDTO(todo);
    }
}