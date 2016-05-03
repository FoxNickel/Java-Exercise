package com.moneymanager;

public class LoginInfo {
	String userName;
	String passWord;
	static{
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
}
