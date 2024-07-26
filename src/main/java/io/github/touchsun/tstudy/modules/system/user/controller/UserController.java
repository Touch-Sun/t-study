package io.github.touchsun.tstudy.modules.system.user.controller;

import io.github.touchsun.tstudy.common.controller.AbstractBaseController;
import io.github.touchsun.tstudy.modules.system.user.model.User;
import io.github.touchsun.tstudy.modules.system.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* UserController Class
* web controller for User
*
* @author touchsun
* @since 2024/7/25 22:23
*/
@RestController
@RequestMapping("/v1/system/user")
public class UserController extends AbstractBaseController<User, String> {

    @Autowired
    public UserController(UserService service) {
        super(service);
    }

}
