package cn.itcast.order.service;


import cn.itcast.order.clients.UserClient;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.pojo.Order;
import cn.itcast.order.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserClient userClient;

    //    使用Feign进行远程的调用
    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.当订单查询完成以后 通过请求其他的接口来注入里面的用户的信息
        //使用feign进行请求的发送
        User user = userClient.findById(order.getUserId());
        log.info(userClient.toString());
        //将用户对象注入到订单对象中
        order.setUser(user);
        // 4.返回
        return order;
    }
}
