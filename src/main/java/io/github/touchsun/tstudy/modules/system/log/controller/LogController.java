package io.github.touchsun.tstudy.modules.system.log.controller;

import io.github.touchsun.tstudy.common.controller.AbstractBaseController;
import io.github.touchsun.tstudy.modules.system.log.model.Log;
import io.github.touchsun.tstudy.modules.system.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* LogController Class
* web controller for Log
*
* @author touchsun
* @since 2024/7/25 22:23
*/
@RestController
@RequestMapping("/v1/system/log")
public class LogController extends AbstractBaseController<Log, String> {

    @Autowired
    public LogController(LogService service) {
        super(service);
    }

}
