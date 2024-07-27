package io.github.touchsun.tstudy.modules.study.task.service;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.modules.study.task.model.Task;
import io.github.touchsun.tstudy.modules.study.task.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* TaskService Class
*
* @author touchsun
* @since 2024/7/25 22:25
*/
@Service
public class TaskService extends AbstractBaseService<Task, String> {

    @Autowired
    public TaskService(TaskRepository repository) {
        super(repository);
    }

}

