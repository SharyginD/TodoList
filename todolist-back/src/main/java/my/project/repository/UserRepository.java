package my.project.repository;

import my.project.domain.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    boolean existsByLogin(String login);

    UserEntity findByLogin(String s);
}
