package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Contact;
import com.CovidHygiene.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

}
