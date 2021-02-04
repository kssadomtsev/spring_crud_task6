package ru.onyxone.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.onyxone.exception.JpaException;
import ru.onyxone.models.Role;
import ru.onyxone.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public UserDaoImpl() {
    }

    @Override
    public Optional<User> get(int id) {
        return entityManager
                .createQuery("SELECT u FROM User u WHERE u.id =:id", User.class)
                .setParameter("id", id)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst();
    }

    @Override
    public List<User> getAll() {
        return entityManager
                .createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    @Override
    public void update(User updatedUser) {
        entityManager.merge(updatedUser);
    }

    @Override
    public void create(User user) {
        entityManager.persist(user);

    }

    @Override
    public void delete(int id) {
        User details = get(id).orElseThrow(() -> new JpaException("User not found!"));
        entityManager.remove(details);
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return entityManager
                .createQuery("SELECT u FROM User u WHERE u.email =:email", User.class)
                .setParameter("email", email)
                .setMaxResults(1)
                .getResultList()
                .stream()
                .findFirst();
    }
}
