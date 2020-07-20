package my.project.exception.customException;

public class NonUniqueUserException extends RuntimeException {

    public NonUniqueUserException(String s) {
        super(s);
    }
}
