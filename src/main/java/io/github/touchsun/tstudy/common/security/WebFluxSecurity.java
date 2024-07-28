package io.github.touchsun.tstudy.common.security;

import io.github.touchsun.tstudy.common.security.filter.IFilterFactory;
import io.github.touchsun.tstudy.common.security.provider.SecurityProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.util.matcher.ServerWebExchangeMatchers;
import org.springframework.web.server.WebFilter;

import java.util.Map;

/**
 * SpringSecurity Config of webflux
 *
 * @author lee
 */
@Configuration
@DependsOn("staticConstantProcess")
@EnableWebFluxSecurity
public class WebFluxSecurity {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public SecurityWebFilterChain filterChain(ServerHttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(
                                SecurityConstant.EXCLUDE_PATHS)
                        .permitAll()
                        .anyExchange().authenticated())
                .httpBasic().disable();  // 如果不使用 HTTP Basic 认证，禁用它

        // get all SecurityProvider tag class
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(SecurityProvider.class);
        beansWithAnnotation.values().stream()
                .map(bean -> bean.getClass().getAnnotation(SecurityProvider.class))
                .map(SecurityProvider::filterFactory)
                .forEach(filterFactory -> {
                    for (Class<? extends IFilterFactory> factoryClass : filterFactory) {
                        WebFilter filter = applicationContext.getBean(factoryClass).getInstance();
                        http.addFilterAt(filter, SecurityWebFiltersOrder.AUTHENTICATION);
                    }
                });

        return http.build();
    }
}
