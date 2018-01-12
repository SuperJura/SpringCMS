/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.db;

import com.spring.db.interfaces.PageDAO;
import com.spring.models.Page;
import com.spring.models.Text;
import com.spring.models.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author JuraLocal
 */
public class PageDAOImpl implements PageDAO{

    private SessionFactory sessionFactory;

    public PageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Page> getAllPages() {
                
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Page.class);

        List<Page> pages = (List<Page>)cr.list();
        session.close();
        
        return pages;
    }

    @Override
    public Page getPage(int pageId) {
        
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Page.class);

        Page page = (Page) cr.add(Restrictions.eq("pageId", pageId)).uniqueResult();
        session.close();
        
        return page;
    }
    
    @Override
    public Page getMainPage() {
        return getPage(1);
    }
    

    @Override
    public void insertPage(Page page) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(page);
        tx.commit();
        session.close();
    }

    @Override
    public void updatePage(Page page) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(page);
        tx.commit();
        session.close();
    }

    
}
