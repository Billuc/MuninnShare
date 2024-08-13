package com.muninn.share.models;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;

@Container(containerName = "lists")
public class List {
    @Id
    private String id;
    private String title;
    private boolean hideChecked;

    public List() {
    }

    public List(String id, String title, boolean hideChecked) {
        this.id = id;
        this.title = title;
        this.hideChecked = hideChecked;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getHideChecked() {
        return hideChecked;
    }
}
