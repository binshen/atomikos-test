package com.giant.config;

import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jta.atomikos.AtomikosDataSourceBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Autowired
    private DataSourceProperties dataSourceProperties;

    @Bean(name = "testXaDataSource")
    @Primary
    public DataSource testDataSource() {
        MysqlXADataSource mysqlXaDataSource = new MysqlXADataSource();
        mysqlXaDataSource.setUrl(dataSourceProperties.getUrl());
        mysqlXaDataSource.setUser(dataSourceProperties.getUsername());
        mysqlXaDataSource.setPassword(dataSourceProperties.getPassword());
//        mysqlXaDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8&useSSL=true");
//        mysqlXaDataSource.setUser("root");
//        mysqlXaDataSource.setPassword("");
        mysqlXaDataSource.setPinGlobalTxToPhysicalConnection(true);
        AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
        ds.setXaDataSource(mysqlXaDataSource);
        ds.setXaDataSourceClassName("com.alibaba.druid.pool.xa.DruidXADataSource");
        ds.setUniqueResourceName("testXaDataSource");
        ds.setPoolSize(5);
        ds.setTestQuery("SELECT 1");
        return ds;
    }

    @Bean
    @Primary
    public SqlSessionFactory testSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(testDataSource());
        return sqlSessionFactoryBean.getObject();
    }
}
