package com.company.services.impl;

import com.company.models.User;
import com.company.services.AddTaskServices;
import com.company.services.TaskServices;
import com.company.services.UserService;
import com.company.services.AddTaskOperationServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddTaskOperationServicesImpl implements AddTaskOperationServices {
    Scanner sc = new Scanner(System.in);

    TaskServices taskServices = new TaskServicesImpl();
    UserService userService = new UserServiceImpl();

    AddTaskServices addTaskServices = new AddTaskServicesImpl();
    @Override
    public void userLogin() {

        while(true){
            System.out.println("Выберите операцию ");
            System.out.println("1. Вход");
            System.out.println("2. Регистрация");
            System.out.println("3. Выйти");
            int answer = sc.nextInt();

            if(answer == 1){
                    System.out.println("Введите логин пользователя");
                    String login = sc.next();
                    System.out.println("Введите пароль ");
                    String password = sc.next();

                    List<User> list1 = new ArrayList<>();
                    List<User> list = userService.getUserList();

                    for (int i = 0; i < list.size(); i++) {
                        if(list.get(i).getLogin().equals(login) && list.get(i).getPassword().equals(password)){
                            list1.add(list.get(i));
                            addTask(list1);

                        }
                    }
                System.out.println("Такого пользователя в базе нет");

                } else if(answer == 2){
                    addTask(addTaskServices.getCreateUser());
                }else if(answer == 3){
                System.exit(0);
            }

        }
    }

    @Override
    public void addTask(List<User> user) {
        while(true){
            System.out.println("1. Показать список всех задач");
            System.out.println("2. Изменить статус задачи");
            System.out.println("3. Создать задачу");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Выйти");

            switch (sc.nextInt()) {
                case 1:
                    taskServices.outputList(addTaskServices.getTaskList(user));
                    break;
                case 2:
                    System.out.println("Введите идентификатор задачи");
                    taskServices.updateTask(sc.nextLong());
                    break;
                case 3:
                    addTaskServices.getCreateTask(user);
                    break;
                case 4:
                    System.out.println("Введите идентификатор задачи для удаления");
                    taskServices.deleteTask(sc.nextLong());
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.err.println("Команда не разпознена");
            }

        }
    }
}
