package io.github.touchsun.tstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * t-study
 *
 * @author lee
 * @since 2024/7/25 17:27
 */
@RestController
@RequestMapping("/v1/health")
public class HealthCheckController {

    /**
     * 反应式健康检查点
     */
    @GetMapping("/fluxCheck")
    public Flux<String> fluxCheck(@RequestParam(required = false) String uuid) {
        String result = uuid == null ? "OK" : "OK-" + uuid;
        return Flux.just(result);
    }
}
