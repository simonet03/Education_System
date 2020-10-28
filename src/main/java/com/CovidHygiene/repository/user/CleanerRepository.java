package com.CovidHygiene.repository.user;

import com.CovidHygiene.entity.Cleaner;
import com.CovidHygiene.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

public interface CleanerRepository extends JpaRepository<Cleaner, Long>{

}
