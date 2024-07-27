package io.github.touchsun.tstudy.modules.study.chapter.service;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.modules.study.chapter.model.Chapter;
import io.github.touchsun.tstudy.modules.study.chapter.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* ChapterService Class
*
* @author touchsun
* @since 2024/7/25 22:25
*/
@Service
public class ChapterService extends AbstractBaseService<Chapter, String> {

    @Autowired
    public ChapterService(ChapterRepository repository) {
        super(repository);
    }

}

