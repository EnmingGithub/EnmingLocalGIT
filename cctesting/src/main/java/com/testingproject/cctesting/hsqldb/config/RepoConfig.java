package com.testingproject.cctesting.hsqldb.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.testingproject.cctesting.hsqldb.entity"})
@EnableJpaRepositories(basePackages = {"com.testingproject.cctesting.hsqldb.repository"})
@EnableTransactionManagement
public class RepoConfig {

}
