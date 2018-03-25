package com.github.postal915.germes.app.persistence.repository;

import com.github.postal915.germes.app.model.entity.person.User;

import java.util.List;
import java.util.Optional;

/**
 * Defines CRUD methods to access User objects in the persistent storage
 */
public interface UserRepository {
    /**
     * Saves(creates or modifies) specified user instance
     */
    void save(User user);

    /**
     * Returns user with specified identifier boxed into Optional
     *
     * @param userId
     * @return
     */
    Optional<User> findById(int userId);

    /**
     * Returns user with specified username
     *
     * @param userName
     * @return
     */
    Optional<User> findByUserName(String userName);

    /**
     * Delete city with specified identifier
     *
     * @param userId
     */
    void delete(int userId);

    /**
     * Returns all the cities
     *
     * @return
     */
    List<User> findAll();

}
