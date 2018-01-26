/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.db;

import com.spring.db.interfaces.LinkDAO;
import com.spring.db.interfaces.PageDAO;
import com.spring.db.interfaces.TextDAO;
import com.spring.db.interfaces.UserStoryDAO;
import com.spring.models.Link;
import com.spring.models.Page;
import com.spring.models.Text;
import com.spring.models.UserStory;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author JuraLocal
 */
public class PageDAOImpl implements PageDAO{

    private SessionFactory sessionFactory;
    
    @Autowired
    TextDAO textDao;
    
    @Autowired
    LinkDAO linkDao;
    
    @Autowired
    UserStoryDAO userStoryDao;

    public PageDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Page> getAllPages() {
                
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Page.class);

        List<Page> pages = (List<Page>)cr.addOrder(Order.desc("pageId")).list();
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

    @Override
    public void deletePage(Page page) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List<Link> links = linkDao.getAllLinks();
        for (Link link : links) {
            if(link.getDesPageId() == page.getPageId()){
                link.setDesPageId(-1);
                linkDao.update(link);
                break;
            }
        }
        
        List<UserStory> stories = userStoryDao.getAllStoriesForPage(page.getPageId());
        for (int i = 0; i < stories.size(); i++) {
            session.delete(stories.get(i));
        }
        
        List<Text> texts = textDao.getAllTextsForPageId(page.getPageId());
        for (int i = 0; i < texts.size(); i++) {
            session.delete(texts.get(i));
        }
        session.delete(page);
        
        
        tx.commit();
        session.close();
    }
}