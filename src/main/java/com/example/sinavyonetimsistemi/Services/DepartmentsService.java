package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Departments;
import java.util.List;

public interface DepartmentsService {
    public List<Departments> getAllDepartments();
    public Departments getDepartmentById(int id);
    public void addDepartment(Departments classes);
    public void deleteDepartment(int id);
    public Departments updateDepartment(Departments classes, int id);
}
