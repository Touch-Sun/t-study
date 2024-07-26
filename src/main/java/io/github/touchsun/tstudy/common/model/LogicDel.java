package io.github.touchsun.tstudy.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 * t-study
 * logic del annotation for default fill
 *
 * @author lee
 * @since 2024/7/26 11:25
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { FIELD })
public @interface LogicDel {

    /**
     * default value false
     */
    boolean value() default false;
}
