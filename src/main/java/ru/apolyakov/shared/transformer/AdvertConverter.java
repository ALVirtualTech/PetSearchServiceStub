package ru.apolyakov.shared.transformer;

import ru.apolyakov.server.entity.Advert;
import ru.apolyakov.shared.dto.AdvertDto;

public class AdvertConverter {
    public static Advert convert(AdvertDto source)
    {
        return source == null ? null : new Advert(source);
    }

    public static AdvertDto convert(Advert source) {
        return source == null ? null : new AdvertDto(source);
    }
}
