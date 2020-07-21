package my.project.utils.mapper;

import my.project.domain.dto.Todo;
import my.project.domain.entity.TodoEntity;
import org.springframework.stereotype.Component;

@Component
public class TodoMapper {

    public TodoEntity toEntity(Todo todo) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setNote(todo.getNote());

        return todoEntity;
    }


    public Todo toDTO(TodoEntity todoEntity) {
        Todo todo = new Todo();
        todo.setId(todoEntity.getId());
        todo.setNote(todoEntity.getNote());

        return todo;
    }
}
