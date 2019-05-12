package ru.apolyakov.rest.controller;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.apolyakov.server.entity.Advert;
import ru.apolyakov.server.service.impl.AdvertService;
import ru.apolyakov.shared.dto.AdvertDto;
import ru.apolyakov.shared.transformer.AdvertConverter;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@RestController(value = "/api/web")
@CrossOrigin
public class AdvertRestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final AdvertService advertsService;

    @Autowired
    public AdvertRestController(AdvertService advertsService)
    {
        this.advertsService = advertsService;
    }

    @RequestMapping(value = "/adverts", method = RequestMethod.GET)
    public Collection<AdvertDto> getAllAdverts(@RequestParam(value = "start", defaultValue = "0") Long start,
                                               @RequestParam(value = "size", defaultValue = "20") Integer size) {
        Set<AdvertDto> result = Sets.newHashSet();
        advertsService.getAdverts(start, size).forEach(it -> result.add(AdvertConverter.convert(it)));
        return result;
    }

    @RequestMapping(value = "/adverts/{userId}", method = RequestMethod.GET)
    public Collection<AdvertDto> getAdvertsByAuthor(@PathVariable long userId,
                                                    @RequestParam(value = "start", defaultValue = "0") Long start,
                                                    @RequestParam(value = "size", defaultValue = "20") Integer size)
    {
        Set<AdvertDto> result = Sets.newHashSet();
        advertsService.getAdverts(start, size).forEach(it -> result.add(AdvertConverter.convert(it)));
        return result;
    }

    @RequestMapping(value = "/advert", method = RequestMethod.GET)
    public AdvertDto getAdvertById(@RequestParam(value = "id") long id) {
        Advert advert = advertsService.getAdvertById(id);
        return AdvertConverter.convert(advert);
    }

    @RequestMapping(value = "/advert", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public AdvertDto saveAdvert(@RequestBody(required = true) AdvertDto advertDto) {
        Advert advert = advertsService.saveOrUpdateAdvert(AdvertConverter.convert(advertDto));
        return AdvertConverter.convert(advert);
    }

    @RequestMapping(value = "/advert", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public AdvertDto updateAdvert(@RequestBody(required = true) AdvertDto advertDto) {
        Advert advert = advertsService.saveOrUpdateAdvert(AdvertConverter.convert(advertDto));
        return AdvertConverter.convert(advert);
    }

    @RequestMapping(value = "/advert", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAdvert(@RequestParam(value = "id") long id) {
        advertsService.deleteAdvert(id);
    }
}
