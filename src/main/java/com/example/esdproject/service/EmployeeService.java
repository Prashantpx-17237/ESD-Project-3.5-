package com.example.esdproject.service;

import com.example.esdproject.bean.Employees;
import com.example.esdproject.dao.EmployeeDao;
import com.example.esdproject.dao.EmployeeDaoImpl;

public class EmployeeService {
    EmployeeDao employeeDao = new EmployeeDaoImpl();

    public Employees verifyPassword(Employees employees)
    {
        return  employeeDao.passwordVerify(employees);
    }

    public Employees retrieveProfile(Integer emp_id)
    {
        return employeeDao.retrieveProfile(emp_id);
    }

    public int UpdateProfile(Employees employee)
    {
        return employeeDao.updateProfile(employee);
    }

    // need to be implemented
    //public int uploadProfilePic()

    public Employees getPhotoPath(Employees employee)
    {
        return employeeDao.getPhotoPath(employee);
    }

}
