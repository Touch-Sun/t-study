package io.github.touchsun.tstudy.common.service;

import io.github.touchsun.tstudy.common.model.LogicDelInterface;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * AbstractBaseService Class
 * 
 * @param <T> type object
 * @param <ID> type id
 */
public abstract class AbstractBaseService<T, ID> {

    protected ReactiveMongoRepository<T, ID> repository;

    protected AbstractBaseService(ReactiveMongoRepository<T, ID> repository) {
        this.repository = repository;
    }

    /**
     * use mono return a one result
     *
     * @param entity params
     * @return mono result
     */
    public Mono<T> create(T entity) {
        return repository.save(entity);
    }

    public Mono<T> findById(ID id) {
        return repository.findById(id);
    }

    /**
     * use flux return a list result set
     * allow big data stream, and allow client set transfer speed.
     *
     * @return flux result
     */
    public Flux<T> findAll() {
        return repository.findAll();
    }

    public Mono<T> update(T entity) {
        return repository.save(entity);
    }

    /**
     * logic delete by id
     * 
     * @param id
     * @return
     */
    public Mono<Void> deleteById(ID id) {
        return repository.findById(id)
            .map(entity -> {
                if (entity instanceof LogicDelInterface) {
                    ((LogicDelInterface) entity).setDel(true);
                    return entity;
                }
                return entity;
            })
            .flatMap(repository::save)
            .then(repository.deleteById(id));
    }
}
