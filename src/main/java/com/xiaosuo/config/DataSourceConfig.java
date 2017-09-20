package com.xiaosuo.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * c3p0创建的datasource配置
 * 
 * 
 * @author suozhaoyu
 * @since  0.1.1
 */
@Configuration
public class DataSourceConfig {

	@Bean(name = "dataSource")
	@Primary
	@ConfigurationProperties(prefix = "c3p0")
	public DataSource dataSource(){
		return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
	}
}
