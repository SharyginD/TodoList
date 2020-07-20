package my.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiSubErrors {

    private String object;

    private String field;

    private String rejectedValue;

    private String message;
}
