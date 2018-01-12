package com.spring.db;

import com.spring.db.interfaces.TextDAO;
import com.spring.models.Text;
import com.spring.models.User;
import java.util.List;
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
        List<Text> texts = (List<Text>)cr.list();
        session.close();
        
        return texts;
    }

    @Override
    public void insertNewText(Text text) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(text);
        tx.commit();
        session.close();
    }
}