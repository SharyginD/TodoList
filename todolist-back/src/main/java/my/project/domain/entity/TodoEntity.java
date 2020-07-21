package my.project.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "todos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "note")
    private String note;

    @ManyToOne()
    private UserEntity user;
}
