package cn.itcast.user.web;

import cn.itcast.user.pojo.User;
import cn.itcast.user.service.UserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
//@RefreshScope
public class UserController {
    @Autowired
    private UserService userService;
    @Value("${pattern.dateformat}")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    ///返回时间类型@DateTimeFormat(pattern=“yyyy-MM-dd HH:mm:ss”)
    private String dateformat;


    /*
     *  根据id查询用户
     * @author RenBoQing
     * @date 2022/5/9 0009 16:32
     * @param id
     * @return cn.itcast.user.pojo.User
     */
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id, @RequestHeader(value = "Truth", required = false) String truth) {
        System.out.println(truth);
        return userService.queryById(id);
    }
}
