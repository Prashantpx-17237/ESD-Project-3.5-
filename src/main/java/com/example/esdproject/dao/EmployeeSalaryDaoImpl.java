package com.example.esdproject.dao;
import com.example.esdproject.bean.Employee_Salary;
import com.example.esdproject.util.hibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;


public class EmployeeSalaryDaoImpl implements EmployeeSalaryDao{
    @Override
    public Employee_Salary retrieveSalary(Integer emp_id, String payment_date){
        try(Session session = hibernateSessionUtil.getSession()) {
            Query query = session.createQuery("from Employee_Salary where employees.emp_id =: emp_id and payment_date like : month");
            query.setParameter("emp_id", emp_id);
            query.setParameter("month", payment_date);

            try
            {
                for(final Object fetch: query.list())
                {
                    Employee_Salary emp = (Employee_Salary) fetch;
                    return (Employee_Salary) fetch;
                }
            }catch (Exception exception)
            {
                System.out.println(exception);
            }
        }catch (HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    @Override
    public List<Employee_Salary> retrieveSalary(Integer emp_id){
        List<Employee_Salary> employSalaries = new ArrayList<>();
        try(Session session = hibernateSessionUtil.getSession()) {
            Query query = session.createQuery("from Employee_Salary where employees.emp_id =: emp_id");
            query.setParameter("emp_id", emp_id);

            for(final Object fetch: query.list()) {
                Employee_Salary emp = (Employee_Salary) fetch;
                employSalaries.add((Employee_Salary)fetch);
            }
        } catch (HibernateException exception){
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
        catch (Exception exception) {
            System.out.println(exception);
        }
        return employSalaries;
    }
}
