package ru.onyxone;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import ru.onyxone.config.HibernateConfig;
import ru.onyxone.dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        classes = {HibernateConfig.class},
        loader = AnnotationConfigContextLoader.class)
@Transactional
public class InMemoryDBTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void test() {
        System.out.println("111");

    }
}
