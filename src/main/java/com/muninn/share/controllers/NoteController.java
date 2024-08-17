package com.muninn.share.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.muninn.share.models.Note;
import com.muninn.share.repositories.NoteRepository;
import com.muninn.share.exceptions.NoteNotFoundException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class NoteController {
    private final NoteRepository noteRepository;

    NoteController(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping("/notes/{id}")
    public Note GetNote(@PathVariable(name = "id") String id) {
        Optional<Note> note = noteRepository.findById(id);
        return note.orElseThrow(() -> new NoteNotFoundException(id));
    }

    @PostMapping("/notes")
    public Note CreateNote(@RequestBody Note entity) {
        return noteRepository.save(entity);
    }

    @PostMapping("/notes/{id}")
    public Note UpdateNote(@PathVariable(name = "id") String id, @RequestBody Note update) {
        return noteRepository.save(new Note(id, update.getTitle(), update.getText()));
    }

    @DeleteMapping("/notes/{id}")
    public void DeleteNote(@PathVariable(name = "id") String id) {
        noteRepository.deleteById(id);
    }
}
