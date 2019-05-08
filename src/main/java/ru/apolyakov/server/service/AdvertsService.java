package ru.apolyakov.server.service;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import ru.apolyakov.server.entity.Advert;
import ru.apolyakov.server.repository.AdvertRepository;


import java.util.Set;

@Component
public class AdvertsService {
    private AdvertRepository advertRepository;

    @Autowired
    public AdvertsService(AdvertRepository advertRepository) {
        this.advertRepository = advertRepository;
    }

    public Set<Advert> getAdverts(long startPosition, int portion)
    {
        int page = (int) startPosition / portion;
        Set<Advert> result = Sets.newHashSet();
        result = Sets.newHashSet(advertRepository.getAll(PageRequest.of(page, portion)));
        return result;
    }
}
