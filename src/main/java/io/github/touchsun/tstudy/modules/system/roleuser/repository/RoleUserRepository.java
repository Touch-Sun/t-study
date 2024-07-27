package io.github.touchsun.tstudy.modules.system.roleuser.repository;

import io.github.touchsun.tstudy.modules.system.roleuser.model.RoleUser;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
* RoleUserRepository Class
* db operator, reactive repo fill mono or flux return type, and reactive db operator
*
* @author touchsun
* @since 2024/7/25 22:23
*/
public interface RoleUserRepository extends ReactiveMongoRepository<RoleUser, String> {

}