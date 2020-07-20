package my.project.domain.entity;

import lombok.*;
import my.project.domain.Role;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public UserEntity(String login, String password) {
        this.login = login;
        this.password = password;
        this.role = Role.ROLE_USER;
    }
}
