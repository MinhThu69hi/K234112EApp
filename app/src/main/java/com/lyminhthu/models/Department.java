package com.lyminhthu.models;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class Department {
    private String id;

    private String name;
    private ArrayList<Employee> ListEmployee;


    public Department() {
        ListEmployee = new ArrayList<>();
    }

    public Department(String id, String name) {
        this.id = id;
        this.name = name;
        ListEmployee = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
    public void addEmployee(Employee employee) {
        ListEmployee.add(employee);
    }
    public void addListEmployee(ArrayList<Employee> employees) {
        ListEmployee.addAll(employees);
    }
    public ArrayList<Employee> getListEmployee() {
        return ListEmployee;
    }
}

