package com.shardingjdbc.cn.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Description: 数据库对应实体类
 * @Author: lizhijun
 * @CreateTime: 2021/11/1
 * @Company: 宁波水表
 */
@Data
@TableName(value = "user")
public class User {
    @TableId(value = "id", type = IdType.NONE)
    private Long id;
    private String city;
    private String name;
}
