package com.LuoJing.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Category {
    private int CategoryID;
    private String CategoryName;
    private String Description;
    private boolean Active;

    @Override
    public String toString() {
        return "Category{" +
                "CategoryID=" + CategoryID +
                ", CategoryName='" + CategoryName + '\'' +
                ", Description='" + Description + '\'' +
                ", Active=" + Active +
                '}';
    }

    public int getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(int categoryID) {
        CategoryID = categoryID;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public Category() {
    }

    public Category(int categoryID, String categoryName, String description, boolean active) {
        CategoryID = categoryID;
        CategoryName = categoryName;
        Description = description;
        Active = active;
    }

    public static List<Category> findAllCategory(Connection con) throws SQLException {
        String sql = "select * from Category";
        List<Category> list = new ArrayList<Category>();
        PreparedStatement pt = con.prepareStatement(sql);
        ResultSet rs = pt.executeQuery();
        while (rs.next()){
            Category c = new Category();
            c.setCategoryID(rs.getInt("CategoryID"));
            c.setCategoryName(rs.getString("CategoryName"));
            c.setDescription(rs.getString("Description"));
            list.add(c);
        }
        return list;
    }

    public static String findByCaterotyID(Connection con,int categoryID) throws SQLException {
        String sql = "select * from Category where CategoryID = ?";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setInt(1,categoryID);
        ResultSet rs = pt.executeQuery();
        String CategoryName = null;
        while(rs.next())
        {
            CategoryName = rs.getString("CategoryName");

        }
        return CategoryName;

    }
}
