package com.moneymanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MainProgram {
	public static void main(String[] args) {
		//��½ǰ�������ݿ�
		DataBase dataBase = new DataBase();
		try {
			Connection conn = DriverManager.getConnection(dataBase.URL,dataBase.USERNAME,dataBase.PASSWORD);
			java.sql.Statement statement = conn.createStatement();
			String sql = "select * from loginInfo";
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()){
				dataBase.userName = rs.getString(1);
				dataBase.passWord = rs.getString(2);
			}
			rs.close();
			conn.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//��½ǰ�������ݿ����
		
		//��½����
		Login login = new Login(dataBase);
		login.setVisible(true);
		//��½�������
	}

}
