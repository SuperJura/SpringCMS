/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.db;

import com.spring.db.interfaces.UserDAO;
import com.spring.models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author JuraLocal
 */
public class UserDAOImpl implements UserDAO{

    private final SessionFactory sessionFactory;

    public UserDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public User getUser(String username, String password) {
        
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(User.class);
        Criterion name = Restrictions.eq("name", username);
        Criterion pass = Restrictions.eq("password", password);

        LogicalExpression and = Restrictions.and(name, pass);
        cr.add(and);
        User user = (User)cr.uniqueResult();
        session.close();

        return user;
    }

    @Override
    public boolean existUsername(String username) {
        Session session = sessionFactory.openSession();
        
        Criteria cr = session.createCriteria(User.class);
        User user = (User)cr.add(Restrictions.eq("name", username)).uniqueResult();
        
        session.close();
        
        return user != null;
    }

    @Override
    public void insert(User user) { 
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }
}
