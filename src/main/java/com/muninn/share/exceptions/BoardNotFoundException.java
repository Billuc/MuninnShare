package com.muninn.share.exceptions;

public class BoardNotFoundException extends RuntimeException {
    public BoardNotFoundException(String id) {
        super("Board with ID " + id + " not found");
    }
}
