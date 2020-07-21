package my.project.utils;

import my.project.domain.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class Decoder {

    private PasswordEncoder encoder;

    @Autowired
    public Decoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    public User decode(User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        return user;
    }
}
