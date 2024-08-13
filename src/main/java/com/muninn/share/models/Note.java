package com.muninn.share.models;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;

@Container(containerName = "notes")
public class Note {
    @Id
    private String id;
    private String title;
    private String text;

    public Note() {
    }

    public Note(String id, String title, String text) {
        this.id = id;
        this.title = title;
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
