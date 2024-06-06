package com.java5.demojpa.service;

import com.java5.demojpa.entity.User;
import java.util.List;

public interface UserSevice {
    List<User> getAllUser();
    User saveUser(User user);
    List<User> getUserByRoleId(int roleId);
}
