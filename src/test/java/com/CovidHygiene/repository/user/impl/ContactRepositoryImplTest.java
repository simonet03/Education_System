package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Contact;
import com.CovidHygiene.factory.ContactFactory;
import com.CovidHygiene.repository.user.ContactRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ContactRepositoryImplTest {

    private static ContactRepository contactRepository = ContactRepositoryImpl.getContactRepository();
    private static Contact contact = ContactFactory.createContact(27735843267L, 0, "email@gmail.com");


    @Test
    public void a_create() {
        Contact created = contactRepository.create(contact);
        Assert.assertNotNull(contact.getCellPhone());
        System.out.println("Created: " + created);
    }

    @Test
    public void b_read() {
        Contact read = contactRepository.read(contact.getCellPhone());
        System.out.println("Read: " + read);
    }

    @Test
    public void c_update() {
        Contact updated = new Contact.Builder().copy(contact).setHomePhone(2771234567l).build();
        updated = contactRepository.update(updated);
        System.out.println("Updated: "+ updated);
    }

    @Test
    public void d_getAll() {
        System.out.println("Get All: "+ contactRepository.getAll());
    }

    @Test
    public void e_delete() {
        boolean deleted = contactRepository.delete(contact.getCellPhone());
        Assert.assertTrue(deleted);
    }
}