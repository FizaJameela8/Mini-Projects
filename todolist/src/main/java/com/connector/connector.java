package com.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connector{
	public static Connection reqcon() {
		Connection con=null;
		String user="root";
		String pass="tiger";
		String url="jdbc:mysql://localhost:3306/todolist";
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con=DriverManager.getConnection(url,user,pass);
	System.out.println("connected successfull");
}catch(ClassNotFoundException |SQLException e){
	e.printStackTrace();
}
return con;
	}
}
