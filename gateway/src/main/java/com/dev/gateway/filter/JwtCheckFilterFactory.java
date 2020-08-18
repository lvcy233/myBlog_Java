package com.dev.gateway.filter;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;

import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * JWT验证的过滤器
 *
 * @author max
 * @create 2020/8/17
 **/
@Component
public class JwtCheckFilterFactory implements GlobalFilter, Ordered {
    private static final String AUTHORIZE_TOKEN = "token";
    private static final String AUTHORIZE_UID = "uid";
    private static final String URL = "http://localhost:8063/core/testGet";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath();
        //白名单  不用检索token
        if (path.indexOf("/blog") != -1 || path.indexOf("/user/signIn") != -1) {
            return chain.filter(exchange);
        }
        String token = request.getHeaders().getFirst(AUTHORIZE_TOKEN);
        String uid = request.getHeaders().getFirst(AUTHORIZE_UID);
        String authToken = restTemplate.getForObject(URL, String.class, uid);
        ServerHttpResponse response = exchange.getResponse();
        if (authToken == null || !authToken.equals(token)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }
        return chain.filter(exchange);
    }


    @Override
    public int getOrder() {
        return 0;
    }

}
