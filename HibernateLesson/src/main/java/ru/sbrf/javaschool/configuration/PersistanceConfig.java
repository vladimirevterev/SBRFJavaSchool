package ru.sbrf.javaschool.configuration;

import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.TargetSource;
import org.springframework.expression.ParserContext;
import org.hibernate.annotations.common.reflection.ReflectionManager;
import org.dom4j.DocumentException;
import org.jboss.logging.BasicLogger;
import javax.transaction.SystemException;
import javassist.util.proxy.MethodFilter;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:persistence.properties"})
@ComponentScan("ru.sbrf.javaschool.persistence")
public class PersistanceConfig {

    private final Environment environment;

    @Autowired
    public PersistanceConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    @Order(1)
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getProperty("jdbc.url"));
        dataSource.setUsername(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.pass"));
        return dataSource;
    }

    @Bean
    @Order(2)
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        final LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setPackagesToScan("ru/sbrf/javaschool/persistence");
        final Properties property = new Properties();
        property.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
        property.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
        property.setProperty("hibernate.hbm2ddl", environment.getProperty("hibernate.hbm2ddl"));
        factoryBean.setHibernateProperties(property);
        return factoryBean;
    }

    @Bean
    @Order(3)
    public HibernateTransactionManager transactionManager(DataSource dataSource, SessionFactory sessionFactory) {
        final HibernateTransactionManager tr = new HibernateTransactionManager();
        tr.setDataSource(dataSource);
        tr.setSessionFactory(sessionFactory);
        return tr;
    }


}
