package com.dcxt.bean;

public class UserBean {
    private int id;
    private String uname;
    private String password;
    private int type;
    private int isReservation;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsReservation() {
        return isReservation;
    }

    public void setIsReservation(int isReservation) {
        this.isReservation = isReservation;
    }


}
