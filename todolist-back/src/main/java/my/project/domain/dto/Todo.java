package my.project.domain.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Todo {

    private int id;

    @NotBlank(message = "Can't be blank")
    @Size(max = 50, message = "Max length is 50 symbols")
    private String note;
}
