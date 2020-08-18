package com.dev.gateway.filter;


import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
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
    private static final String URL  = "http://localhost:8063/core/testGet";
    private RestTemplate restTemplate = new RestTemplate();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(AUTHORIZE_TOKEN);
        String uid = headers.getFirst(AUTHORIZE_UID);
        //设置路径白名单   涉及到blog的url 放行
        String path = request.getURI().getPath();
        //静态资源访问,接口通过判断url中是否含有指定的字符来判断是否放行,在这里设置url的白名单
        if(path.indexOf("/blog/getAll")!= -1||path.indexOf("/cloud-user/user/signIn")!= -1){
            return chain.filter(exchange);
        }
        if (token == null) {
            token = request.getQueryParams().getFirst(AUTHORIZE_TOKEN);
        }
        if (uid == null) {
            uid = request.getQueryParams().getFirst(AUTHORIZE_UID);
        }
        ServerHttpResponse response = exchange.getResponse();
        if (StringUtils.isEmpty(token) || StringUtils.isEmpty(uid)) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return response.setComplete();
        }

        String authToken = restTemplate.getForObject(URL,String.class,uid);
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
