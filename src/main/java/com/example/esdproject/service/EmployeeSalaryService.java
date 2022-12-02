package com.example.esdproject.service;

import com.example.esdproject.bean.Employee_Salary;
import com.example.esdproject.dao.EmployeeSalaryDao;
import com.example.esdproject.dao.EmployeeSalaryDaoImpl;

import java.util.List;

public class EmployeeSalaryService {
    EmployeeSalaryDao employeeSalaryDao = new EmployeeSalaryDaoImpl();

    //public Employee_Salary retrieveSalary(String emp_id, String payment_date)
    public List<Employee_Salary> retrieveSalary(String emp_id) {
        Employee_Salary result;
        try{
            return employeeSalaryDao.retrieveSalary(Integer.parseInt(emp_id));//, payDate);
        } catch(Exception exception) {
            System.out.println(exception);
            return null;
        }
    }
    public Employee_Salary retrieveSalary(String emp_id, String payment_date)
    {
        String payDate = payment_date.substring(1, payment_date.length() - 1);
        Employee_Salary result;
        try{
            result = employeeSalaryDao.retrieveSalary(Integer.parseInt(emp_id), payDate);
        }catch(Exception exception)
        {
            System.out.println(exception);
            return null;
        }
        return result;
    }
}
