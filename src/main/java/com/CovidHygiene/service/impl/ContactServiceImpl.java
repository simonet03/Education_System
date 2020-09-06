package com.CovidHygiene.service.impl;

import com.CovidHygiene.entity.Contact;
import com.CovidHygiene.repository.user.ContactRepository;
import com.CovidHygiene.repository.user.impl.ContactRepositoryImpl;
import com.CovidHygiene.service.user.ContactService;

import java.util.Set;

public class ContactServiceImpl implements ContactService {


    private static ContactService service = null;
    private ContactRepository repository;

    private ContactServiceImpl(){
        this.repository =  ContactRepositoryImpl.getContactRepository();
    }


    public static ContactService getService(){
        if(service == null){
            service = new ContactServiceImpl();
        }
        return service;
    }


    @Override
    public Set<Contact> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.create(contact);
    }

    @Override
    public Contact read(Long aLong) {
        return this.repository.read(aLong);
    }

    @Override
    public Contact update(Contact contact) {
        return this.repository.update(contact);
    }

    @Override
    public boolean delete(Long aLong) {
        return this.repository.delete(aLong);
    }
}
