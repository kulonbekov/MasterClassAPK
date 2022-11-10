package com.company.services.impl;

import com.company.services.CrudOperationServices;
import com.company.services.TaskServices;

import java.util.Scanner;

public class CrudOperationServicesImpl implements CrudOperationServices {

    Scanner sc = new Scanner(System.in);
    TaskServices taskServices = new TaskServicesImpl();
    @Override
    public void crudObjects() {

        while(true) {
            System.out.println("1. Показать список всех задач");
            System.out.println("2. Изменить статус задачи");
            System.out.println("3. Создать задачу");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Выйти");

            switch (sc.nextInt()){
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
