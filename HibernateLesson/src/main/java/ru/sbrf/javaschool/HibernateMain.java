package ru.sbrf.javaschool;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sbrf.javaschool.configuration.PersistanceConfig;
import ru.sbrf.javaschool.persistence.dao.UserinfoDao;
import ru.sbrf.javaschool.persistence.model.Userinfo;

public class HibernateMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(PersistanceConfig.class);
        UserinfoDao userinfoDao = applicationContext.getBean(UserinfoDao.class);
        Userinfo userinfo = userinfoDao.getUserinfoById(2L);
        System.out.println(userinfo);
    }

}
