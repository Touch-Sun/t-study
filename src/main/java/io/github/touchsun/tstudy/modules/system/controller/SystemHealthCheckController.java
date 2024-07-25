package io.github.touchsun.tstudy.modules.system.controller;

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
@RequestMapping("/v1/system/health")
public class SystemHealthCheckController {

    /**
     * Reactive health checkpoints
     */
    @GetMapping("/fluxCheck")
    public Flux<String> fluxCheck(@RequestParam(required = false) String uuid) {
        String result = uuid == null ? "OK" : "OK-" + uuid;
        return Flux.just(result);
    }
}
