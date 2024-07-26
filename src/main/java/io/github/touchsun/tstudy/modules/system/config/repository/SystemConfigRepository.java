package io.github.touchsun.tstudy.modules.system.config.repository;

import io.github.touchsun.tstudy.modules.system.config.model.SystemConfig;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * SystemConfigRepository Class
 * db operator, reactive repo fill mono or flux return type, and reactive db operator
 *
 * @author touchsun
 * @since 2024/7/25 22:23
 */
public interface SystemConfigRepository extends ReactiveMongoRepository<SystemConfig, String> {

}

