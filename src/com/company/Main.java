package com.company;

import com.company.services.CrudOperationServices;
import com.company.services.impl.CrudOperationServicesImpl;



public class Main {
    public static void main(String[] args) {

        CrudOperationServices crudOperationServices = new CrudOperationServicesImpl();
        crudOperationServices.crudObjects();

    }
}