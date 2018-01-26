package com.spring.db;

import com.spring.db.interfaces.TextDAO;
import com.spring.models.Text;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author JuraLocal
 */
public class TextDAOImpl implements TextDAO{

    SessionFactory sessionFactory;

    public TextDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Text> getAllTextsForPageId(int idPage) {
        
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Text.class);
        Criterion page = Restrictions.eq("idPage", idPage);

        cr.add(page);
        List<Text> texts = (List<Text>)cr.addOrder(Order.desc("textId")).list();
        session.close();
        
        return texts;
    }

    @Override
    public void insertNewText(Text text) {
        Date date = new java.sql.Date(Calendar.getInstance().getTimeInMillis()); 
        text.setDateAdded(date);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(text);
        tx.commit();
        session.close();
    }

    @Override
    public void updateText(Text text) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.update(text);
        tx.commit();
        session.close();
    }

    @Override
    public Text getText(int textId) {
        
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Text.class);
        Criterion textIdCr = Restrictions.eq("textId", textId);

        cr.add(textIdCr);
        Text texts = (Text)cr.uniqueResult();
        session.close();
        
        return texts;
    }

    @Override
    public void deleteText(Text text) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(text);
        tx.commit();
        session.close();
    }
}