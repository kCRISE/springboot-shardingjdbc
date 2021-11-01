package com.shardingjdbc.cn.service;

import com.shardingjdbc.cn.entity.Bill;
import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description: 分布式事务测试类
 * @Author: lizhijun
 * @CreateTime: 2021/11/1
 * @Company: 宁波水表
 */
public interface TransActionBillService {

    /**
     * 添加bill
     *
     * @param billList bill集合
     */
    @Transactional(rollbackFor = Exception.class)
    @ShardingTransactionType(TransactionType.XA)
    void saveBill(List<Bill> billList);
}
