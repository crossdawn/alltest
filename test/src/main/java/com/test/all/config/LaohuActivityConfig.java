package com.test.all.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = {"com.test.all.mysql"}, sqlSessionFactoryRef = "sqlSessionFactoryLaohuActivity")
public class LaohuActivityConfig {
    @Autowired
    @Qualifier("testDataSource")
    private DataSource dataSource;

    private static final String TX_ACTIVITY = "TX_ACTIVITY";

    @Bean
    public SqlSessionFactory sqlSessionFactoryLaohuActivity() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
        return factoryBean.getObject();
    }

    @Bean(name = TX_ACTIVITY)
    public DataSourceTransactionManager appTransactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplateLaohuActivity() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactoryLaohuActivity());
    }

}
