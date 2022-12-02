package com.example.esdproject;
import com.example.esdproject.util.hibernateSessionUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;


public class main {
    public static void main(String[] args) {
        Session one = hibernateSessionUtil.getSession();
    }
}
