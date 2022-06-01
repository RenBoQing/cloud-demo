package cn.itcast.order;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//配置包扫描
@MapperScan("cn.itcast.order.mapper")
@SpringBootApplication
@EnableFeignClients
public class OrderApplication {
    /*
     *SpringBoot启动类
     * @author RenBoQing
     * @date 2022/5/6 0006 21:11
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /*
     *创建RestTemplate对象  注入Spring容器
     * @author RenBoQing
     * @date 2022/5/6 0006 21:13
     * @return org.springframework.web.client.RestTemplate
     */
    @Bean
    //实现负载均衡的注解
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*
     *重新定义负载均衡规则
     * @author RenBoQing
     * @date 2022/5/8 0008 10:47
     * @return com.netflix.loadbalancer.IRule
     */
    //@Bean
    //public IRule randomRule() {
    //    return new RandomRule();
    //}
}