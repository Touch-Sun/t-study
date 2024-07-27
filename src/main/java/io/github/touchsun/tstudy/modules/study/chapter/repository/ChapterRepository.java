package io.github.touchsun.tstudy.modules.study.chapter.repository;

import io.github.touchsun.tstudy.modules.study.chapter.model.Chapter;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
* ChapterRepository Class
* db operator, reactive repo fill mono or flux return type, and reactive db operator
*
* @author touchsun
* @since 2024/7/25 22:23
*/
public interface ChapterRepository extends ReactiveMongoRepository<Chapter, String> {

}