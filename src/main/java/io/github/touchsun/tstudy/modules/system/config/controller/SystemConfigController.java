package io.github.touchsun.tstudy.modules.system.config.controller;

import io.github.touchsun.tstudy.common.controller.AbstractBaseController;
import io.github.touchsun.tstudy.modules.system.config.model.SystemConfig;
import io.github.touchsun.tstudy.modules.system.config.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SystemConfigController
 * 
 * @author lee 
 * @since 2024/7/25 22:23 
 */
@RestController
@RequestMapping("/v1/system/config")
public class SystemConfigController extends AbstractBaseController<SystemConfig, String> {

    @Autowired
    public SystemConfigController(SystemConfigService service) {
        super(service);
    }
    
}
