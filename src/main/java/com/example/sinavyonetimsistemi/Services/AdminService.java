package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Admins;

import java.util.List;

public interface AdminService {
    public Admins getAdminById(int id);

    public void addAdmin(Admins admin);

    public void deleteAll();

    public Admins searchUsername(String username);
}