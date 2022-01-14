package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Exams;

import java.util.List;

public interface ExamsService {
    public List<Exams> getAllExams();
    public Exams getExamById(int id);
    public void addExam(Exams exam);
    public void deleteExam(int id);
    public Exams updateExam(Exams exam, int id);
}
