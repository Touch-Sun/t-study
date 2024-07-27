package io.github.touchsun.tstudy.modules.system.roleuser.service;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.modules.system.roleuser.model.RoleUser;
import io.github.touchsun.tstudy.modules.system.roleuser.repository.RoleUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* RoleUserService Class
*
* @author touchsun
* @since 2024/7/25 22:25
*/
@Service
public class RoleUserService extends AbstractBaseService<RoleUser, String> {

    @Autowired
    public RoleUserService(RoleUserRepository repository) {
        super(repository);
    }

}

