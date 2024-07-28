package io.github.touchsun.tstudy.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * CorsConfig Class
 */
@Configuration
public class CorsConfig {

    @Bean
    public CorsWebFilter corsWebFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOriginPattern("*"); // 允许所有域的模式
        corsConfiguration.addAllowedMethod("*"); // 允许所有方法（GET, POST, etc.）
        corsConfiguration.addAllowedHeader("*"); // 允许所有头
        corsConfiguration.setAllowCredentials(true); // 允许凭证

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration); // 应用于所有路径

        return new CorsWebFilter(source);
    }
}
