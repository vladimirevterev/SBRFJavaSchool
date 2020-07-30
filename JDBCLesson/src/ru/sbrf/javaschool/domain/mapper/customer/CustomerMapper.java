package ru.sbrf.javaschool.domain.mapper.customer;

import ru.sbrf.javaschool.domain.dao.Mapper;
import ru.sbrf.javaschool.domain.entity.customer.Customer;
import ru.sbrf.javaschool.domain.entity.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerMapper implements Mapper<Customer> {

    @Override
    public List<Customer> map(ResultSet resultSet) throws SQLException {
        List<Customer> customers = new ArrayList<>();
        while(resultSet.next()) {
            customers.add(
                    new Customer(
                            resultSet.getLong("id"),
                            resultSet.getString("first_name"),
                            resultSet.getString("last_name"),
                            resultSet.getString("address")
                    )
            );
        }
        return customers;
    }

}
