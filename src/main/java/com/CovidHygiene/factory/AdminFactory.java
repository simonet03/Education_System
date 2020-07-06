package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Admin;


public class AdminFactory {

    public static Admin buildAdmin(String adminNum, String firstName, String lastName, String address){

        Admin admin = new Admin.Builder()
                .setAdminNum(adminNum)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setAddress(address)
                .build();

        return admin;

    }
}
