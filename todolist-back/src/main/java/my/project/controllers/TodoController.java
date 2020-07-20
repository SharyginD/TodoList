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

    @GetMapping("/todo")
    public ResponseEntity<Collection<Todo>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/todo")
    public ResponseEntity<Todo> save(@Valid @RequestBody Todo todo) {
        return new ResponseEntity<>(service.save(todo), HttpStatus.OK);
    }

    @DeleteMapping("/todo/{todoId}")
    public ResponseEntity<Todo> delete(@PathVariable("todoId") int id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
