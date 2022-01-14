package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Admins;
import com.example.sinavyonetimsistemi.Models.Students;

import java.util.List;

public interface StudentsService {
    public List<Students> getAllStudents();
    public Students getStudentById(int id);
    public void addStudent(Students student);
    public void deleteStudent(int id);
    public Students updateStudent(Students student, int id);
    public Students searchUsername(String username);
}
