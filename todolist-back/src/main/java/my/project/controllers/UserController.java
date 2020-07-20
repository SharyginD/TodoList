package my.project.controllers;

import my.project.domain.dto.User;
import my.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    public Collection<User> getAll() {
        return service.getAll();
    }

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        return service.save(user);
    }
}
