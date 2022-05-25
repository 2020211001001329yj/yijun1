package com.yijun.week6;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Objects;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String text = req.getParameter("txt");
        text= URLEncoder.encode(text,"UTF-8");//中文乱码
        String search = req.getParameter("search");
        if(Objects.equals(text, "")){
            //text is null
            resp.sendRedirect("index.jsp");
        }else{
            if(Objects.equals(search, "baidu")){
                resp.sendRedirect("https://www.baidu.com/s?wd="+text);
            }else if(Objects.equals(search, "bing")){
                resp.sendRedirect("https://cn.bing.com/search?q="+text);
            }else if(Objects.equals(search, "google")){
                resp.sendRedirect("https://www.google.com/search?q="+text);
            }
        }
    }
}
