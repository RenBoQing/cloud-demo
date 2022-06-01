package cn.itcast.gateaway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author RenBoQing
 * @date 2022年05月16日 11:31
 * @Description 全局配置请求
 */
@Component
@Order(-1)
public class AuthorizeFilter implements GlobalFilter {
    /*
     *重写方法
     * @author RenBoQing
     * @date 2022/5/17 0017 15:57
     * @param exchange
     * @param chain
     * @return reactor.core.publisher.Mono<java.lang.Void>
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        //获取请求参数
        ServerHttpRequest request = exchange.getRequest();
        MultiValueMap<String, String> queryParams = request.getQueryParams();
        //获取参数Authorization
        String authorization = queryParams.getFirst("authorization");
        //判断参数值是否等于admin
        if ("admin".equals(authorization)) {
            //是 放行
            return chain.filter(exchange);
        }
        //否 拦截
        //设置状态码 未登录的状态码
        exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }
}
