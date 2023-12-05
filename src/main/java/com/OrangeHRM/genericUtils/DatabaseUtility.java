package com.OrangeHRM.genericUtils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection con = null;
	public void connectToDB(String path, String un, String pass) throws SQLException {
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		DriverManager.getConnection(path,un,pass);
	}
	
	public String excutequeryAndGetData(String query, String exp, int col) throws SQLException {
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query);
		boolean flag = false;
		while(result.next()) {
			String act = result.getString(col);
			if(act.equalsIgnoreCase(exp)) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("Data is verifed");
			return exp;
		}
		else
		{
			System.out.println("Data is not verified");
			return "";
		}
	}
	
	public void disconnectDB() throws SQLException {
		con.close();
	}
}
