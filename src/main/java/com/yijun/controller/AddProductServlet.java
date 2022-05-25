package com.yijun.controller;

import com.yijun.dao.ProductDao;
import com.yijun.model.Category;
import com.yijun.model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AddProductServlet",value = "/admin/addProduct")
@MultipartConfig(maxFileSize = 16177215) //upload file's size up to 16MB
public class AddProductServlet extends HttpServlet {

    Connection con;

    @Override
    public void init() throws ServletException {
        con=(Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Category> categoryList = Category.findAllCategory(con);
        req.setAttribute("categoryList",categoryList);
        //we will use later
        String path = "/WEB-INF/views/admin/addProduct.jsp";
        req.getRequestDispatcher(path).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get parameters
        String productName = req.getParameter("productName");
        Double price = req.getParameter("price")!=null?Double.parseDouble(req.getParameter("price")):0.0;
        int categoryId = req.getParameter("categoryId")!=null?Integer.parseInt(req.getParameter("categoryId")):0;
        String productDescription = req.getParameter("productDescription");
        //picture
        InputStream inputStream = null;// input stream of the upload file
        Part filePart = req.getPart("picture");// obtains the upload file part in this multipart request
        if(filePart != null){
            System.out.println("file name :"+filePart.getName()+" size :"+filePart.getSize()+" file type :"+filePart.getContentType());
            inputStream = filePart.getInputStream();// obtains input stream of the upload file
        }
        //set in model
        Product product = new Product();
        product.setProductName(productName);
        product.setPrice(price);
        product.setProductDescription(productDescription);
        product.setCategoryId(categoryId);

        ProductDao dao = new ProductDao();
        int i=0;
        try {
            i = dao.save(product,inputStream,con);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if(i>0){
            // response.sendRedirect("productList");//next class
        }
    }// end post
}
