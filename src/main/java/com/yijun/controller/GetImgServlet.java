package com.yijun.controller;

import com.yijun.dao.ProductDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/getImg")
public class GetImgServlet extends HttpServlet {

    Connection con = null;


    @Override
    public void init() throws ServletException {
        con = (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        ProductDao dao = new ProductDao();
        int id = 0;
        if(req.getParameter("id")!=null){
            id = Integer.parseInt(req.getParameter("id"));
        }
        try {
            byte[] imgByte = new byte[0];
            imgByte = dao.getPictureById(id,con);
            if(imgByte != null){
                resp.setContentType("image/gif");
                ServletOutputStream os = resp.getOutputStream();
                os.write(imgByte);
                os.flush();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }//end doget

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
