package com.CovidHygiene.service.user;

import com.CovidHygiene.entity.Admin;
import com.CovidHygiene.service.IService;

import java.util.Set;

public interface AdminService extends IService <Admin, String> {

    Set<Admin> getAll();

}
