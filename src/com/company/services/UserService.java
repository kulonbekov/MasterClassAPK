package com.company.services;

import com.company.models.Task;
import com.company.models.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    void updateUser(long id);

    void createUser();

    List<User> userVerification();

    void outputList(List<User> user);
}
