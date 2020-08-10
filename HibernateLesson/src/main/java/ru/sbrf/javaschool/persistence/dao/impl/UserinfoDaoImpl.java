package ru.sbrf.javaschool.persistence.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.sbrf.javaschool.persistence.dao.UserinfoDao;
import ru.sbrf.javaschool.persistence.model.Userinfo;

@Repository
@Transactional
public class UserinfoDaoImpl implements UserinfoDao {

    private SessionFactory sessionFactory;

    @Autowired
    public UserinfoDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Userinfo getUserinfoById(Long id) {
        return (Userinfo) sessionFactory.getCurrentSession().get(Userinfo.class, id);
    }

}
