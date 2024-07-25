package io.github.touchsun.tstudy.modules.system.controller;

import io.github.touchsun.tstudy.modules.system.model.SystemConfig;
import io.github.touchsun.tstudy.modules.system.service.SystemConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/system/config")
public class SystemConfigController {

    @Autowired
    private SystemConfigService service;

    @PostMapping
    public Mono<ResponseEntity<SystemConfig>> createSystemConfig(@RequestBody SystemConfig systemConfig) {
        return service.createSystemConfig(systemConfig)
            .map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<SystemConfig>> getSystemConfig(@PathVariable String id) {
        return service.getSystemConfig(id)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Flux<SystemConfig> getAllSystemConfigs() {
        return service.getAllSystemConfigs();
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<SystemConfig>> updateSystemConfig(@PathVariable String id, @RequestBody SystemConfig systemConfig) {
        systemConfig.setId(id);
        return service.updateSystemConfig(systemConfig)
            .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteSystemConfig(@PathVariable String id) {
        return service.deleteSystemConfig(id)
            .then(Mono.just(ResponseEntity.ok().build()));
    }
}
