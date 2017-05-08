package com.newb.mybatis.config.shard;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DruidDataSourceConfig {

	@Bean(name = "primaryDataSource")
	@Primary
	@ConfigurationProperties(prefix = "spring.datasource.primary,spring.datasource.druid")
	public DataSource primaryDataSource(
			@Value("${spring.primary.driverClassName}") String driver,
			@Value("${spring.primary.url}") String url, 
			@Value("${spring.primary.username}") String username,
			@Value("${spring.primary.password}") String password) {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driver);
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);

		return druidDataSource;

	}

	@Bean(name = "secondaryDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.secondary,spring.datasource.druid")
	public DataSource secondaryDataSource(
			@Value("${spring.primary.driverClassName}") String driver,
			@Value("${spring.primary.url}") String url, 
			@Value("${spring.primary.username}") String username,
			@Value("${spring.primary.password}") String password) {
		DruidDataSource druidDataSource = new DruidDataSource();
		druidDataSource.setDriverClassName(driver);
		druidDataSource.setUrl(url);
		druidDataSource.setUsername(username);
		druidDataSource.setPassword(password);
			
		return druidDataSource;
	}
}
