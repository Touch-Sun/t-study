package io.github.touchsun.tstudy.modules.study.task.controller;

import io.github.touchsun.tstudy.common.controller.AbstractBaseController;
import io.github.touchsun.tstudy.modules.study.task.model.Task;
import io.github.touchsun.tstudy.modules.study.task.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* TaskController Class
* web controller for Task
*
* @author touchsun
* @since 2024/7/25 22:23
*/
@RestController
@RequestMapping("/v1/study/task")
public class TaskController extends AbstractBaseController<Task, String> {

    @Autowired
    public TaskController(TaskService service) {
        super(service);
    }

}
