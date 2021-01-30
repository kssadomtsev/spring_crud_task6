package ru.onyxone.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.onyxone.dao.UserDao;
import ru.onyxone.models.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserManagerImpl implements UserManager {

    private UserDao userDao;

    @Autowired
    public UserManagerImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public User get(int id) {
        Optional<User> user = userDao.get(id);
        return user.orElseGet(()
                -> new User("non-existing user", "", "",""));
    }

    @Transactional
    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional
    @Override
    public void update(User updatedUser) {
        userDao.update(updatedUser);
    }

    @Transactional
    @Override
    public void create(User user) {
        userDao.create(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDao.delete(id);
    }
}
