package com.spring.db.interfaces;

import com.spring.models.Page;
import java.util.List;

/**
 *
 * @author JuraLocal
 */
public interface PageDAO {
    public List<Page> getAllPages();
    public Page getPage(int pageId);
    public Page getMainPage();
    public void insertPage(Page page);
    public void updatePage(Page page);
}
