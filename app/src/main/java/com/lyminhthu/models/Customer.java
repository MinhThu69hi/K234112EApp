package com.lyminhthu.models;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private String cusId;
    private String cusName;
    private String birthday;
    private String phone;
    private String address;
    private String email;

    public Customer() {
    }

    public Customer(String cusId, String cusName, String birthday, String phone, String address, String email) {
        this.cusId = cusId;
        this.cusName = cusName;
        this.birthday = birthday;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Customer(String id, String name, String phone, String email, Date time, String address) {
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cusId='" + cusId + '\'' +
                ", cusName='" + cusName + '\'' +
                ", birthday='" + birthday + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
