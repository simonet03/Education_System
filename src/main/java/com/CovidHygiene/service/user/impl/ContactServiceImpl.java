package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Contact;
import com.CovidHygiene.repository.user.ContactRepository;
import com.CovidHygiene.service.user.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {


    @Autowired
    private ContactRepository repository;


    @Override
    public Set<Contact> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Contact create(Contact contact) {
        return this.repository.save(contact);
    }

    @Override
    public Contact read(Long aLong) {
        return this.repository.findById(aLong).orElseGet(null);
    }

    @Override
    public Contact update(Contact contact) {
        //must check with IF Statement first
        if (this.repository.existsById(contact.getCellPhone())) {
            return this.repository.save(contact);
        }
        return null;
    }

    @Override
    public boolean delete(Long aLong) {
        this.repository.deleteById(aLong);

        if (this.repository.existsById(aLong)){
            return false;
        }
        return true;
    }
}
