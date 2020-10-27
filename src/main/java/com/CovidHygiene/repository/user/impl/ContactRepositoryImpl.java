package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Contact;
import com.CovidHygiene.repository.user.ContactRepository;

import java.util.HashSet;
import java.util.Set;

public class ContactRepositoryImpl implements ContactRepository {

//===========================================================

    private static ContactRepository contactRepository = null;
    private Set<Contact> contactDB;

    private ContactRepositoryImpl(){
        this.contactDB = new HashSet<>();
    }

    //==============================================================


    public static ContactRepository getContactRepository(){
        if(contactRepository == null){
            contactRepository = new ContactRepositoryImpl();
        }
        return contactRepository;
    }


    @Override
    public Contact create(Contact contact) {
        this.contactDB.add(contact);
        return contact;
    }


    @Override
    public Contact read(Long number) {

        for(Contact contact : this.contactDB){
            if(contact.getCellPhone() == number){
                return contact;
            }
        }

        return null;
    }


    @Override
    public Contact update(Contact contact) {
        boolean deleteContact = delete(contact.getCellPhone());

        if(deleteContact){
            this.contactDB.add(contact);
            return contact;
        }

        return null;
    }


    @Override
    public boolean delete(Long number) {
        Contact contact= read(number);

        if(contact != null){
            this.contactDB.remove(contact);
            return true;
        }

        return false;
    }


    @Override
    public Set<Contact> getAll() {
        return contactDB;
    }


}
