package io.github.touchsun.tstudy.common.security.filter.impl;

import io.github.touchsun.tstudy.common.security.provider.impl.JwtSecurityProvider;
import io.github.touchsun.tstudy.modules.system.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.Collections;

/**
 * base webflux web filter
 * 
 * @author lee 
 */
@Component
public class JwtTokenFilter implements WebFilter {

    @Autowired
    private JwtSecurityProvider jwtSecurityProvider;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String authToken = authHeader.substring(7);
            if (jwtSecurityProvider.checkToken(authToken)) {
                String userId = jwtSecurityProvider.getClaimsFromToken(authToken).getSubject();
                return userRepository.findById(userId)
                        .flatMap(user -> {
                            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                                    user.getUsername(), null, Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER")));
                            // reactive context
                            SecurityContext context = new SecurityContextImpl(authentication);
                            return chain.filter(exchange)
                                    .contextWrite(ReactiveSecurityContextHolder.withSecurityContext(Mono.just(context)));
                        });
            }
        }
        return chain.filter(exchange);
    }
}
