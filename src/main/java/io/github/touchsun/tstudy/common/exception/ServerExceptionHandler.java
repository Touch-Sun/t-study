package io.github.touchsun.tstudy.common.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.touchsun.tstudy.common.result.Result;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
@Order(-2) // Higher priority than default exception handler
public class ServerExceptionHandler implements WebExceptionHandler {

    private final ObjectMapper objectMapper;

    public ServerExceptionHandler(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Mono<Void> handle(ServerWebExchange exchange, Throwable ex) {
        if (ex instanceof TStudyException) {
            // Create a Result object with error information
            Result<String> result = Result.error(500, ex.getMessage());

            // Convert the Result object to JSON string using Jackson
            try {
                byte[] jsonBytes = objectMapper.writeValueAsBytes(result);
                return responseWithError(exchange.getResponse(), jsonBytes);
            } catch (JsonProcessingException e) {
                return Mono.error(e);
            }
        }
        // If the exception is not a TStudyException, let the default handler deal with it
        return Mono.error(ex);
    }

    private Mono<Void> responseWithError(ServerHttpResponse response, byte[] jsonBytes) {
        response.setStatusCode(HttpStatus.OK); // Set status code 200
        response.getHeaders().setContentType(MediaType.APPLICATION_JSON); // Set content type as JSON
        // Write the JSON bytes to the response body
        return response.writeWith(Mono.just(response.bufferFactory().wrap(jsonBytes)));
    }
}
