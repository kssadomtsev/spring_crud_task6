package ru.onyxone.services;

import ru.onyxone.models.User;

import java.util.List;

public interface UserManager {
    public User get(int id);

    public List<User> getAll();

    public void update(User updatedUser);

    public void create(User user);

    public void delete(int id);
}
