package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Personals;
import com.example.sinavyonetimsistemi.Models.Students;

import java.util.List;

public interface PersonalsService {
    public List<Personals> getAllPersonals();
    public Personals getPersonalById(int id);
    public void addPersonal(Personals personal);
    public void deletePersonal(int id);
    public Personals updatePersonal(Personals personal, int id);
    public Personals searchUsername(String username);
}
