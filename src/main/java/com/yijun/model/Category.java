package com.yijun.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {

  private long categoryId;
  private String categoryName;
  private String description;
  private String active;

  public Category() {
  }

  public Category(long categoryId, String categoryName, String description, String active) {
    this.categoryId = categoryId;
    this.categoryName = categoryName;
    this.description = description;
    this.active = active;
  }

  public long getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(long categoryId) {
    this.categoryId = categoryId;
  }


  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  public String getActive() {
    return active;
  }

  public void setActive(String active) {
    this.active = active;
  }

  public static List<Category> findAllCategory(Connection con){
    List<Category> list = new ArrayList<Category>();
    String queryString = "select * from Category";

    try {
      PreparedStatement statement = con.prepareStatement(queryString);
      ResultSet resultSet = statement.executeQuery();
      while(resultSet.next()){
        Category c = new Category();
        c.setCategoryId(resultSet.getInt("categoryid"));
        c.setCategoryName(resultSet.getString("categoryName"));
        c.setDescription(resultSet.getString("Description"));
        list.add(c);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return list;
  }

  public static String findByCategoryId(Connection con, int categoryId){
    String categoryName = null;
    String queryString = "select CategoryName from Category where categoryId=?";
    try {
      PreparedStatement statement = con.prepareStatement(queryString);
      statement.setInt(1,categoryId);
      ResultSet resultSet = statement.executeQuery();
      while(resultSet.next()){
        categoryName = resultSet.getString("categoryName");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return categoryName;
  }

}
