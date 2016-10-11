package com.book;

import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by forandroid on 16-9-28.
 */
public class Mysql {

    Statement stmt;
    Connection conn;

    Mysql() {
        String url="jdbc:mysql://w.rdc.sae.sina.com.cn:3307/BookDB";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url,"jyyoo00144","i000mmwlylmyyi5xky20yzzlwl0jiw50hk5yj2l3");
            stmt = conn.createStatement(); //创建Statement对象
            stmt.execute("SET NAMES UTF8;");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Author get_author (String name) {
        String sql = "select * from Author where Name = ".concat("\'").concat(name).concat("\'").concat(";");
        try {
            ResultSet res = stmt.executeQuery(sql);
            if (res.next()) {
                String author_name = res.getString("Name");
                int age = res.getInt("Age");
                String country = res.getString("Country");
                int authorid = res.getInt("AuthorID");
                return new Author(author_name, age, country, authorid);
            }
            else return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<Book> get_books (String name) {
        try {
            String sql = "select * from Book where AuthorID = "
                    .concat("(").concat("select AuthorID from Author where Name = ")
                    .concat("\'").concat(name).concat("\'")
                    .concat(")").concat(";");
            ResultSet res = stmt.executeQuery(sql);
            ArrayList<Book> ans = new ArrayList<>();
            while (res.next()) {
                int ISBN = res.getInt("ISBN");
                String title = res.getString("Title");
                int id = res.getInt("AuthorID");
                String publisher = res.getString("Publisher");
                Date publishdate = res.getDate("PublishDate");
                int price = res.getInt("Price");
                ans.add(new Book(ISBN,title,id,publisher,publishdate,price));
            }

            return ans;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String add_book (Book b,String name) {
        String sql = "select AuthorID from Author where Name = "
                .concat("\'")
                .concat(name)
                .concat("\';");
        try {
            ResultSet res = stmt.executeQuery(sql);
            if (res.next()) {
                int id = res.getInt("AuthorID");
                sql = "insert into Book VALUES(?,?,?,?,?,?);";
                PreparedStatement bookst = conn.prepareStatement(sql);
                bookst.setInt(1,b.ISBN);
                bookst.setString(2,b.title);
                bookst.setInt(3,id);
                bookst.setString(4,b.publisher);
                bookst.setDate(5,b.publish_date);
                bookst.setInt(6,b.price);
                bookst.executeUpdate();
                return "success";
            }
            else return "fail";

        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }




    }

    public String add_author (Author a) {
        String sql = "insert into Author (Name,Age,Country) VALUES(?,?,?);";
        try {
            PreparedStatement authorst = conn.prepareStatement(sql);
            authorst.setString(1,a.name);
            authorst.setInt(2,a.age);
            authorst.setString(3,a.country);
            authorst.executeUpdate();
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "fail";
        }

    }

    public String update_int (String title,String col,int num) {
        try {
            stmt.execute("update Book set " + col + "=" + num + " where Title = "+ "\'"+title+"\';");
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "fail";
        }
    }

    public String update_string (String title,String col,String data) {
        try {
            stmt.execute("update Book set " + col + "=" + "\'" +data+"\'" + " where Title = "+ "\'"+title+"\';");
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "fail";
        }
    }

    public String update_date (String title,String col,Date data) {
        try {

            stmt.execute("update Book set " + col + "=" + "\'" +data.toString()+"\'" + " where Title = "+ "\'"+title+"\';");
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "fail";
        }
    }

    public String delete_book (String name) {
        try {
            stmt.execute("delete from Book where Title = " +"\'"+name+"\';" );
            return "success";
        } catch (SQLException e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
