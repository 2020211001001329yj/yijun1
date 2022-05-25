package com.yijun.controller;

import com.yijun.dao.UserDao;
import com.yijun.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet",value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private Connection connection;
    @Override
    public void init() throws ServletException {
        connection= (Connection) this.getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. -forward to WEB-INF/views/updateUser.jsp
        req.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. get all parameters
        HttpSession session = req.getSession();
        long id=((User)session.getAttribute("user")).getId();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String date = req.getParameter("date");
        //2. create a user model
        User user = new User();
        //3. set 6 value into user model
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(Long.parseLong(gender));
        user.setBirthday(Date.valueOf(date));
        //4. create an object of userdao
        UserDao userDao = new UserDao();
        try {
            //5. call updateUser() of userDao for update information
            int n = userDao.updateUser(connection,user);
            User updatedUser = userDao.findById(connection, (int) id);
            //userDao.updateUser(connection,user);
            //6. forword userinfo
            session.removeAttribute("user");
            session.setAttribute("user",updatedUser);
            //req.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(req,resp);
            req.getRequestDispatcher("accountDetails").forward(req,resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
