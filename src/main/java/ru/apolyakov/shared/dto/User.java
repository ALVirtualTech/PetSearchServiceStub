package ru.apolyakov.shared.dto;

import java.util.HashSet;
import java.util.Set;

public class User {
    private final long id;
    private final Set<Advert> createdAdverts = new HashSet<>();
    private final Set<Advert> favouriteAdverts = new HashSet<>();

    private String login;
    private String email;
    private String location;
    private String description;

    public User(long id) {
        this.id = id;
    }

    public User(long id, String login, String email, String location, String description) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.location = location;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public Set<Advert> getCreatedAdverts() {
        return createdAdverts;
    }

    public Set<Advert> getFavouriteAdverts() {
        return favouriteAdverts;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
