package com.lyminhthu.models;

public class Category {
    private String categoryid;
    private String categoryname;
    private String description;

    public Category() {
    }

    public Category(String categoryid, String categoryname, String description) {
        this.categoryid = categoryid;
        this.categoryname = categoryname;
        this.description = description;
    }

    public String getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryid='" + categoryid + '\'' +
                ", categoryname='" + categoryname + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
