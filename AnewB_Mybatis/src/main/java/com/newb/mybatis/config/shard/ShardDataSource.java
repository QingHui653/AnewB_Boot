package com.newb.mybatis.config.shard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dangdang.ddframe.rdb.sharding.api.ShardingDataSourceFactory;
import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.ShardingRule;
import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;

/***
 * sharding-jdbc 配置数据源和分库分表规则
 * 
 * @author woshizbh
 *
 */
@Component
public class ShardDataSource {

	@Autowired
	@Qualifier("primaryDataSource")
	private DataSource primaryDataSource;

	@Autowired
	@Qualifier("secondaryDataSource")
	private DataSource secondaryDataSource;

	private DataSource shardingDataSource;

	@PostConstruct
	public void init() {
		Map<String, DataSource> map = new HashMap<String, DataSource>();
		//连接的数据库
		map.put("testdb0", primaryDataSource);
		map.put("testdb1", secondaryDataSource);
		
		DataSourceRule dataSourceRule = new DataSourceRule(map);
		List<TableRule> tableRuleList = new ArrayList<TableRule>();
		
		//表
		List<String> pList = new ArrayList<String>();
		for (int i = 1; i < 3; i++) {
			pList.add("t_order_" + i);
		}
		//分片
		tableRuleList.add(new TableRule.TableRuleBuilder("t_order").actualTables(pList).dataSourceRule(dataSourceRule)
				.tableShardingStrategy(new TableShardingStrategy("order_id", new TableShardingAlgorithm())).build());
		
		//分库
		ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule)
				.databaseShardingStrategy(new DatabaseShardingStrategy("order_id", new DatabaseShardingAlgorithm()))
				.tableRules(tableRuleList).build();
		
		
		shardingDataSource = ShardingDataSourceFactory.createDataSource(shardingRule);
	}

	public DataSource getShardingDataSource() {
		return shardingDataSource;
	}
}
