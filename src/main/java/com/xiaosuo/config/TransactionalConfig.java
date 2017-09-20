package com.xiaosuo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 事务配置
 * 
 * @author suozhaoyu
 * @since  0.0.1
 */
@Configuration
@EnableTransactionManagement(order=10)
public class TransactionalConfig {

}
