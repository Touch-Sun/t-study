package io.github.touchsun.tstudy.common.security.provider;

import io.github.touchsun.tstudy.common.security.filter.IFilterFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * t-study
 * security provider, system will use another provider impl, and use a filter adapter SpringSecurity
 *
 * @author lee
 * @since 2024/7/27 10:38
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface SecurityProvider {

    /**
     * create instance impl filter factory bean
     */
    Class<? extends IFilterFactory> filterFactory();
}
