package com.yijun.controller;

import com.yijun.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "AdminHomeServlet",value = "/admin/home")
public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);//return session or NULL session 0 but its not create a new session
        if(session!=null && session.getAttribute("user")!=null){
            User user = (User) session.getAttribute("user");
            if("admin".equals(user.getUsername())){
                //admin username must be in table
                req.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(req,resp);
            }else{
                //have session but its not admin user
                session.invalidate();//kill session right now
                req.setAttribute("message","Unauthorized Access Admin Module!!!");
                req.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(req,resp);
            }
        }else{
            //no session - then user click the link
            req.setAttribute("message","Please login as admin");
            req.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
