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
    @Column(columnDefinition = "TEXT")
    private String description;
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = true)
    private User author;

    @Column(columnDefinition = "TEXT")
    @Lob
    private String image;
    private String breed;
    private boolean vaccinations;
    private float height;
    private float weight;
    private String coatColor;

    public Advert() {
    }

    public Advert(String title, String description, User author, String image, String breed, boolean vaccinations, float height, float weight, String coatColor) {
        this.title = title;
        this.description = description;
        this.author = author;
        this.image = image;
        this.breed = breed;
        this.vaccinations = vaccinations;
        this.height = height;
        this.weight = weight;
        this.coatColor = coatColor;
    }

    public Advert(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Advert(AdvertDto source) {
        this.title = source.getTitle();
        this.description = source.getDescription();
        this.image = source.getImage();
        this.breed = source.getBreed();
        this.vaccinations = source.isVaccinations();
        this.height = source.getHeight();
        this.weight = source.getWeight();
        this.coatColor = source.getCoatColor();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public boolean isVaccinations() {
        return vaccinations;
    }

    public void setVaccinations(boolean vaccinations) {
        this.vaccinations = vaccinations;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getCoatColor() {
        return coatColor;
    }

    public void setCoatColor(String coatColor) {
        this.coatColor = coatColor;
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
