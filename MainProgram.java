package com.moneymanager;

public class MainProgram {
	public static void main(String[] args) {
		//��½ǰ�������ݿ�
		DataBase dataBase = new DataBase();
		//��½ǰ�������ݿ����
		//��½����
		Login login = new Login(dataBase);
		login.setVisible(true);
		//��½�������
	}

}
