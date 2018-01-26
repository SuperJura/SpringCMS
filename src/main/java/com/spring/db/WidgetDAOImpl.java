package com.spring.db;

import com.spring.db.interfaces.WidgetDAO;
import com.spring.models.Widget;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author JuraLocal
 */
public class WidgetDAOImpl implements WidgetDAO{

    SessionFactory sessionFactory;

    public WidgetDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @Override
    public List<Widget> getAllWidgets() {
        
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Widget.class);

        List<Widget> widgets = (List<Widget>)cr.addOrder(Order.desc("widgetId")).list();
        session.close();
        
        return widgets;
    }

    @Override
    public Widget getWidgetForId(int widgetId) {
        Session session = sessionFactory.openSession();
        Criteria cr = session.createCriteria(Widget.class);

        Widget widget = (Widget)cr.add(Restrictions.eq("widgetId", widgetId)).uniqueResult();
        session.close();
        
        return widget;
    }
}