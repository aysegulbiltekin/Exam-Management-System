package com.example.sinavyonetimsistemi.Repository;

import com.example.sinavyonetimsistemi.Models.Admins;
import org.springframework.data.repository.CrudRepository;

public interface AdminsRepository extends CrudRepository<Admins, Integer> {
    Admins findByUsername(String username);
}