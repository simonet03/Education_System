package com.CovidHygiene.service.impl;

import com.CovidHygiene.entity.Admin;
import com.CovidHygiene.repository.user.AdminRepository;
import com.CovidHygiene.repository.user.impl.AdminRepositoryImp;
import com.CovidHygiene.service.user.AdminService;

import java.util.Set;

public class AdminServiceImpl implements AdminService {

    private static AdminService service = null;
    private AdminRepository repository;

    private AdminServiceImpl() {
        this.repository = AdminRepositoryImp.getRepository();
    }

    public static AdminService getService() {
        if (service == null) service = new AdminServiceImpl();
        return service;
    }
    @Override
    public Set<Admin> getAll() {
                return this.repository.getAll();
            }

    @Override
    public Admin create(Admin admin) {
                return this.repository.create(admin);
            }

    @Override
     public Admin read(String a) {
                return this.repository.read(a);
            }

     @Override
     public Admin update(Admin admin) {
                return this.repository.update(admin);
            }

     @Override
     public boolean delete(String a) {
                return this.repository.delete(a);
            }
        }



