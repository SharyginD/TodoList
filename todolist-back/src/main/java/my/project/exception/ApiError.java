package my.project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {

    private HttpStatus status;

    private LocalDateTime timeStamp;

    private String message;

    private List<ApiSubErrors> subErrorsList = new ArrayList();

    public ApiError(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }
}