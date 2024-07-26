package io.github.touchsun.tstudy.modules.system.role.service;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.modules.system.role.model.Role;
import io.github.touchsun.tstudy.modules.system.role.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* RoleService Class
*
* @author touchsun
* @since 2024/7/25 22:25
*/
@Service
public class RoleService extends AbstractBaseService<Role, String> {

    @Autowired
    public RoleService(RoleRepository repository) {
        super(repository);
    }

}

