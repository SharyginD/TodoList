package my.project.security;

import my.project.domain.entity.UserEntity;
import my.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private UserRepository repository;

    @Autowired
    public UserPrincipalDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = repository.findByLogin(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User with login " + username + " not found");
        }

        UserPrincipal userPrincipal = new UserPrincipal(userEntity);

        return userPrincipal;
    }
}
