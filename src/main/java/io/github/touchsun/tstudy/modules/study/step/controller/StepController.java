package io.github.touchsun.tstudy.modules.study.step.controller;

import io.github.touchsun.tstudy.common.controller.AbstractBaseController;
import io.github.touchsun.tstudy.modules.study.step.model.Step;
import io.github.touchsun.tstudy.modules.study.step.service.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
* StepController Class
* web controller for Step
*
* @author touchsun
* @since 2024/7/25 22:23
*/
@RestController
@RequestMapping("/v1/study/step")
public class StepController extends AbstractBaseController<Step, String> {

    @Autowired
    public StepController(StepService service) {
        super(service);
    }

}
