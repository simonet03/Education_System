package com.CovidHygiene.service.user;

import com.CovidHygiene.entity.Contact;
import com.CovidHygiene.service.IService;

import java.util.Set;

public interface ContactService extends IService<Contact, Long> {

    Set<Contact> getAll();
}
