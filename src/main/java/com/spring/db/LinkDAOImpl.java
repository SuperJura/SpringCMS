/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.db;

import com.spring.db.interfaces.LinkDAO;
import com.spring.models.Link;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author JuraLocal
 */
public class LinkDAOImpl implements LinkDAO {
    
    private final SessionFactory sessionFactory;

    public LinkDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Link> list() {
        Session session = sessionFactory.openSession();
        List<Link> listLink = (List<Link>) session
                .createCriteria(Link.class)
                .list();
        session.close();

        return listLink;
    }

    @Override
    public void insert(Link link) {

        Session session = null;
        Transaction tx = null;
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
        session.save(link);
        tx.commit();
        session.close();

    }
}
