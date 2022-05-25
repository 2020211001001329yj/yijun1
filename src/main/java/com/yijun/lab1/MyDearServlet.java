package com.yijun.lab1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyDearServlet", value = "/MyDearServlet")
public class MyDearServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        writer.println("<HTML>");
        writer.println("<head><title>Title</title></head>");
        writer.println("<body>");
        writer.println("<h1>User Info</h1>");
        writer.println("<table>");
        writer.println("<tr>"+"<td>"+"name:YiJun"+"</td>"+"</tr>");
        writer.println("<tr>"+"<td>"+"sumbit:Send data to server"+"</td>"+"</tr>");
        writer.println("<tr>"+"<td>"+"class:13"+"</td>"+"</tr>");
        writer.println("<tr>"+"<td>"+"id:2020211001001329"+"</td>"+"</tr>");
        writer.println("</table>");
        writer.println("</body>");
        writer.println("</HTML>");

    }
}
