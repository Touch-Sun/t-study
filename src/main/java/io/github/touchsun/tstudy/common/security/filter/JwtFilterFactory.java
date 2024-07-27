package io.github.touchsun.tstudy.common.security.filter;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.server.WebFilter;


/**
 * t-study
 *
 * @author lee
 * @since 2024/7/27 11:59
 */
@Component
public class JwtFilterFactory implements IFilterFactory, ApplicationContextAware {
    
    private ApplicationContext applicationContext;
    
    @Override
    public WebFilter getInstance() {
        return applicationContext.getBean(JwtTokenFilter.class);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // fill app context use get bean instance
        this.applicationContext = applicationContext;
    }
}
