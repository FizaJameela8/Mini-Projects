package com.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.connector.connector;
import com.user.dto.User;

public class userimplement implements userinterface {
Connection con=null;
public userimplement(){
	this.con=connector.reqcon();
	if(con==null) {
		System.out.println("Database failed to connect");
		throw new RuntimeException("Failed to connect");
	}else {
		System.out.println("connected successfully");
	}
	}
@Override
public boolean insert(User u) {
    int i=0;
    String query = "INSERT INTO users(name, phone, email, location, password)values(?,?,?,?,?)";
    try {
    	PreparedStatement ps=con.prepareStatement(query);
    	ps.setString(1,u.getName());
    	ps.setLong(2,u.getPhone());
    	ps.setString(3,u.getEmail());
    	ps.setString(4,u.getLocation());
    	ps.setString(5,u.getPassword());
    	i=ps.executeUpdate();
    }
    catch(SQLException e) {
    	e.printStackTrace();
    }
	return i>0;
}
@Override
public boolean delete(User u) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public User get(String email, String pasword) {
	String query="Select * from users where email=? AND password=?";
	User u=null;
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,email);
		ps.setString(2,pasword);
		ResultSet  res=ps.executeQuery();
		if(res.next()) {
			u=extractUserFromResultSet(res);
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	return u;
	
}
private User extractUserFromResultSet(ResultSet res)throws SQLException{
	User u=new User();
	u.setId(res.getInt("id")); 
	   u.setName(res.getString("name"));
       u.setPhone(res.getLong("phone"));
       u.setEmail(res.getString("email"));
       u.setLocation(res.getString("location"));
       u.setPassword(res.getString("password"));
       return u;
}
@Override
public User get(String email, long phone) {
	String query="SELECT * FROM USERS WHERE email=? AND phone=?";
	User u= new User();
	try {
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1,email);
		ps.setLong(2, phone);
	    ResultSet res=ps.executeQuery();
    	if(res.next()) {
		u=extractUserFromResultSet(res);
	    }
	
	}catch(SQLException e) 
	{
		e.printStackTrace();
	}
	
  return u;
}
@Override
public boolean updatePassword(User u) {
	 String query = "UPDATE USERS SET password=? WHERE email=? AND phone=?";
     int rows = 0;
     try {
         PreparedStatement ps = con.prepareStatement(query);
         ps.setString(1, u.getPassword());
         ps.setString(2, u.getEmail());
         ps.setLong(3, u.getPhone());
         rows = ps.executeUpdate();
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return rows > 0;
 }
}