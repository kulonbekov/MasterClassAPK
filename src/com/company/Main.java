package com.company;

import com.company.services.AddTaskOperationServices;
import com.company.services.CrudOperationServices;
import com.company.services.impl.AddTaskOperationServicesImpl;
import com.company.services.impl.CrudOperationServicesImpl;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CrudOperationServices crudOperationServices = new CrudOperationServicesImpl();
        AddTaskOperationServices addTaskOperationServices = new AddTaskOperationServicesImpl();

        System.out.println("1. Перейти в управление справочником");
        System.out.println("2. Перейти в управление с задачами");
        switch (sc.nextInt()){
            case 1:
                crudOperationServices.crudObjects();
                break;
            case 2:
                addTaskOperationServices.userLogin();
        }


    }
}