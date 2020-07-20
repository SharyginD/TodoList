package my.project.domain.dto;

import lombok.*;
import my.project.domain.Role;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User {

    private int id;

    private String login;

    private String password;

    private Role role = Role.ROLE_USER;
}
