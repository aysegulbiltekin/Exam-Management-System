package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Departments;
import com.example.sinavyonetimsistemi.Repository.DepartmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DepartmentsServiceImp implements DepartmentsService {
    @Autowired
    DepartmentsRepository departmentsRepository;

    @Override
    public List<Departments> getAllDepartments() {
        return (List<Departments>) departmentsRepository.findAll();
    }

    @Override
    public Departments getDepartmentById(int id) {
        return departmentsRepository.findById(id).get();
    }

    @Override
    public void addDepartment(Departments departments) {
        departmentsRepository.save(departments);
    }

    @Override
    public void deleteDepartment(int id) {
        departmentsRepository.deleteById(id);
    }

    @Override
    public Departments updateDepartment(Departments departments, int id) {
        departmentsRepository.deleteById(id);
        Departments result = departmentsRepository.save(departments);

        return result;
    }
}
