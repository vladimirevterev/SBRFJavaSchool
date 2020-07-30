package ru.sbrf.javaschool.domain.dao.user;

import ru.sbrf.javaschool.domain.dao.AbstractRepository;
import ru.sbrf.javaschool.domain.dao.Mapper;
import ru.sbrf.javaschool.domain.entity.user.User;

public class UserRepository extends AbstractRepository<User> {

    public UserRepository(String jdbcUrl, String user, String password, String driver, Mapper<User> mapper) {
        super(jdbcUrl, user, password, driver, mapper);
    }
}
