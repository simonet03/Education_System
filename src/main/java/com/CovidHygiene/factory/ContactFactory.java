package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Contact;

public class ContactFactory {

    public static Contact createContact(long cellPhone, long homePhone, String email) {

        Contact contact = new Contact.Builder()
                .setCellPhone(cellPhone)
                .setHomePhone(homePhone)
                .setEmail(email)
                .build();


        return contact;
    }
}
