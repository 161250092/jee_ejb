package model;

import java.io.Serializable;

public class User implements Serializable{
    String id;
    String pw;
    String name;
    double money;

    public User(String id, String pw, String name, double money) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.money = money;
    }

    public User(String id, String name, double money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
