package com.newb.mybatis.config.shard;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@AutoConfigureAfter(ShardMybatisConf.class)
public class MyBatisMapperScannerConfig {
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.newb.db.dao");// mapper类路径
        return mapperScannerConfigurer;
    }
}
