package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Contact;
import com.CovidHygiene.repository.IRepository;

import java.util.Set;

public interface ContactRepository extends IRepository <Contact, Long> {

    Set<Contact> getAll();
}
