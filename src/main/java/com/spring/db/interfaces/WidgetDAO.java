package com.spring.db.interfaces;

import com.spring.models.Text;
import com.spring.models.Widget;
import java.util.List;

/**
 *
 * @author Jurica
 */
public interface WidgetDAO {
    
    public List<Widget> getAllWidgets();
}
