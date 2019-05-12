package ru.apolyakov.server.entity;


import ru.apolyakov.security.entity.User;
import ru.apolyakov.shared.dto.AdvertDto;

import javax.persistence.*;

@Entity
@Table(name = "ADVERTS")
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)
    private User author;

    public Advert() {
    }

    public Advert(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Advert(AdvertDto source) {
        this.id = source.getId();
        this.title = source.getTitle();
        this.description = source.getDescription();
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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
