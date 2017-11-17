package com.example.mrbug.sqliteexample.entities;

/**
 * Created by MrBug on 14.11.2017.
 */

public class user {
    public user(){}
    public user(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public user(Integer id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    Integer id;
    String name;
    String surname;

    public  String toString(){
        return "isim : "+name+" soyisim : "+surname;
    }
}
