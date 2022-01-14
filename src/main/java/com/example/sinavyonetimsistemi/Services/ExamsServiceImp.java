package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Exams;
import com.example.sinavyonetimsistemi.Repository.ExamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ExamsServiceImp implements ExamsService {
    @Autowired
    ExamsRepository examsRepository;

    @Override
    public List<Exams> getAllExams() {
        return (List<Exams>) examsRepository.findAll();
    }

    @Override
    public Exams getExamById(int id) {
        return examsRepository.findById(id).get();
    }

    @Override
    public void addExam(Exams exams) {
        examsRepository.save(exams);
    }

    @Override
    public void deleteExam(int id) {
        examsRepository.deleteById(id);
    }

    @Override
    public Exams updateExam(Exams exams, int id) {
        examsRepository.deleteById(id);
        Exams examResult = examsRepository.save(exams);

        return examResult;
    }
}
