package io.github.touchsun.tstudy.core.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * t-study
 * make static constant value read application.yml value
 *
 * @author lee
 * @since 2024/7/27 10:51
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface StaticConstant {

    /**
     * application.yml config name
     */
    String value();
    
}
