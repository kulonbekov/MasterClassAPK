package com.company.services;

import com.company.models.Task;
import com.company.models.User;

import java.util.List;

public interface AddTaskServices {

    List<Task> getTaskList(List<User> user);
    List<User> getCreateUser();

    void getCreateTask(List<User> user);

}
