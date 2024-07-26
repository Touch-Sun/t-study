package io.github.touchsun.tstudy.modules.system.menu.repository;

import io.github.touchsun.tstudy.modules.system.menu.model.SystemMenu;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 *SystemMenuRepository Class
 * db operator, reactive repo fill mono or flux return type, and reactive db operator
 *
 * @author touchsun
 * @since 2024/7/25 22:23
 */
public interface SystemMenuRepository extends ReactiveMongoRepository<SystemMenu, String> {

}

