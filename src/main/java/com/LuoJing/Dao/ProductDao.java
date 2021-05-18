package com.LuoJing.Dao;

import com.LuoJing.Model.*;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements  IProductDao{
    @Override
    public int save(Product product, Connection con) throws SQLException {
        int n = 0;
        String sql = "insert into product(ProductName,ProductDescription,Picture,price,CategoryID) values(?,?,?,?,?)";
        PreparedStatement pt = con.prepareStatement(sql);
        pt.setString(1, product.getProductName());
        pt.setString(2, product.getProductDescription());
        if(product.getPicture()!=null) {
            //for sql server
            pt.setBinaryStream(3, product.getPicture());
            //for mysql
            //   pt.setBlob(3, product.getPicture());
        }
        pt.setDouble(4, product.getPrice());
        pt.setInt(5, product.getCategoryID());
        n = pt.executeUpdate();
        if (n > 0) {
            return n;
        }
        return 0;
    }//end save

    @Override
    public int delete(Integer productId, Connection con) throws SQLException {
        String sql = "delete from product where=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setInt(1,productId);
        int count = stat.executeUpdate();
        return count;
    }

    @Override
    public int update(Product instance, Connection con) throws SQLException {
        String sql = "update product set ProductName=?,ProductDescription=?,Picture=?,Price=?,CategoryID=?where ProductId=?";

        PreparedStatement stat = con.prepareStatement(sql);

        stat.setString(1,instance.getProductName());
        stat.setString(2,instance.getProductDescription());
        stat.setString(3, String.valueOf(instance.getPicture()));
        stat.setDouble(4,instance.getPrice());
        stat.setInt(5,instance.getProductId());
        stat.setInt(6,instance.getCategoryID());

        int count = stat.executeUpdate();
        return count;
    }

    @Override
    public Product findById(Integer productId, Connection con) throws SQLException {
        String sql = "SELECT * from product where ProductId=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setInt(1,productId);
        ResultSet rs = stat.executeQuery();
        Product product = null ;
        if (rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
//            product.setPicture(rs.getString("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryID(rs.getInt("CategoryID"));
        }
        return product;
    }

    @Override
    public List<Product> findByCategoryId(int categoryId, Connection con) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * from product where CategoryID=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setInt(1,categoryId);
        ResultSet rs = stat.executeQuery();
        Product product = null ;
        while (rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
//            product.setPicture(rs.getString("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryID(rs.getInt("CategoryID"));
            products.add(product);
        }
        return products;
    }

//    ？？？？？
    @Override
    public List<Product> findByPrice(double minPrice, double maxPrice, Connection con) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * from product where Price=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setDouble(1,minPrice);
        ResultSet rs = stat.executeQuery();
        Product product = null ;
        while (rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
//            product.setPicture(rs.getString("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryID(rs.getInt("CategoryID"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> findAll(Connection con) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * from product";
        PreparedStatement stat = con.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        Product product = null ;
        while(rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
//            product.setPicture(rs.getString("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryID(rs.getInt("CategoryID"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> findByProductName(String productName, Connection con) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * from product where ProductName=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1,productName);
        ResultSet rs = stat.executeQuery();
        Product product = null ;
        while (rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
//            product.setPicture(rs.getString("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryID(rs.getInt("CategoryID"));
            products.add(product);
        }
        return products;
    }

    @Override
    public List<Product> getPicture(Integer productId, Connection con) throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * from product where ProductId=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setInt(1,productId);
        ResultSet rs = stat.executeQuery();
        Product product = null ;
        while (rs.next()){
            product = new Product();
            product.setProductId(rs.getInt("ProductId"));
            product.setProductName(rs.getString("ProductName"));
            product.setProductDescription(rs.getString("ProductDescription"));
//            product.setPicture(rs.getString("Picture"));
            product.setPrice(rs.getDouble("Price"));
            product.setCategoryID(rs.getInt("CategoryID"));
            products.add(product);
        }
        return products;
    }
}
