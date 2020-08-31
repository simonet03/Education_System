package com.CovidHygiene.repository.user.impl;

import com.CovidHygiene.entity.Admin;
import com.CovidHygiene.repository.user.AdminRepository;

import java.util.HashSet;
import java.util.Set;

public class AdminRepositoryImp implements AdminRepository {

    private static AdminRepository repository = null;
    private Set<Admin> adminDB;

    private AdminRepositoryImp() {
        this.adminDB = new HashSet<>();
    }

    public static AdminRepository getRepository() {
        if (repository == null) repository = new AdminRepositoryImp();
        return repository;

    }

    @Override
    public Admin create(Admin admin) {
        this.adminDB.add(admin);
        return admin;
    }

    @Override
    public Admin read(String sAdmin) {
        for (Admin admin : this.adminDB){
            if (admin.getAdminNum() == sAdmin)
                return admin;
    }
            return null;
}

     @Override
     public Admin update(Admin admin) {
        boolean deleteAdmin = delete(admin.getAdminNum());
        if(deleteAdmin) {
            this.adminDB.add(admin);
            return admin;
        }
                return null;
            }

     @Override
     public boolean delete(String sAdmin) {
        Admin admin = read(sAdmin);
        if (admin != null) {
            this.adminDB.remove(admin);
            return true;
        }
                return false;
            }

      @Override
      public Set<Admin> getAll() {
          return this.adminDB;
      }


}


