package com.book;

import java.sql.Date;

/**
 * Created by forandroid on 16-9-28.
 */
public class Book {
    public int ISBN;
    public String title;
    public int Authorid;
    public String publisher;
    public Date publish_date;
    public int price;
    Book (  int ISBN, String title, int Authorid, String publisher,
            Date publish_date, int price) {
        this.Authorid = Authorid;
        this.ISBN = ISBN;
        this.title = title;
        this.publisher = publisher;
        this.publish_date = publish_date;
        this.price = price;
    }
}
