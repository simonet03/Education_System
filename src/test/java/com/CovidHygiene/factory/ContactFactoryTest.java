package com.CovidHygiene.factory;

import com.CovidHygiene.entity.Contact;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactFactoryTest {

    @Test
    public void createContact() {

        Contact contact = ContactFactory.createContact(27735843267L, 0, "email@gmail.com");

        assertNotNull(contact);

        System.out.println(contact.toString());
    }

    @Test
    public void testEquals() {

        Contact contact1 = ContactFactory.createContact(27735843267L, 0, "email@gmail.com");

        Contact contact2 = ContactFactory.createContact(27735843267L, 0, "email@gmail.com");

        contact1.equals(contact2);
    }
}