package io.github.touchsun.tstudy.common.controller;

import io.github.touchsun.tstudy.common.service.AbstractBaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * AbstractBaseController
 * 
 * @param <T> type object
 * @param <ID> type id
 */
public abstract class AbstractBaseController<T, ID> {

    protected final AbstractBaseService<T, ID> service;

    protected AbstractBaseController(AbstractBaseService<T, ID> service) {
        this.service = service;
    }

    @PostMapping
    public Mono<ResponseEntity<T>> create(@RequestBody T entity) {
        return service.create(entity)
            .map(ResponseEntity::ok);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<T>> findById(@PathVariable ID id) {
        return service.findById(id)
            .map(ResponseEntity::ok)
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    public Flux<T> findAll() {
        return service.findAll();
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<T>> update(@PathVariable ID id, @RequestBody T entity) {
        return service.update(entity)
            .map(ResponseEntity::ok);
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteById(@PathVariable ID id) {
        return service.deleteById(id)
            .then(Mono.just(ResponseEntity.ok().build()));
    }
}
