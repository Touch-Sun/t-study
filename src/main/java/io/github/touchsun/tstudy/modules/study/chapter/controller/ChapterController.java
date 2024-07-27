package io.github.touchsun.tstudy.modules.study.chapter.controller;

import io.github.touchsun.tstudy.common.controller.AbstractBaseController;
import io.github.touchsun.tstudy.modules.study.chapter.model.Chapter;
import io.github.touchsun.tstudy.modules.study.chapter.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* ChapterController Class
* web controller for Chapter
*
* @author touchsun
* @since 2024/7/25 22:23
*/
@RestController
@RequestMapping("/v1/study/chapter")
public class ChapterController extends AbstractBaseController<Chapter, String> {

    @Autowired
    public ChapterController(ChapterService service) {
        super(service);
    }

}
