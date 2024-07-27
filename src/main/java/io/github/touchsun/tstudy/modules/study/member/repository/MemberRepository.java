package io.github.touchsun.tstudy.modules.study.member.repository;

import io.github.touchsun.tstudy.modules.study.member.model.Member;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
* MemberRepository Class
* db operator, reactive repo fill mono or flux return type, and reactive db operator
*
* @author touchsun
* @since 2024/7/25 22:23
*/
public interface MemberRepository extends ReactiveMongoRepository<Member, String> {

}