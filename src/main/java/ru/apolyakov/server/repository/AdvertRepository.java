package ru.apolyakov.server.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.apolyakov.server.entity.Advert;

import java.util.List;

public interface AdvertRepository extends CrudRepository<Advert, Long> {
    List<Advert> getAll(Pageable pageable);

    List<Advert>  getAdvertById(long id);
}
