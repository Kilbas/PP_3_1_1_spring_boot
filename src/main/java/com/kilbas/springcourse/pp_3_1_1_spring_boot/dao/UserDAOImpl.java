package com.kilbas.springcourse.pp_3_1_1_spring_boot.dao;

import com.kilbas.springcourse.pp_3_1_1_spring_boot.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void removeUserById(Long userId) {
        entityManager.createQuery("delete User where id = :userId")
                .setParameter("userId", userId)
                .executeUpdate();
    }

    @Override
    public User getUserById(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

}
