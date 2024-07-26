package io.github.touchsun.tstudy.modules.system.service;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.modules.system.model.SystemConfig;
import io.github.touchsun.tstudy.modules.system.repository.SystemConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SystemConfigService Class
 *
 * @author touchsun
 * @since 2024/7/25 22:25
 */
@Service
public class SystemConfigService extends AbstractBaseService<SystemConfig, String> {

    @Autowired
    public SystemConfigService(SystemConfigRepository repository) {
        super(repository);
    }
    
}

