package ru.apolyakov.rest.controller;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.apolyakov.server.service.AdvertsService;
import ru.apolyakov.shared.dto.Advert;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class AdvertRestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    private final AdvertsService advertsService;

    @Autowired
    public AdvertRestController(AdvertsService advertsService)
    {
        this.advertsService = advertsService;
    }

    @RequestMapping("/greeting")
    public Advert greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Advert(counter.incrementAndGet());
    }

    @RequestMapping("/advert")
    public Collection<Advert> getAllAdverts(@RequestParam(value="start", defaultValue= "0") Long start,
                                            @RequestParam(value="size", defaultValue="20") Integer size)
    {
        advertsService.getAdverts(start, size).forEach();
        return result;
    }
}
