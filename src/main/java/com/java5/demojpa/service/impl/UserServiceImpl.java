package com.java5.demojpa.service.impl;

import com.java5.demojpa.entity.User;
import com.java5.demojpa.repository.UserRepository;
import com.java5.demojpa.service.UserSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserSevice {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getUserByRoleId(int roleId) {
        return userRepository.getUserByRoleId(roleId);
    }

}
