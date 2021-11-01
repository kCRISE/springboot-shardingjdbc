package com.shardingjdbc.cn.service;

import com.shardingjdbc.cn.entity.Bill;
import com.shardingjdbc.cn.mapper.BillMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: bill事务实现类
 * @Author: lizhijun
 * @CreateTime: 2021/11/1
 * @Company: 宁波水表
 */
@Service
public class TransActionBillServiceImpl implements TransActionBillService {
    @Resource
    BillMapper billMapper;

    @Override
    public void saveBill(List<Bill> billList) {
        for (Bill bill : billList) {
            billMapper.insert(bill);
        }
    }
}
