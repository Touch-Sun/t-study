package io.github.touchsun.tstudy.modules.system.user.service;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.modules.system.user.model.User;
import io.github.touchsun.tstudy.modules.system.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* UserService Class
*
* @author touchsun
* @since 2024/7/25 22:25
*/
@Service
public class UserService extends AbstractBaseService<User, String> {

    @Autowired
    public UserService(UserRepository repository) {
        super(repository);
    }

}

