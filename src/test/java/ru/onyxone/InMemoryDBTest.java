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
import ru.onyxone.models.Role;
import ru.onyxone.models.User;

import java.util.Set;

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
        User user = new User("Test", "Testov", "test@test.com", "12345");
        user.setRoles(Set.of(new Role("ADMIN")));

        userDao.create(user);

        User user1 = userDao.get(1).orElseGet(()
                -> new User("non-existing user", "", "",""));
        System.out.println(user1);

    }
}
