package com.shardingjdbc.cn.algorithm;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @Description: 自定义数据库分片算法
 * @Author: lizhijun
 * @CreateTime: 2021/10/28
 * @Company: 宁波水表
 */
public class DbShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    /**
     * Long：用于分片值的类型
     *
     * @param availableTargetNames
     * @param preciseShardingValue
     * @return
     */
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> preciseShardingValue) {
        /**
         * 标准分片策略
         * 对应 StandardShardingStrategy。提供对 SQL 语句中的 =, >, <, >=, <=, IN 和 BETWEEN AND 的分片操作支持。
         * StandardShardingStrategy 只支持单分片键，提供 PreciseShardingAlgorithm 和 RangeShardingAlgorithm 两个分片算法。
         * PreciseShardingAlgorithm 是必选的，用于处理 = 和 IN 的分片。
         * RangeShardingAlgorithm 是可选的，用于处理 BETWEEN AND, >, <, >=, <= 分片，如果不配置 RangeShardingAlgorithm，SQL 中的 BETWEEN AND 将按照全库路由处理。
         */
        availableTargetNames.forEach(item -> {
            System.out.println("真实的数据库名称：" + item);
        });
        //逻辑表以及分片的字段名
        System.out.println("逻辑表名：" + preciseShardingValue.getLogicTableName() + "；分片字段名：" + preciseShardingValue.getColumnName());
        System.out.println("分片字段值：" + preciseShardingValue.getValue().toString());
        //获取字段值
        long orderId = preciseShardingValue.getValue();
        //分片索引计算(db0和db1)
        long dbIndex = orderId & 1;
        for (String index : availableTargetNames) {
            if (index.equals("ds" + dbIndex)) {
                return index;
            }
        }
        throw new IllegalArgumentException();
    }
}
