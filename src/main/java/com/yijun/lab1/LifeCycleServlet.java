package com.yijun.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "LifeCycleServlet", value = "/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {

    private int count;

    public LifeCycleServlet() {
        System.out.println("I am from default constructor");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("init");
        count = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("service");
        count++;
        PrintWriter writer = response.getWriter();
        writer.println("Since loading , this servlet has bean access " +count+ " times");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        System.out.println("destory");
    }
}
