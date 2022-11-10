package com.company.services;

import com.company.models.Task;

import java.util.List;

public interface TaskServices {
    List<Task> getTaskList();

    void updateTask(long id);

    void createTask();

    void deleteTask(long id );

    void outputList(List<Task> task);

    String answerState();

}
