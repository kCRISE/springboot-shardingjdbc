package com.shardingjdbc.cn.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Description:
 * @Author: lizhijun
 * @CreateTime: 2021/10/28
 * @Company: 宁波水表
 */
@Data
@TableName(value = "t_bill")
public class Bill {
    private Long orderId;
    private Integer userId;
    private Long addressId;
    private String status;
    private Date createTime;
}
