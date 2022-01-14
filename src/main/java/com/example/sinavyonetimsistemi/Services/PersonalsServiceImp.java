package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Personals;
import com.example.sinavyonetimsistemi.Models.Students;
import com.example.sinavyonetimsistemi.Repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PersonalsServiceImp implements PersonalsService {
    @Autowired
    PersonalRepository personalRepository;

    @Override
    public List<Personals> getAllPersonals() {
        return (List<Personals>) personalRepository.findAll();
    }

    @Override
    public Personals getPersonalById(int id) {
        return personalRepository.findById(id).get();
    }

    @Override
    public void addPersonal(Personals personal) {
        personalRepository.save(personal);
    }

    @Override
    public void deletePersonal(int id) {
        personalRepository.deleteById(id);
    }

    @Override
    public Personals updatePersonal(Personals personal, int id) {
        personalRepository.deleteById(id);
        Personals result = personalRepository.save(personal);

        return result;
    }

    @Override
    public Personals searchUsername(String username) {
        Personals user =  personalRepository.findByUsername(username);
        return user;
    }
}
