package com.spring.configs;

import com.spring.aop.DbPingAspect;
import com.spring.db.interfaces.LinkDAO;
import com.spring.db.LinkDAOImpl;
import com.spring.db.PageDAOImpl;
import com.spring.db.TextDAOImpl;
import com.spring.db.UserDAOImpl;
import com.spring.db.UserStoryDAOImpl;
import com.spring.db.WidgetDAOImpl;
import com.spring.db.interfaces.PageDAO;
import com.spring.db.interfaces.TextDAO;
import com.spring.db.interfaces.UserDAO;
import com.spring.db.interfaces.UserStoryDAO;
import com.spring.db.interfaces.WidgetDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author JuraLocal
 */
@Configuration
@EnableTransactionManagement()
public class DbConfig {
    
    @Bean()
    public HibernateTransactionManager txName(){
        HibernateTransactionManager txName= new HibernateTransactionManager();
        txName.setSessionFactory(sessionFactory().getObject());
        txName.setDataSource(dataSource());
        return txName;
   }
    
    @Bean DbPingAspect aopPing(){
        return new DbPingAspect();
    }
    
    @Bean 
    public BasicDataSource dataSource(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl("jdbc:postgresql:CMS");
        ds.setUsername("postgres");
        ds.setPassword("SQL");
        
        return ds;
    }
    
    @Bean
    public LocalSessionFactoryBean sessionFactory(){
        LocalSessionFactoryBean session = new LocalSessionFactoryBean();
        session.setDataSource(dataSource());
        Resource resource = new ClassPathResource("hibernate.cfg.xml");
        session.setConfigLocation(resource);
        
        return session;
    }
    
    @Bean
    public LinkDAO linkDAO(){
        LinkDAO dao = new LinkDAOImpl(sessionFactory().getObject());
        return dao;
    }
    
    @Bean
    public UserDAO userDAO(){
        UserDAO dao = new UserDAOImpl(sessionFactory().getObject());
        return dao;
    }
    
    @Bean
    public PageDAO pageDAO(){
        PageDAO dao = new PageDAOImpl(sessionFactory().getObject());
        return dao;
    }
    
    @Bean
    public TextDAO textDAO(){
        TextDAO dao = new TextDAOImpl(sessionFactory().getObject());
        return dao;
    }
    
    @Bean
    public WidgetDAO widgetDAO(){
        WidgetDAO dao = new WidgetDAOImpl(sessionFactory().getObject());
        return dao;
    }
    
    @Bean
    public UserStoryDAO userStoryDAO(){
        UserStoryDAO dao = new UserStoryDAOImpl(sessionFactory().getObject());
        return dao;
    }
}