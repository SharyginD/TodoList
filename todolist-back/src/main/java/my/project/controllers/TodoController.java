package my.project.controllers;

import my.project.domain.dto.Todo;
import my.project.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class TodoController {

    private TodoService service;

    @Autowired
    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/{userId}/todo")
    public ResponseEntity<Collection<Todo>> getAll(@PathVariable("userId") int userId) {
        return new ResponseEntity<>(service.getAll(userId), HttpStatus.OK);
    }

    @PostMapping("/{userId}/todo")
    public ResponseEntity<Todo> save(@Valid @RequestBody Todo todo, @PathVariable("userId") int userId) {
        return new ResponseEntity<>(service.save(todo, userId), HttpStatus.OK);
    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity<Todo> delete(@PathVariable("todoId") int todoId) {
        return new ResponseEntity<>(service.delete(todoId), HttpStatus.OK);
    }
}
