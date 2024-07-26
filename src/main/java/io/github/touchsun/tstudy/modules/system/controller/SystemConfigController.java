package io.github.touchsun.tstudy.modules.system.controller;

import io.github.touchsun.tstudy.common.controller.AbstractBaseController;
import io.github.touchsun.tstudy.modules.system.model.SystemConfig;
import io.github.touchsun.tstudy.modules.system.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/system/config")
public class SystemConfigController extends AbstractBaseController<SystemConfig, String> {

    @Autowired
    public SystemConfigController(SystemConfigService service) {
        super(service);
    }
    
}
