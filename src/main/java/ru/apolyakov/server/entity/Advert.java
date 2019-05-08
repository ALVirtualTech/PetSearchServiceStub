package ru.apolyakov.server.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Advert {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String title;
    private String description;

    public Advert() {
    }

    public Advert(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Advert(ru.apolyakov.shared.dto.Advert source) {
        this.id = source.getId();
        this.title = source.getTitle();
        this.description = source.getDescription();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
