package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LecturerRepository extends JpaRepository<Lecturer, String>{

}
