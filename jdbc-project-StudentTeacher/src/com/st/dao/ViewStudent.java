package com.st.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.st.configuration.HelperClass;

public class ViewStudent {
	
	public static void viewStudent() {

		HelperClass helperClass = new HelperClass();		
		Connection connection = helperClass.getConnection();
		String sql = "SELECT * FROM student";
		try {
			PreparedStatement prepareStatement = connection.prepareStatement(sql);

			ResultSet resultSet = prepareStatement.executeQuery(sql);

			while (resultSet.next()) {
				System.out.println("\t "+resultSet.getInt(1) + "\t\t" + resultSet.getString(2) + "\t\t" + resultSet.getString(3));
				System.out.println("==============================================================");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5:Close connection
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	
}}
