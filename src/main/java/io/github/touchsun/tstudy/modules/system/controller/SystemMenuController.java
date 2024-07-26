package io.github.touchsun.tstudy.modules.system.controller;

import io.github.touchsun.tstudy.common.controller.AbstractBaseController;
import io.github.touchsun.tstudy.modules.system.model.SystemMenu;
import io.github.touchsun.tstudy.modules.system.service.SystemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/system/menu")
public class SystemMenuController extends AbstractBaseController<SystemMenu, String> {

    @Autowired
    public SystemMenuController(SystemMenuService service) {
        super(service);
    }
    
}
