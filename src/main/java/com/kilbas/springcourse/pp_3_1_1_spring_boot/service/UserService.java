package com.kilbas.springcourse.pp_3_1_1_spring_boot.service;


import com.kilbas.springcourse.pp_3_1_1_spring_boot.entity.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> getAllUsers();

    void removeUserById(Long userId);

    User getUserById(Long userId);

    void updateUser(User user);
}