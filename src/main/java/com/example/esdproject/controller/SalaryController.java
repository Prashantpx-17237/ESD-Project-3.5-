package com.example.esdproject.controller;

import com.example.esdproject.bean.Employee_Salary;
import com.example.esdproject.service.EmployeeSalaryService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.json.JsonObject;

import javax.swing.text.html.StyleSheet;
import java.net.URISyntaxException;
import java.util.List;

@Path("salary")
public class SalaryController {
    EmployeeSalaryService employeeSalaryService = new EmployeeSalaryService();

    @POST
    @Path("/fetch_salary")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response fetchSalary(JsonObject jsonObject) throws URISyntaxException{
        System.out.println(jsonObject.get("employee").toString());
        System.out.println("fetch "+jsonObject.get("employee"));
        List<Employee_Salary> result = employeeSalaryService.retrieveSalary(jsonObject.get("employee").toString());//,
                //jsonObject.get("payment_date").toString());

        if(result == null)
        {
            return  Response.noContent().build();
        }

        Response response = Response.ok().entity(result).build();
        return  response;
    }

    @POST
    @Path("/view_salary")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Response fetchSalaryMonth(JsonObject jsonObject) throws URISyntaxException{
        Employee_Salary result = employeeSalaryService.retrieveSalary(jsonObject.get("employee").toString(),
        jsonObject.get("payment_date").toString());

        if(result == null)
        {
            return  Response.noContent().build();
        }

        Response response = Response.ok().entity(result).type(MediaType.APPLICATION_JSON).build();
        return  response;
    }
}
