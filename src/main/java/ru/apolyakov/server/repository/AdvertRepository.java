package ru.apolyakov.server.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.apolyakov.security.entity.User;
import ru.apolyakov.server.entity.Advert;

import java.util.List;

public interface AdvertRepository extends CrudRepository<Advert, Long> {
    Page<Advert> findAll(Pageable pageable);

    Advert getAdvertById(long id);

    List<Advert> getAdvertByAuthor(User author);

    Page<Advert> getAdvertByAuthor(User author, Pageable pageable);

    List<Advert> getTopByAuthor(User author);

    Page<Advert> findAdvertsByTitleContainsIgnoreCaseOrDescriptionContainsIgnoreCase(String title, String description, Pageable pageable);
}
