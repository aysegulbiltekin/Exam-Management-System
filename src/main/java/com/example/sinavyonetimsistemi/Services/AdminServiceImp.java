package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Admins;
import com.example.sinavyonetimsistemi.Repository.AdminsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class AdminServiceImp implements AdminService {

    @Autowired
    AdminsRepository adminRepository;

    @Override
    public Admins getAdminById(int id) {
        return adminRepository.findById(id).get();
    }

    @Override
    public void addAdmin(Admins admin) {
        adminRepository.save(admin);
    }

    @Override
    public void deleteAll() {
        adminRepository.deleteAll();
    }

    @Override
    public Admins searchUsername(String username) {
        Admins user =  adminRepository.findByUsername(username);
        return user;
    }
}