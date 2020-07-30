package ru.sbrf.javaschool.domain.dao;

import java.util.List;

public interface Repository<E> {

    List<E> findAll();

    E findById(Integer id);

    boolean update(E entity);

    boolean create(E entity);

    boolean delete(Integer id);

}
