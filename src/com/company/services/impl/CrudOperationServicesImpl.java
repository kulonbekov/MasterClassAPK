package com.company.services.impl;

import com.company.services.CrudOperationServices;
import com.company.services.TaskServices;
import com.company.services.UserService;

import java.util.Scanner;

public class CrudOperationServicesImpl implements CrudOperationServices {

    Scanner sc = new Scanner(System.in);
    TaskServices taskServices = new TaskServicesImpl();
    UserService userService = new UserServiceImpl();
    @Override
    public void crudObjects() {


        System.out.println("Выберите операцию ");
        System.out.println("1. Пользователи");
        System.out.println("2. Задачи");
        int answer = sc.nextInt();

        if(answer == 1) {
            while (true){
                System.out.println("1. Показать список всех пользователей");
                System.out.println("2. Изменить личные данные пользователя");
                System.out.println("3. Добавить нового пользователя");
                System.out.println("4. Удалить пользователя");
                System.out.println("5. Выйти");

                switch (sc.nextInt()) {
                    case 1:
                        userService.outputList(userService.getUserList());
                        break;
                    case 2:

                        break;
                    case 3:
                        userService.createUser();
                        break;
                    case 4:

                        break;
                    case 5:
                        System.exit(0);
                    default:
                        System.err.println("Команда не разпознена");
                }
            }

        }else if(answer == 2) {

            while (true) {
                System.out.println("1. Показать список всех задач");
                System.out.println("2. Изменить статус задачи");
                System.out.println("3. Создать задачу");
                System.out.println("4. Удалить задачу");
                System.out.println("5. Выйти");

                switch (sc.nextInt()) {
                    case 1:
                        taskServices.outputList(taskServices.getTaskList());
                        break;
                    case 2:
                        System.out.println("Введите идентификатор задачи");
                        taskServices.updateTask(sc.nextLong());
                        break;
                    case 3:
                        taskServices.createTask();
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
}
