package io.github.touchsun.tstudy.common.security;

import io.github.touchsun.tstudy.common.security.provider.SecurityProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.server.WebFilter;

import java.util.Map;

/**
 * SpringSecurity Config of webflux
 *
 * @author lee
 */
@Configuration
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
                                "/v1/system/user/login", 
                                "/v1/system/user/register")
                        .permitAll()
                        .anyExchange().authenticated())
                .httpBasic().disable();  // 如果不使用 HTTP Basic 认证，禁用它

        // get all SecurityProvider tag class
        Map<String, Object> beansWithAnnotation = applicationContext.getBeansWithAnnotation(SecurityProvider.class);
        beansWithAnnotation.values().stream()
                .map(bean -> bean.getClass().getAnnotation(SecurityProvider.class))
                .map(SecurityProvider::filterFactory)
                .map(factoryClass -> applicationContext.getBean(factoryClass))
                .forEach(factory -> {
                    WebFilter webFilter = factory.getInstance();
                    http.addFilterAt(webFilter, SecurityWebFiltersOrder.AUTHENTICATION);
                });

        return http.build();
    }
}
