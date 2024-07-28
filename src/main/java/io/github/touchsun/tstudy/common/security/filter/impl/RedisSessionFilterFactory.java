package io.github.touchsun.tstudy.common.security.filter.impl;

import io.github.touchsun.tstudy.common.security.filter.IFilterFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebFilter;

/**
 * t-study
 *
 * @author lee
 * @since 2024/7/28 10:51
 */
@Component
public class RedisSessionFilterFactory implements IFilterFactory {
    
    @Override
    public WebFilter getInstance() {
        return new RedisSessionFilter();
    }
    
}
