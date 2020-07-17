package my.project.service;

import my.project.domain.dto.Todo;

import java.util.Collection;

public interface TodoService {

    Collection<Todo> getAll();

    Todo save(Todo todo);

    Todo delete(int id);
}
