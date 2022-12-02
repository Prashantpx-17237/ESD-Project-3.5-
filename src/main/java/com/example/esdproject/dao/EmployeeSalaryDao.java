package com.example.esdproject.dao;

import com.example.esdproject.bean.Employee_Salary;

import java.util.List;

public interface EmployeeSalaryDao {
    Employee_Salary retrieveSalary(Integer emp_id, String payment_date);
    List<Employee_Salary> retrieveSalary(Integer emp_id);
}
