package io.github.touchsun.tstudy.modules.system.log.service;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.modules.system.log.model.Log;
import io.github.touchsun.tstudy.modules.system.log.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* LogService Class
*
* @author touchsun
* @since 2024/7/25 22:25
*/
@Service
public class LogService extends AbstractBaseService<Log, String> {

    @Autowired
    public LogService(LogRepository repository) {
        super(repository);
    }

}

