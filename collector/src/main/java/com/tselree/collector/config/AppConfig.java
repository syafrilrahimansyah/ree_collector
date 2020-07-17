package com.tselree.collector.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.tselree.collector.DAO.CollectDAO;
import com.tselree.collector.DAO.CollectDAOimpl;
import com.tselree.collector.DAO.OmniformDAO;
import com.tselree.collector.DAO.OmniformDAOimpl;

@Configuration
@ComponentScan(basePackages="com.tselree.collector")
public class AppConfig {
	@Bean()
    public DataSource getDataSource1() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/C2C?serverTimezone=UTC&useLegacyDatetimeCode=false");
        dataSource.setUsername("pmauser");
        dataSource.setPassword("alvin147");
         
        return dataSource;
    }
	@Bean()
    public DataSource getDataSource2() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/extractor?serverTimezone=UTC&useLegacyDatetimeCode=false");
        dataSource.setUsername("pmauser");
        dataSource.setPassword("alvin147");
         
        return dataSource;
    }
     
    @Bean(name="sql1")
    public CollectDAO getLaunchInfoDAO() {
        return new CollectDAOimpl(getDataSource1());
    }
    @Bean(name="sql2")
    public OmniformDAO getTimeRecordDAO() {
    	return new OmniformDAOimpl(getDataSource2());
    }
	
}
