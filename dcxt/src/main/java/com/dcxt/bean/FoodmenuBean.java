package com.dcxt.bean;

/**
 * Created by yyangcr on 17-10-13.
 */
public class FoodmenuBean {

    private int id;
    private String describes;
    private Double price;
    private String foodname;
    private String   foodimg;
    private int classinfo;
    private String classname;

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getFoodimg() {
        return foodimg;
    }

    public void setFoodimg(String foodimg) {
        this.foodimg = foodimg;
    }

    public int getClassinfo() {
        return classinfo;
    }

    public void setClassinfo(int classinfo) {
        this.classinfo = classinfo;
    }

    @Override
    public String toString() {
        return "FoodmenuBean{" +
                "id=" + id +
                ", price=" + price +
                ", foodname='" + foodname + '\'' +
                ", foodimg='" + foodimg + '\'' +
                ", classinfo='" + classinfo + '\'' +
                '}';
    }
}
