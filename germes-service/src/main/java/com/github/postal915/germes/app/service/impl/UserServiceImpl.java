package com.github.postal915.germes.app.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Named;

import com.github.postal915.germes.app.infra.cdi.DBSource;
import com.github.postal915.germes.app.model.entity.person.User;
import com.github.postal915.germes.app.persistence.repository.UserRepository;
import com.github.postal915.germes.app.service.UserService;

/**
 * Default and managed(by CDI container) implementation of UserService
 */
@Named
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Inject
    public UserServiceImpl(@DBSource UserRepository userRepository) {
        this.userRepository = userRepository;

        User user = new User();
        user.setUserName("guest");
        user.setPassword("guest");
        userRepository.save(user);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> findById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    public void delete(int userId) {
        userRepository.delete(userId);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
