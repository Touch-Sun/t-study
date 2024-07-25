package io.github.touchsun.tstudy.modules.system.service;

import io.github.touchsun.tstudy.modules.system.model.SystemConfig;
import io.github.touchsun.tstudy.modules.system.repository.SystemConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * SystemConfigService Class
 *
 * @author touchsun
 * @since 2024/7/25 22:25
 */
@Service
public class SystemConfigService {

    @Autowired
    private SystemConfigRepository repository;

    /**
     * use mono return a one result
     *
     * @param systemConfig params
     * @return mono result
     */
    public Mono<SystemConfig> createSystemConfig(SystemConfig systemConfig) {
        return repository.save(systemConfig);
    }

    public Mono<SystemConfig> getSystemConfig(String id) {
        return repository.findById(id);
    }

    /**
     * use flux return a list result set
     * allow big data stream, and allow client set transfer speed.
     *
     * @return flux result
     */
    public Flux<SystemConfig> getAllSystemConfigs() {
        return repository.findAll();
    }

    public Mono<SystemConfig> updateSystemConfig(SystemConfig systemConfig) {
        return repository.save(systemConfig);
    }

    public Mono<Void> deleteSystemConfig(String id) {
        return repository.deleteById(id);
    }
}

