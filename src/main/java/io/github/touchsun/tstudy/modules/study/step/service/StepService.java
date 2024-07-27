package io.github.touchsun.tstudy.modules.study.step.service;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import io.github.touchsun.tstudy.modules.study.step.model.Step;
import io.github.touchsun.tstudy.modules.study.step.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* StepService Class
*
* @author touchsun
* @since 2024/7/25 22:25
*/
@Service
public class StepService extends AbstractBaseService<Step, String> {

    @Autowired
    public StepService(StepRepository repository) {
        super(repository);
    }

}

