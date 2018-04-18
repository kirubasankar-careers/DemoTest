package com.qa.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestParameterXML {

	Connection con;

	@Test
	@Parameters({ "dbconfig", "poolsize" })
	
	public void createConnection(String dbconfig, int poolsize) throws ClassNotFoundException {

		System.out.println("dbconfig : " + dbconfig);
		System.out.println("poolsize : " + poolsize);
		
		Properties prop = new Properties();
		
		System.out.println(getClass());
		//Class cls = Class.forName(""+this.getClass());
		// returns the ClassLoader object associated with this Class
        ClassLoader cLoader =getClass().getClassLoader();
        System.out.println(cLoader);
        InputStream inputStream=null;
		try {
		  //get properties file from project classpath
		//inputStream =  getClass().getClassLoader().getResourceAsStream("C:\\eclipse\\git\\MAVENDEMO\\"+dbconfig);
		  inputStream=new FileInputStream("C:\\eclipse\\git\\MAVENDEMO\\"+dbconfig);
		  System.out.println(inputStream);
		  prop.load(inputStream);
		  String drivers = prop.getProperty("jdbc.driver");
		  String connectionURL = prop.getProperty("jdbc.url");
		  String username = prop.getProperty("jdbc.username");
		  String password = prop.getProperty("jdbc.password");

		  System.out.println("drivers : " + drivers);
		  System.out.println("connectionURL : " + connectionURL);
		  System.out.println("username : " + username);
		  System.out.println("password : " + password);

		  Class.forName(drivers);
		  con = DriverManager.getConnection(connectionURL, username, password);
		  Statement stmt=con.createStatement();  
		  ResultSet rs=stmt.executeQuery("select * from student");  
		  while(rs.next())  
			  System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
		  
		  con.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
