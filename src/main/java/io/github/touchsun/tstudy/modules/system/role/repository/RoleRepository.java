package io.github.touchsun.tstudy.modules.system.role.repository;

import io.github.touchsun.tstudy.modules.system.role.model.Role;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
* RoleRepository Class
* db operator, reactive repo fill mono or flux return type, and reactive db operator
*
* @author touchsun
* @since 2024/7/25 22:23
*/
public interface RoleRepository extends ReactiveMongoRepository<Role, String> {

}