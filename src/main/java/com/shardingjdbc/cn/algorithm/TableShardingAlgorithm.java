package com.shardingjdbc.cn.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;
import java.util.Date;

/**
 * @Description: 分表逻辑算法
 * @Author: lizhijun
 * @CreateTime: 2021/10/28
 * @Company: 宁波水表
 */
public class TableShardingAlgorithm implements PreciseShardingAlgorithm<Date> {
    /**
     * 数据的分表逻辑，这个定义稍显复杂一点，就是根据业务数据的日期字段值，根据月份落入对应的物理数据表中
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> shardingValue) {
        //真实数据库节点(表)
        availableTargetNames.forEach((item) -> {
            System.out.println("actual table:" + item);
        });
        //逻辑表以及分片的字段名
        System.out.println("logicTable:" + shardingValue.getLogicTableName() + ";shardingColumn:" + shardingValue.getColumnName());
        //分片数据字段值
        System.out.println("shardingColumn value:" + shardingValue.getValue().toString());
        //获取表名前缀
        String tbName = shardingValue.getLogicTableName() + "_";
        //根据日期进行分表
        Date date = shardingValue.getValue();
        String year = String.format("%tY", date);
        String mon = String.valueOf(Integer.parseInt(String.format("%tm", date)));
        //选择表
        tbName = tbName + year + "_" + mon;
        System.out.println("实际的表名：" + tbName);
        for (String tableName : availableTargetNames) {
            if (tableName.equals(tbName)) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }

}
