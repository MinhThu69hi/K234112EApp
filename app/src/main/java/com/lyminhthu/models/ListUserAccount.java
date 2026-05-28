package com.lyminhthu.models;

import java.util.ArrayList;

public class ListUserAccount {
    public static ArrayList<UserAccount> getUserAccounts() {
        ArrayList<UserAccount> database = new ArrayList<>();
        database.add(new UserAccount("admin", "123", "admin", "Trần Văn Tèo", true));
        database.add(new UserAccount("user1", "123", "employee", "Hồ Văn Đồ", true));
        database.add(new UserAccount("user2", "123", "employee", "Nguyễn Văn Tuấn", true));
        return database;

    }
    public static UserAccount login(String username, String password) {
        //step1:query database
        ArrayList<UserAccount> database = getUserAccounts();
        //step2:compare username and password
        for (UserAccount userAccount : database) {
            if (userAccount.getUsername().equalsIgnoreCase(username) && userAccount.getPassword().equals(password)) {
                return userAccount;
            }
        }
        return null;
    }
}
