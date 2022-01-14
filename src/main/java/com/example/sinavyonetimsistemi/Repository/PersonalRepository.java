package com.example.sinavyonetimsistemi.Repository;

import com.example.sinavyonetimsistemi.Models.Personals;
import com.example.sinavyonetimsistemi.Models.Students;
import org.springframework.data.repository.CrudRepository;

public interface PersonalRepository extends CrudRepository<Personals, Integer> {
    Personals findByUsername(String username);
}