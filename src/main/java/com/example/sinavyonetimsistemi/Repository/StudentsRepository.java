package com.example.sinavyonetimsistemi.Repository;

import com.example.sinavyonetimsistemi.Models.Admins;
import com.example.sinavyonetimsistemi.Models.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Students, Integer> {
    Students findByUsername(String username);
}