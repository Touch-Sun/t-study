package io.github.touchsun.tstudy.common.exception;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebExceptionHandler;
import reactor.core.publisher.Mono;

/**
 * Server exception handler
 * 
 * @author lee 
 * @since 2024/7/25 17:27
 */
@Component
@Order(-2) // big to default exception handler
public class ServerExceptionHandler implements WebExceptionHandler {

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        if (ex instanceof TStudyException) {
            // user webflux exception response
            ServerHttpResponse response = exchange.getResponse();
            response.setStatusCode(HttpStatus.BAD_REQUEST);
            return response.writeWith(Mono.just(exchange.getResponse()
                    .bufferFactory()
                    .wrap(ex.getMessage().getBytes())));
        }
        return Mono.error(ex);
    }
}
