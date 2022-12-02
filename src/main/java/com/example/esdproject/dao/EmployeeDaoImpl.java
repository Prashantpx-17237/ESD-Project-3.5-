package com.example.esdproject.dao;

import com.example.esdproject.bean.Employees;
import com.example.esdproject.util.hibernateSessionUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class EmployeeDaoImpl implements EmployeeDao{
    @Override
    public Employees passwordVerify(Employees employees) {
        try(Session session = hibernateSessionUtil.getSession())
        {
            Query query = session.createQuery("from Employees where email =: email and password =: password");   // after colon variable
            query.setParameter("email", employees.getEmail());
            query.setParameter("password", employees.getPassword());

            for(final Object fetch: query.list())
            {
                return (Employees) fetch;
            }
            /*
            EntityManagerFactory entityManagerFactory = new EntityManagerFactory();
            TypedQuery<Employees> qry = EntityManager
            */
        } catch (HibernateException exception)
        {
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    @Override
    public void registerEmployee(Employees employees) {
        try(Session session = hibernateSessionUtil.getSession())
        {
            Transaction txn = session.beginTransaction();
            session.save(employees);
            txn.commit();
        }catch (HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
        }
    }

    @Override
    public Employees retrieveProfile(Integer emp_id) {
        try(Session session = hibernateSessionUtil.getSession())
        {
            Query query = session.createQuery("from Employees where emp_id =: emp_id");
            query.setParameter("emp_id", emp_id);
            for(final Object fetch: query.list()){
                return (Employees) fetch;
            }
        } catch(HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }

    @Override
    public int updateProfile(Employees employees) {
        try(Session session = hibernateSessionUtil.getSession()) {
            Transaction txn = session.beginTransaction();
            String qry = "update Employees set first_name =: first_name, last_name =: last_name, email =: email, password =: password, title =: title where emp_id =: emp_id";
            Query query = session.createQuery(qry);
            query.setParameter("emp_id", employees.getEmp_id());
            query.setParameter("first_name", employees.getFirst_name());
            query.setParameter("last_name", employees.getLast_name());
            query.setParameter("email", employees.getEmail());
            query.setParameter("password", employees.getPassword());
            query.setParameter("title", employees.getTitle());
            int result = query.executeUpdate();
            txn.commit();
            return result;
        }catch (HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
            return 0;
        }
    }

    @Override
    public int updateProfilePicPath(String name, Integer emp_id) {
        try(Session session = hibernateSessionUtil.getSession()) {
            Transaction txn = session.beginTransaction();
            String qry = "update Employees set photograph_path =: name where emp_id =: emp_id";
            Query query = session.createQuery(qry);
            query.setParameter("emp_id", emp_id);
            query.setParameter("name", name);
            int result = query.executeUpdate();
            txn.commit();;
            return result;
        }catch (HibernateException exception){
            System.out.println(exception.getLocalizedMessage());
            return 0;
        }
    }

    @Override
    public Employees getPhotoPath(Employees employees) {
        try(Session session = hibernateSessionUtil.getSession()){
            Query query = session.createQuery("from Employees where emp_id =: emp_id");
            query.setParameter("emp_id", employees.getEmp_id());
            for(final Object fetch : query.list()){
                return (Employees) fetch;
            }
        }catch (Exception exception){
            System.out.println(exception.getLocalizedMessage());
            return null;
        }
        return null;
    }
}
