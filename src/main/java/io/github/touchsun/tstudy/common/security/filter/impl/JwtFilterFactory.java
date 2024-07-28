package io.github.touchsun.tstudy.common.security.filter.impl;

import io.github.touchsun.tstudy.common.security.filter.IFilterFactory;
import io.github.touchsun.tstudy.core.spring.SpringContextUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebFilter;


/**
 * t-study
 *
 * @author lee
 * @since 2024/7/27 11:59
 */
@Component
public class JwtFilterFactory implements IFilterFactory {
    
    @Override
    public WebFilter getInstance() {
        return new JwtTokenFilter();
    }
    
}
