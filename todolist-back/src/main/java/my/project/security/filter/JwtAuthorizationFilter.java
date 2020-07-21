package my.project.security.filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import my.project.domain.entity.UserEntity;
import my.project.repository.UserRepository;
import my.project.security.SecurityConstraints;
import my.project.security.UserPrincipal;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private UserRepository userRepository;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, UserRepository userRepository) {
        super(authenticationManager);
        this.userRepository = userRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(SecurityConstraints.HEADER_STRING);

        if (header == null || !header.startsWith(SecurityConstraints.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        Authentication authentication = getUserNamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        chain.doFilter(request, response);
    }

    private Authentication getUserNamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstraints.HEADER_STRING);

        if (token != null) {
            String userName = JWT.require(Algorithm.HMAC512(SecurityConstraints.SECRET.getBytes()))
                    .build()
                    .verify(token.replace(SecurityConstraints.TOKEN_PREFIX, ""))
                    .getSubject();

            if (userName != null) {
                UserEntity userEntity = userRepository.findByLogin(userName);
                UserPrincipal userPrincipal = new UserPrincipal(userEntity);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userPrincipal, null, userPrincipal.getAuthorities());
                return auth;
            }
            return null;
        }
        return null;
    }
}
