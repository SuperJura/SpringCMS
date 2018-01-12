/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.configs;

import com.spring.db.interfaces.LinkDAO;
import com.spring.db.LinkDAOImpl;
import com.spring.db.PageDAOImpl;
import com.spring.db.TextDAOImpl;
import com.spring.db.UserDAOImpl;
import com.spring.db.interfaces.PageDAO;
import com.spring.db.interfaces.TextDAO;
import com.spring.db.interfaces.UserDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

/**
 *
 * @author JuraLocal
 */
@Configuration
public class DbConfig {
    
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
}