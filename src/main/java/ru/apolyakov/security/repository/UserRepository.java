package ru.apolyakov.security.repository;

import org.springframework.data.repository.CrudRepository;
import ru.apolyakov.security.entity.User;

/**
 * CRUD репозиторий для работы с сущностью "Пользователь"
 *
 * @author apolyakov
 * @since 06.01.2019
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User getByLogin(String login);

    User getById(Long id);
}
