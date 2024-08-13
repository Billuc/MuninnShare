package com.muninn.share.models;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;

@Container(containerName = "boards")
public class Board {
    @Id
    private String id;
    private String title;
    private Card[] cards;

    public Board() {
    }

    public Board(String id, String title, Card[] cards) {
        this.id = id;
        this.title = title;
        this.cards = cards;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Card[] getCards() {
        return cards;
    }
}
