package com.yijun.week4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/config",initParams = {
        @WebInitParam(name = "myname",value = "YiJun"),
        @WebInitParam(name = "studentId",value = "2020211001001329")
})
public class ConfigDemoServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                String myname = this.getServletConfig().getInitParameter("myname");
                String studentId = this.getServletConfig().getInitParameter("studentId");
                PrintWriter writer = resp.getWriter();
                writer.println("name: "+myname);
                writer.println("studentId:"+studentId);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        }
}
