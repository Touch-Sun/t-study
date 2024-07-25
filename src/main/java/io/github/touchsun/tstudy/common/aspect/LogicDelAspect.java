package io.github.touchsun.tstudy.common.aspect;

import io.github.touchsun.tstudy.common.model.LogicDelInterface;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Component;

/**
 * LogicDelAspect Class
 * process logic del
 *
 * @author touchsun
 * @since 2024/7/25 22:04
 */
@Aspect
@Component
public class LogicDelAspect {

    @Autowired
    private ReactiveMongoRepository repository;

    @Around("execution(* org.springframework.data.repository.Repository+.delete(..)) && args(entity)")
    public void aroundDeleteCall(ProceedingJoinPoint joinPoint, Object entity)
            throws Throwable {
        if (entity instanceof LogicDelInterface) {
            ((LogicDelInterface) entity).setDel(true);
            // save db complete logic del, but it is exec update val.
            // And don't proceed joinPoint, because exec joinPoint will really del val from disk.
            repository.save(entity);
        } else {
            // direct del val from disk.
            joinPoint.proceed();
        }
    }

}

