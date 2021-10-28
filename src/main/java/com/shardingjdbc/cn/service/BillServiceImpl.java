package com.shardingjdbc.cn.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shardingjdbc.cn.entity.Bill;
import com.shardingjdbc.cn.mapper.BillMapper;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: lizhijun
 * @CreateTime: 2021/10/28
 * @Company: 宁波水表
 */
@Service
public class BillServiceImpl extends ServiceImpl<BillMapper, Bill> implements BillService {
}
