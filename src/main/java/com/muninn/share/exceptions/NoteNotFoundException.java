package com.muninn.share.exceptions;

public class NoteNotFoundException extends RuntimeException {
    public NoteNotFoundException(String id) {
        super("Note with ID " + id + " not found");
    }
}
