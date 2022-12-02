package com.example.esdproject.dao;
import com.example.esdproject.bean.Employees;
//import org.glassfish.jersey;
import java.io.InputStream;

public interface EmployeeDao {
    Employees passwordVerify(Employees employees);
    void registerEmployee(Employees employees);

    Employees retrieveProfile(Integer emp_id);

    int updateProfile(Employees employees);
    //int updateProfilePic(InputStream fileInputStream, FormDataContentDisposition fileMetaData);
    int updateProfilePicPath(String name, Integer emp_id);
    Employees getPhotoPath(Employees employees);
}
