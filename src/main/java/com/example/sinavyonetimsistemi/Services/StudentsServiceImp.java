package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Admins;
import com.example.sinavyonetimsistemi.Models.Students;
import com.example.sinavyonetimsistemi.Repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StudentsServiceImp implements StudentsService{
    @Autowired
    StudentsRepository studentsRepository;

    @Override
    public List<Students> getAllStudents() {
        return (List<Students>) studentsRepository.findAll();
    }

    @Override
    public Students getStudentById(int id) {
        return studentsRepository.findById(id).get();
    }

    @Override
    public void addStudent(Students student) {
        studentsRepository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        studentsRepository.deleteById(id);
    }

    @Override
    public Students updateStudent(Students student, int id) {
        studentsRepository.deleteById(id);
        Students result = studentsRepository.save(student);

        return result;
    }

    @Override
    public Students searchUsername(String username) {
        Students user =  studentsRepository.findByUsername(username);
        return user;
    }
}
