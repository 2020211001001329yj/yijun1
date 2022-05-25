package com.yijun.week3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    public Connection connection = null;

    @Override
    public void init() throws ServletException {
        String driver = this.getServletContext().getInitParameter("driver");
        String url = this.getServletContext().getInitParameter("url");
        String username = this.getServletContext().getInitParameter("username");
        String password = this.getServletContext().getInitParameter("password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            connection= DriverManager.getConnection(url,username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/views/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String date = req.getParameter("date");
        String sql = "INSERT INTO usertable(username,password,email,gender,birthday) VALUES(?,?,?,?,?)";
        PreparedStatement preparedStatement = null;
        int resultSet;
        try {
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,email);
            preparedStatement.setInt(4, Integer.parseInt(gender));
            preparedStatement.setDate(5, Date.valueOf(date));
            resultSet=preparedStatement.executeUpdate();//执行sql语句
        } catch (SQLException e) {
            e.printStackTrace();
        }
/**week3--comment
        writer.println("<HTML>");
        writer.println("<HEAD><TITLE>UsingServlet</TITLE></HEAD>");
        writer.println("<BODY>");
//        writer.println("<p>username :"+username+"</p>");
//        writer.println("<p>password :"+password+"</p>");
//        writer.println("<p>email :"+email+"</p>");
//        writer.println("<p>gender :"+gender+"</p>");
//        writer.println("<p>date :"+date+"</p>");
        writer.println("<table border=\"1\">");
        writer.println("<tr>");
        writer.println("<th>"+"ID"+"</th>");
        writer.println("<th>"+"username"+"</th>");
        writer.println("<th>"+"password"+"</th>");
        writer.println("<th>"+"email"+"</th>");
        writer.println("<th>"+"gender"+"</th>");
        writer.println("<th>"+"birthday"+"</th>");
        writer.println("</tr>");
        //查询数据库的数据
        String sql1 = "select * from usertable";
        PreparedStatement preparedStatement1 = null;
        try {
            preparedStatement1 = connection.prepareStatement(sql1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet resultSet1 = null;
        try {
            resultSet1=preparedStatement1.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                if (!resultSet1.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                writer.println("<tr>");
                writer.println("<td>"+resultSet1.getInt("id")+"</td>");
                writer.println("<td>"+resultSet1.getString("username")+"</td>");
                writer.println("<td>"+resultSet1.getString("password")+"</td>");
                writer.println("<td>"+resultSet1.getString("email")+"</td>");
                writer.println("<td>"+resultSet1.getString("gender")+"</td>");
                writer.println("<td>"+resultSet1.getDate("birthday")+"</td>");
                writer.println("</tr>");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        writer.println("</table>");
        writer.println("</BODY>");
        writer.println("</HTML>");
*/
        //resp.sendRedirect("login.jsp");
        resp.sendRedirect("login");//loginServlet
    }
}
