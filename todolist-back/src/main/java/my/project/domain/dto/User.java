package my.project.domain.dto;

import lombok.*;
import my.project.domain.Role;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private int id;

    @NotBlank(message = "Login can't be blank")
    @Size(max = 20, message = "Max login length = 20")
    private String login;

    @NotBlank(message = "Password can't be blank")
    @Size(max = 20, message = "Max password length = 20")
    private String password;

    private Role role = Role.ROLE_USER;

    private List<Todo> listTodo = new ArrayList<>();
}
