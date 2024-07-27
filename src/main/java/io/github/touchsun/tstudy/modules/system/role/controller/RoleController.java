package io.github.touchsun.tstudy.modules.system.role.controller;

import io.github.touchsun.tstudy.common.controller.AbstractBaseController;
import io.github.touchsun.tstudy.modules.system.role.model.Role;
import io.github.touchsun.tstudy.modules.system.role.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* RoleController Class
* web controller for Role
*
* @author touchsun
* @since 2024/7/25 22:23
*/
@RestController
@RequestMapping("/v1/system/role")
public class RoleController extends AbstractBaseController<Role, String> {

    @Autowired
    public RoleController(RoleService service) {
        super(service);
    }

}
