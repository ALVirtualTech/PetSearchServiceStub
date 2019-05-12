package ru.apolyakov.shared.dto;

import java.util.HashSet;
import java.util.Set;

public class UserDto {
    private final long id;
    private final Set<AdvertDto> createdAdverts = new HashSet<>();
    private final Set<AdvertDto> favouriteAdverts = new HashSet<>();

    private String login;
    private String email;
    private String location;
    private String description;

    public UserDto(long id) {
        this.id = id;
    }

    public UserDto(long id, String login, String email, String location, String description) {
        this.id = id;
        this.login = login;
        this.email = email;
        this.location = location;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public Set<AdvertDto> getCreatedAdverts() {
        return createdAdverts;
    }

    public Set<AdvertDto> getFavouriteAdverts() {
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
