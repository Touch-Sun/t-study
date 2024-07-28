package io.github.touchsun.tstudy.modules.system.user.service;

import io.github.touchsun.tstudy.common.exception.TStudyException;
import io.github.touchsun.tstudy.common.security.provider.ISecurityProvider;
import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.core.redis.RedisUtil;
import io.github.touchsun.tstudy.modules.system.user.enums.UserStatusEnum;
import io.github.touchsun.tstudy.modules.system.user.model.User;
import io.github.touchsun.tstudy.modules.system.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
* UserService Class
*
* @author touchsun
* @since 2024/7/25 22:25
*/
@Service
public class UserService extends AbstractBaseService<User, String> {
    
    private final UserRepository userRepository;
    
    @Autowired
    private ISecurityProvider securityProvider;

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
        this.userRepository = repository;
    }
    
    public Mono<String> login(User user) {
        // search user by username
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword())
                // not found username
                .switchIfEmpty(Mono.error(
                        new TStudyException("username: {} or password error", user.getUsername())))
                // login get username to create token
                .flatMap(dbUser -> {
                    String token = securityProvider.createToken(dbUser.getUsername());
                    // set redis session
                    RedisUtil.setValue(dbUser.getUsername(), dbUser);
                    // return token
                    return Mono.just(token);
                });
    }

    public Mono<User> register(User user) {
        return userRepository.findByUsername(user.getUsername())
                .flatMap(u -> Mono.error(
                        new TStudyException("username: {} already exists", user.getUsername())))
                .then(registerUser(user));
    }
    
    private Mono<User> registerUser(User user) {
        user.setStatus(UserStatusEnum.NORMAL.name());
        return userRepository.save(user);
    }
}

