package com.book;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by forandroid on 16-10-4.
 */
public class UpdateAction extends ActionSupport {
    public int ISBN;
    public String title;
    public String Author_name;
    public String publisher;
    public String publish_date;
    public int price;

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor_name() {
        return Author_name;
    }

    public void setAuthor_name(String author_name) {
        Author_name = author_name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String execute () {
        Mysql sql = new Mysql();
        String bookname = getTitle();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (getISBN() != 0)
                if (sql.update_int(bookname,"ISBN",getISBN()).equals("fail")) return "fail";

            if (getAuthor_name()!=null && !getAuthor_name().equals("")) {
                int id = sql.get_author(getAuthor_name()).id;
                if (sql.update_int(bookname, "AuthorID", id).equals("fail")) return "fail";
            }
            if (getPublisher()!=null && !getPublisher().equals(""))
                if (sql.update_string(bookname,"Publisher",getPublisher()).equals("fail")) return "fail";

            if (getPrice() != 0)
                if (sql.update_int(bookname,"Price",getPrice()).equals("fail")) return "fail";

            if (getPublish_date()!=null && !getPublish_date().equals("")) {
                Date publisher_date = new Date(sd.parse(getPublish_date().toString()).getTime());
                if (sql.update_date(bookname,"PublishDate",publisher_date).equals("fail")) return "fail";
            }

            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }
}
