package com.example.esdproject.util;

import com.example.esdproject.bean.Employees;
import com.example.esdproject.dao.EmployeeDao;
import com.example.esdproject.dao.EmployeeDaoImpl;

public class InitDB {

    public static void main(String[] args) {
        Employees employees = new Employees("Sahil", "Verma", "sahilverma@gmail.com", "12345", "Professor", null);
        EmployeeDao employeeDao = new EmployeeDaoImpl();

        employeeDao.registerEmployee(employees);

    }
}