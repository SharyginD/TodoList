package my.project.domain.dto;

import lombok.*;
import my.project.domain.Role;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private int id;

    @NotBlank(message = "Login can't be blank")
    private String login;

    @NotBlank(message = "Password can't be blank")
    private String password;

    private Role role = Role.ROLE_USER;
}
