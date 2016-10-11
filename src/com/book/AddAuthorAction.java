package com.book;

import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by forandroid on 16-10-4.
 */
public class AddAuthorAction extends ActionSupport{
    public String name;
    public int age;
    public String country;
    public int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    @Override
    public String execute() {
        Mysql sql = new Mysql();
        if (getName()== null || getName().equals("")) return "fail";
        Author a = new Author(getName(),getAge(),getCountry(),1);
        return sql.add_author(a);
    }

}
