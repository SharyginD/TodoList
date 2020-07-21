package my.project.service;

import my.project.domain.dto.Todo;

import java.util.Collection;

public interface TodoService {

    Collection<Todo> getAll(int userId);

    Todo save(Todo todo, int userId);

    Todo delete(int id);
}
