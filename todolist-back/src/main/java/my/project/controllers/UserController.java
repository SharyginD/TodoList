package my.project.controllers;

import my.project.domain.dto.User;
import my.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class UserController {

    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    public ResponseEntity<Collection<User>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<User> save(@Valid @RequestBody User user) {
        return new ResponseEntity<>(service.save(user), HttpStatus.OK);
    }
}
