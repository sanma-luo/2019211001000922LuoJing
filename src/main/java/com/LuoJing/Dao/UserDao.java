package com.LuoJing.Dao;

import com.LuoJing.Model.User;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//UserDao
public class UserDao implements IUserDao{
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        String sql = "insert into usertable values(null,?,?,?,?,?)";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1,user.getUsername());
        stat.setString(2,user.getPassword());
        stat.setString(3,user.getEmail());
        stat.setString(4,user.getGender());
        stat.setString(5, dateFormat.format(user.getBirthday()));
        int count = stat.executeUpdate();
        boolean flog = false;
        if (count>0){
            flog = true;
        }
        return flog;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        String sql = "delete from usertable where=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setInt(1,user.getId());
        int count = stat.executeUpdate();
        return count;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        String sql = "update usertable set username=?,password=?,email=?,gender=?,birthday=?where id=?";

        PreparedStatement stat = con.prepareStatement(sql);

        stat.setString(1,user.getUsername());
        stat.setString(2,user.getPassword());
        stat.setString(3,user.getEmail());
        stat.setString(4,user.getGender());
        stat.setString(5, dateFormat.format(user.getBirthday()));
        stat.setInt(6,user.getId());


        int count = stat.executeUpdate();
        return count;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "SELECT * from usertable where id=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setInt(1,id);
        ResultSet rs = stat.executeQuery();
        User user = null ;
        if (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "SELECT * from usertable where username=? and password=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1,username);
        stat.setString(2,password);
        ResultSet rs = stat.executeQuery();
        User user = null ;
        if (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * from usertable where username=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1,username);
        ResultSet rs = stat.executeQuery();
        User user = null ;
        while (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * from usertable where password=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1,password);
        ResultSet rs = stat.executeQuery();
        User user = null ;
        while (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * from usertable where email=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1,email);
        ResultSet rs = stat.executeQuery();
        User user = null ;
        while (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * from usertable where gender=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setString(1,gender);
        ResultSet rs = stat.executeQuery();
        User user = null ;
        while (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * from usertable where birthDate=?";
        PreparedStatement stat = con.prepareStatement(sql);
        stat.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs = stat.executeQuery();
        User user = null ;
        while (rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * from usertable";
        PreparedStatement stat = con.prepareStatement(sql);
        ResultSet rs = stat.executeQuery();
        User user = null ;
        while(rs.next()){
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthday(rs.getDate("birthday"));
            users.add(user);
        }
        return users;
    }
}
