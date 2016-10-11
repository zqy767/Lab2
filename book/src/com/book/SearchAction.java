package com.book;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

/**
 * Created by forandroid on 16-9-28.
 */
public class SearchAction extends ActionSupport{
    String author_name;

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    @Override
    public String execute() {
        Mysql sql = new Mysql();
        /*try {
        System.out.println(getAuthor_name().equals(new String (getAuthor_name().getBytes("UTF-8"),"UTF-8")));
        }catch (Exception e) {
            e.printStackTrace();
        }
        */
        Author author = sql.get_author(getAuthor_name());
        if (author == null) return "fail";
        ActionContext.getContext().getSession().put("author", author);
        ArrayList<Book> books = sql.get_books(getAuthor_name());
        ActionContext.getContext().getSession().put("author_list", books);
        return "success";

    }
}
