package com.book;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by forandroid on 16-10-4.
 */
public class DeleteAction extends ActionSupport {
    String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String execute () {
        Mysql sql = new Mysql();
        String name = getTitle();
        return sql.delete_book (name);
    }
}
