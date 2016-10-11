package com.book;

import com.opensymphony.xwork2.ActionSupport;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.SimpleFormatter;

/**
 * Created by forandroid on 16-10-3.
 */
public class AddBookAction extends ActionSupport {
    public int ISBN;
    public String title;
    public String author_name;
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
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String execute() {
        Mysql sql = new Mysql();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date publisher_date = new Date(sd.parse(getPublish_date().toString()).getTime());
            Book b = new Book(getISBN(),getTitle()
                ,1,
                getPublisher(),publisher_date,getPrice());
            return sql.add_book(b,getAuthor_name());
        }catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
