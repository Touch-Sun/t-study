package io.github.touchsun.tstudy.modules.system.user.repository;

import io.github.touchsun.tstudy.modules.system.user.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

/**
* UserRepository Class
* db operator, reactive repo fill mono or flux return type, and reactive db operator
*
* @author touchsun
* @since 2024/7/25 22:23
*/
public interface UserRepository extends ReactiveMongoRepository<User, String> {

    /**
     * find user by username and password
     */
    Mono<User> findByUsernameAndPassword(String username, String password);
    
    /**
     * find user by username
     */
    Mono<User> findByUsername(String username);
}