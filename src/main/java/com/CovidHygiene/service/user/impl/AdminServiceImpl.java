package com.CovidHygiene.service.user.impl;

import com.CovidHygiene.entity.Admin;
import com.CovidHygiene.repository.user.AdminRepository;
import com.CovidHygiene.service.user.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository repository;

    @Override
    public Set<Admin> getAll() {
                return this.repository.findAll().stream().collect(Collectors.toSet());
            }

    @Override
    public Admin create(Admin admin) {
                return this.repository.save(admin);
            }

    @Override
     public Admin read(String a) {
                return this.repository.findById(a).orElseGet(null);
            }

     @Override
     public Admin update(Admin admin) {
         if (this.repository.existsById(admin.getAdminNum())) {
             return this.repository.save(admin);
         }
         return null;
     }
     @Override
     public boolean delete(String a) {
        this.repository.deleteById(a);
        if(this.repository.existsById(a)) return false;
        return true;
    }
}



