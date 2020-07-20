package my.project.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Todo {

    private int id;

    @NotBlank(message = "Can't be blank")
    private String note;
}
