package ru.apolyakov.shared.transformer;

import ru.apolyakov.server.entity.Advert;

public class AdvertConverter {
    public static Advert convert (ru.apolyakov.shared.dto.Advert source)
    {
        return new Advert(source);
    }
}
