package ru.apolyakov.rest.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.apolyakov.server.entity.Advert;
import ru.apolyakov.server.service.impl.AdvertService;
import ru.apolyakov.shared.Constants;
import ru.apolyakov.shared.dto.AdvertDto;
import ru.apolyakov.shared.transformer.AdvertConverter;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static ru.apolyakov.shared.Constants.Rest.*;

@RestController
@RequestMapping(value = REST_ENDPOINT + MOBILE_REST_ENDPOINT + REST_MOBILE_API_VERSION)
@CrossOrigin
public class AdvertRestController {
    private final AdvertService advertsService;

    @Autowired
    public AdvertRestController(AdvertService advertsService)
    {
        this.advertsService = advertsService;
    }

    @RequestMapping(value = "/adverts", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<AdvertDto> getAllAdverts(@RequestParam(value = "start", defaultValue = "0") Long start,
                                               @RequestParam(value = "size", defaultValue = "20") Integer size) {
        Set<AdvertDto> result = Sets.newHashSet();
        advertsService.getAdverts(start, size).forEach(it -> result.add(AdvertConverter.convert(it)));
        return result;
    }

    @RequestMapping(value = "/adverts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public List<AdvertDto> saveAdverts(@RequestBody(required = true) List<AdvertDto> advertDtos) {
        List<Advert> adverts = advertDtos.stream().map(AdvertConverter::convert).collect(Collectors.toList());
        return advertsService.saveAdverts(adverts).stream().map(AdvertConverter::convert).collect(Collectors.toList());
    }

    @RequestMapping(value = "/adverts/{userId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
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

    @RequestMapping(value = "/adverts/search/{searchText}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Collection<AdvertDto> searchAdvert(@PathVariable String searchText,
                             @RequestParam(value = "start", defaultValue = "0") Long start,
                             @RequestParam(value = "size", defaultValue = "20") Integer size)
    {
        Set<AdvertDto> result = Sets.newHashSet();
        advertsService.search(searchText, start, size).forEach(it -> result.add(AdvertConverter.convert(it)));
        return result;
    }
}
