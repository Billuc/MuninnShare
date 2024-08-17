package com.muninn.share.exceptions;

public class ListElementNotFoundException extends RuntimeException {
    public ListElementNotFoundException(String id) {
        super("List element with ID " + id + " not found");
    }
}
