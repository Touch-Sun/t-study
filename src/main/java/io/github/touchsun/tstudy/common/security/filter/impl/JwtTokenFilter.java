package io.github.touchsun.tstudy.common.security.filter.impl;

import io.github.touchsun.tstudy.common.security.SecurityConstant;
import io.github.touchsun.tstudy.common.security.ServerContext;
import io.github.touchsun.tstudy.common.security.provider.impl.JwtSecurityProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * base webflux web filter
 * 
 * @author lee 
 */
@Component
public class JwtTokenFilter implements WebFilter {

    @Autowired
    private JwtSecurityProvider jwtSecurityProvider;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (authHeader != null && authHeader.startsWith(SecurityConstant.TOKEN_PREFIX.concat(" "))) {
            String authToken = authHeader.substring(7);
            if (jwtSecurityProvider.checkToken(authToken)) {
                String username = jwtSecurityProvider.getClaimsFromToken(authToken).getSubject();
                // set local user
                ServerContext.setCurrentUser(username);
                // reactive security context
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        username, null, null);
                SecurityContext context = new SecurityContextImpl(authentication);
                return chain.filter(exchange)
                        .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(
                                Mono.just(context)))
                        .doFinally(signalType -> {
                            // clear context with request end.
                            ReactiveSecurityContextHolder.clearContext();
                        });
            }
        }
        return chain.filter(exchange);
    }
}
