package com.spring.db;

import com.spring.db.interfaces.UserStoryDAO;
import com.spring.models.UserStory;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author JuraLocal
 */
public class UserStoryDAOImpl implements UserStoryDAO{

    SessionFactory sessionFactory;
    
    public UserStoryDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<UserStory> getAllStoriesForPage(int pageId) {
        Session session = sessionFactory.openSession();
        List<UserStory> stories = (List<UserStory>) session
                .createCriteria(UserStory.class)
                .add(Restrictions.eq("idPage", pageId))
                .addOrder(Order.desc("userStoryId"))
                .list();
        session.close();

        return stories;
    }

    @Override
    public void insertNewStory(UserStory story) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(story);
        tx.commit();
        session.close();
    }
}