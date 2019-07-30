package ru.apolyakov.server.service;

import ru.apolyakov.server.entity.Advert;

import java.util.List;
import java.util.Set;

/**
 * Сервис работы с объявлениями
 */
public interface IAdvertService {
    Set<Advert> getAdverts(long startPosition, int portion);

    /**
     * Найти все объявления заданного пользователя
     *
     * @param userId id пользователя
     * @return список объявлений
     */
    List<Advert> findAllUserAdverts(long userId);

    List<Advert> findAllUserAdverts(long userId, long startPosition, int portion);

    /**
     * Найти все объявления, хранящиеся в системе
     *
     * @return список объявлений
     */
    List<Advert> findAll();

    /**
     * Получить список объявлений по списку id
     *
     * @param ids список идентификаторов объявлений
     * @return список объявлений
     */
    Iterable<Advert> getAdvertsByIds(List<Long> ids);

    /**
     * Поиск объявлений по поисковому запросу по соответствию части названия или описания
     * @param searchQuery поисковый запрос
     * @param startPosition начальная позиция результирующей выборки
     * @param portion размер выборки из БД
     * @return набор объявлений, удовлетворяющих критериям поиска
     */
    List<Advert> search(String searchQuery, long startPosition, int portion);
}
