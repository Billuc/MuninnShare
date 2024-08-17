package com.muninn.share.models;

import java.util.Optional;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.PartitionKey;

@Container(containerName = "list-elements")
public class ListElement {
    @Id
    private String id;
    private String title;
    private boolean done;
    private int index;
    private String parentId;
    @PartitionKey
    private String listId;

    public ListElement() {
    }

    public ListElement(String id, String title, boolean done, int index, String parentId, String listId) {
        this.id = id;
        this.title = title;
        this.done = done;
        this.index = index;
        this.parentId = parentId;
        this.listId = listId;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean getDone() {
        return done;
    }

    public int getIndex() {
        return index;
    }

    public String getParentId() {
        return parentId;
    }

    public String getListId() {
        return listId;
    }

    public record Update(String id, Optional<String> title, Optional<Boolean> done) {
    }
}
