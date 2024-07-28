package io.github.touchsun.tstudy.common.security.filter.impl;

import io.github.touchsun.tstudy.common.security.ServerContext;
import io.github.touchsun.tstudy.common.security.filter.AbstractWebFilter;
import io.github.touchsun.tstudy.core.redis.RedisUtil;
import io.github.touchsun.tstudy.modules.system.user.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * t-study
 *
 * @author lee
 * @since 2024/7/28 11:03
 */
@Slf4j
public class RedisSessionFilter extends AbstractWebFilter implements WebFilter {
    
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        if (exclude(exchange.getRequest().getPath().value())) {
            return chain.filter(exchange);
        }
        // get current user
        String currentUser = ServerContext.getCurrentUser();
        if (StringUtils.isBlank(currentUser)) {
            log.error("redis session user not exist, it ie maybe logout.");
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }
        // select from redis have this user
        User sessionUser = RedisUtil.getValue(currentUser, User.class);
        if (sessionUser == null) {
            log.error("redis session user not exist, it ie maybe logout.");
            // user not exist, it ie maybe logout.
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        } else {
            // set user to local
            ServerContext.setCurrentUserInfo(sessionUser);
            return chain.filter(exchange);
        }
    }
}
