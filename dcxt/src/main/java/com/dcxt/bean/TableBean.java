package com.dcxt.bean;

/**
 * Created by yyangcr on 17-10-11.
 */
public class TableBean {
    private int id;
    private int  uid;
    private String tablenum;
    private String tablename;
    private int  galleryful;
    private int     state;
    private String consumenum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getTablenum() {
        return tablenum;
    }

    public void setTablenum(String tablenum) {
        this.tablenum = tablenum;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public int getGalleryful() {
        return galleryful;
    }

    public void setGalleryful(int galleryful) {
        this.galleryful = galleryful;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getConsumenum() {
        return consumenum;
    }

    public void setConsumenum(String consumenum) {
        this.consumenum = consumenum;
    }
}
