package com.datachester.ordermanagement.orderprocessing.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;




@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.datachester.ordermanagement.orderprocessing.entity"})
@EnableJpaRepositories(basePackages = {"com.datachester.ordermanagement.orderprocessing.repo"})
@EnableTransactionManagement
public class RepositoryConfig{
}

