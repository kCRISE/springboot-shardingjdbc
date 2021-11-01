package com.shardingjdbc.cn.controller;

import com.shardingjdbc.cn.entity.User;
import com.shardingjdbc.cn.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: 用户控制层
 * @Author: lizhijun
 * @CreateTime: 2021/11/1
 * @Company: 宁波水表
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/save")
    public void save(@RequestBody User user) {
        userService.saveUser(user);
    }

    @GetMapping("/listUser")
    public List<User> listUser() {
        return userService.getUser();
    }

}
