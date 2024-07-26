package io.github.touchsun.tstudy.modules.system.log.repository;

import io.github.touchsun.tstudy.modules.system.log.model.Log;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
* LogRepository Class
* db operator, reactive repo fill mono or flux return type, and reactive db operator
*
* @author touchsun
* @since 2024/7/25 22:23
*/
public interface LogRepository extends ReactiveMongoRepository<Log, String> {

}