package com.shardingjdbc.cn.service;

import com.shardingjdbc.cn.entity.User;

import java.util.List;

/**
 * @Description:
 * @Author: lizhijun
 * @CreateTime: 2021/11/1
 * @Company: 宁波水表
 */
public interface UserService {
    /**
     * 保存用户
     *
     * @param user
     */
    void saveUser(User user);

    /**
     * 查询用户
     *
     * @return
     */
    List<User> getUser();
}
