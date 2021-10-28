package com.shardingjdbc.cn.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shardingjdbc.cn.entity.Bill;
import com.shardingjdbc.cn.service.BillService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Description: 测试Controller
 * @Author: lizhijun
 * @CreateTime: 2021/10/28
 * @Company: 宁波水表
 */
@RestController
@RequestMapping("/bill")
public class BillController {
    @Resource
    private BillService billService;

    //http://localhost:8080/bill/query?start=2021-02-07 00:00:00&end=2021-03-07 00:00:00
    @RequestMapping("/query")
    public List<Bill> queryList(@RequestParam("start") String start, @RequestParam("end") String end) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(start);
            Date date2 = sdf.parse(end);
            QueryWrapper<Bill> queryWrapper = new QueryWrapper<>();
            queryWrapper.ge("create_time", date)
                    .and(qw -> qw.le("create_time", date2)).last("limit 1,10");
            List<Bill> billPage = billService.list(queryWrapper);
            System.out.println(billPage.size());
            billPage.forEach(System.out::println);
            return billPage;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    //http://localhost:8080/bill/save?userid=999&addressId=999&status=M&date=2021-03-07%2000:00:00
    @RequestMapping("/save")
    public String save(@RequestParam("userid") int userId, @RequestParam("addressId") long addressId,
                       @RequestParam("status") String status
            , @RequestParam("date") String strDate) {
        String ret = "0";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(strDate);
            Bill bill = new Bill();
            bill.setUserId(userId);
            bill.setAddressId(addressId);
            bill.setStatus(status);
            bill.setCreateTime(date);
            boolean isOk = billService.save(bill);
            if (isOk) {
                ret = "1";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
