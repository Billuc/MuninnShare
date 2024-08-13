package com.muninn.share.exceptions;

public class ListNotFoundException extends RuntimeException {
    public ListNotFoundException(String id) {
        super("List with ID " + id + " not found");
    }
}
