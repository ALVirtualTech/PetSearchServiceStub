package ru.apolyakov.shared.dto;

import java.io.Serializable;

public class Advert implements Serializable {
    private final long id;

    private String title;
    private String description;

    public Advert(long id) {
        this.id = id;
    }

    public Advert(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
