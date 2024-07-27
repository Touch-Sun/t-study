package io.github.touchsun.tstudy.modules.study.step.repository;

import io.github.touchsun.tstudy.modules.study.step.model.Step;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
* StepRepository Class
* db operator, reactive repo fill mono or flux return type, and reactive db operator
*
* @author touchsun
* @since 2024/7/25 22:23
*/
public interface StepRepository extends ReactiveMongoRepository<Step, String> {

}