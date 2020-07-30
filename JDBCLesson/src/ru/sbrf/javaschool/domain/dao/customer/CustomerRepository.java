package ru.sbrf.javaschool.domain.dao.customer;

import ru.sbrf.javaschool.domain.dao.AbstractRepository;
import ru.sbrf.javaschool.domain.dao.Mapper;
import ru.sbrf.javaschool.domain.entity.customer.Customer;

public class CustomerRepository extends AbstractRepository<Customer> {

    public CustomerRepository(String jdbcUrl, String user, String password, String driver, Mapper<Customer> mapper) {
        super(jdbcUrl, user, password, driver, mapper);
    }

}
