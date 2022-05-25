package com.yijun.controller;

import com.yijun.dao.ProductDao;
import com.yijun.model.Category;
import com.yijun.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/shop")
public class ShopServlet extends HomeServlet{

    Connection con = null;

    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Category category = new Category();
        List<Category> categoryList = category.findAllCategory(con);
        req.setAttribute("categoryList",categoryList);

        ProductDao productDao = new ProductDao();
        List<Product> productList = null;
        try{
            if(req.getParameter("categoryId")==null){
                productList = productDao.findAll(con);
            }else{
                int categoryId = Integer.parseInt(req.getParameter("categoryId"));
                productList = productDao.findByCategoryId(categoryId,con);
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        req.setAttribute("productList",productList);
        String path = "/WEB-INF/views/shop.jsp";
        req.getRequestDispatcher(path).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

