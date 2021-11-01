package com.shardingjdbc.cn.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shardingjdbc.cn.entity.User;
import com.shardingjdbc.cn.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Author: lizhijun
 * @CreateTime: 2021/11/1
 * @Company: 宁波水表
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    UserMapper userMapper;

    @Override
    public void saveUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> getUser() {
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        return userMapper.selectList(userWrapper);
    }
}
