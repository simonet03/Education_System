package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Student;
import com.CovidHygiene.repository.IRepository;

import java.util.Set;

public interface StudentRepository extends IRepository <Student, String> {

    Set<Student> getAll();
}
