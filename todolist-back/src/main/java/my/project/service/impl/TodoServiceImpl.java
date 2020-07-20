package my.project.service.impl;

import my.project.domain.dto.Todo;
import my.project.domain.entity.TodoEntity;
import my.project.exception.customException.ResourceNotFoundException;
import my.project.repository.TodoRepository;
import my.project.service.TodoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    private TodoRepository repository;
    private ModelMapper modelMapper;

    @Autowired
    public TodoServiceImpl(TodoRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Collection<Todo> getAll() {
        Iterable<TodoEntity> list = repository.findAll();
        List<Todo> todoList = new ArrayList();
        for (TodoEntity element : list) {
            todoList.add(modelMapper.map(element, Todo.class));
        }
        return todoList;
    }

    @Override
    public Todo save(Todo todo) {
        TodoEntity entity = modelMapper.map(todo, TodoEntity.class);
        return modelMapper.map(repository.save(entity), Todo.class);
    }

    @Override
    public Todo delete(int id) {
        Todo todo = modelMapper.map(repository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Note with id = " + id + " not found")),
                Todo.class);
        repository.deleteById(id);
        return todo;
    }
}