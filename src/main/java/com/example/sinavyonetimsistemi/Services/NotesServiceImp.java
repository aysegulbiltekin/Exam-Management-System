package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Notes;
import com.example.sinavyonetimsistemi.Repository.NotesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NotesServiceImp implements NotesService {
    @Autowired
    NotesRepository notesRepository;

    @Override
    public List<Notes> getAllNotes() {
        return (List<Notes>) notesRepository.findAll();
    }

    @Override
    public Notes getNoteById(int id) {
        return notesRepository.findById(id).get();
    }

    @Override
    public void addNote(Notes notes) {
        notesRepository.save(notes);
    }

    @Override
    public void deleteNote(int id) {
        notesRepository.deleteById(id);
    }

    @Override
    public Notes updateNote(Notes notes, int id) {
        notesRepository.deleteById(id);
        Notes result = notesRepository.save(notes);

        return result;
    }
}
