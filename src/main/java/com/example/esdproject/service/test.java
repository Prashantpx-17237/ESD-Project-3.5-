package com.example.esdproject.service;

import com.example.esdproject.bean.Employees;
import com.example.esdproject.dao.EmployeeDaoImpl;
import com.example.esdproject.util.hibernateSessionUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class test {
    public static void main(String[] args) {
        Employees employees = new Employees();
        employees.setEmail("pallav.jain@iiitb.ac.in");
        employees.setFirst_name("Pallav");
        employees.setLast_name("Jain");
        employees.setEmp_id(067);
        employees.setPhotograph_path("Abhi ni bna hai");
        employees.setPassword("password");

        com.example.esdproject.dao.EmployeeDaoImpl Obj = new EmployeeDaoImpl();
        Obj.registerEmployee(employees);
    }
}
