package io.github.touchsun.tstudy.modules.system.menu.service;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.modules.system.menu.model.SystemMenu;
import io.github.touchsun.tstudy.modules.system.menu.repository.SystemMenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *SystemMenuService Class
 *
 * @author touchsun
 * @since 2024/7/25 22:25
 */
@Service
public class SystemMenuService extends AbstractBaseService<SystemMenu, String> {

    @Autowired
    public SystemMenuService(SystemMenuRepository repository) {
        super(repository);
    }
    
}

