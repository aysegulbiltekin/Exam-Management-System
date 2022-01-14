package com.example.sinavyonetimsistemi.Services;

import com.example.sinavyonetimsistemi.Models.Notes;

import java.util.List;

public interface NotesService {
    public List<Notes> getAllNotes();
    public Notes getNoteById(int id);
    public void addNote(Notes note);
    public void deleteNote(int id);
    public Notes updateNote(Notes note, int id);
}
