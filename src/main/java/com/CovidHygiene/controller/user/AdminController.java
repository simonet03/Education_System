package com.CovidHygiene.controller.user;

import com.CovidHygiene.entity.Admin;
import com.CovidHygiene.factory.AdminFactory;
import com.CovidHygiene.service.user.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Set;

public class AdminController {
    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/create")
    public Admin create (@RequestBody Admin ad){
        Admin a = AdminFactory.buildAdmin(ad.getAdminNum(),ad.getFirstName(),ad.getLastName(),ad.getAddress());
        return adminService.create(a);
    }

    @GetMapping("/read/{id}")
    public Admin read(@PathVariable String id){
        return adminService.read(id);
    }

    @PostMapping("/update")
    public Admin update(@RequestBody Admin ad){
        return adminService.update(ad);
    }

    @GetMapping("/getAll")
    public Set<Admin> getAll(){
        return adminService.getAll();
    }

    @GetMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return adminService.delete(id);
    }



}
