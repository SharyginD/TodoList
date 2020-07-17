package my.project.controllers;

import my.project.domain.dto.Todo;
import my.project.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class TodoController {

    private TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/todo")
    public Collection<Todo> getAll() {
        return service.getAll();
    }

    @PostMapping("/todo")
    public Todo save(@RequestBody Todo todo) {
        return service.save(todo);
    }

    @DeleteMapping("/todo/{todoId}")
    public Todo delete(@PathVariable("todoId") int id) {
        return service.delete(id);
    }
}
