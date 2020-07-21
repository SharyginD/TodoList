package my.project.security;

public class SecurityConstraints {

    public static final String SECRET = "SecretKey";
    public static final int EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
}
