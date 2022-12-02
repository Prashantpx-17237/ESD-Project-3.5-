package com.example.esdproject.controller;

import com.example.esdproject.bean.Employees;
import com.example.esdproject.service.EmployeeService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.awt.*;
import java.net.URISyntaxException;

@Path("/employee")
public class EmployeeController {
    EmployeeService employeeService = new EmployeeService();
//    @GET
//    @Path("/login")
//    public String func(){
//        return "testSuccess";
//    }

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public Response loginEmployee(Employees employee)
        throws URISyntaxException{
        System.out.print(employee.getEmail());
        System.out.println(employee.getTitle());
        Employees result = employeeService.verifyPassword(employee);
        if(result == null)
        {
            return Response.noContent().build();
        }
        System.out.println(result.getTitle());
        return Response.ok().entity(result).build();
    }
}
