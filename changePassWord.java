package com.moneymanager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class changePassWord extends JFrame {

	public changePassWord(DataBase dataBase,MainMenu mainMenu) {
		setTitle("修改密码");// 窗口标题
		setSize(400, 270);// 设置窗口宽度和高度
		setLocationRelativeTo(null);// 设置窗口居中
		getContentPane().setLayout(null);// Layout为空
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 可关闭的窗口
		// 主窗口
		
		JLabel oldPass = new JLabel();
		oldPass.setText("旧密码:");
		oldPass.setBounds(40, 20, 80, 20);
		oldPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(oldPass);// 文本框（显示用户名三个字）

		JPasswordField oldPassInput = new JPasswordField();
		oldPassInput.setHorizontalAlignment(JTextField.CENTER);
		oldPassInput.setBounds(140, 15, 200, 30);
		oldPassInput.setEchoChar('*');// 输入后看到的是*
		oldPassInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(oldPassInput); 

		JLabel newPass = new JLabel();
		newPass.setText("新密码:");
		newPass.setBounds(40, 65, 200, 20);
		newPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(newPass);// 文本框（显示密码两个字）

		JPasswordField newPassInput = new JPasswordField();
		newPassInput.setHorizontalAlignment(JTextField.CENTER);// 输入内容居中
		newPassInput.setBounds(140, 60, 200, 30);
		newPassInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		newPassInput.setEchoChar('*');// 输入后看到的是*
		getContentPane().add(newPassInput);

		JLabel confirmNewPass = new JLabel();
		confirmNewPass.setText("确认新密码:");
		confirmNewPass.setBounds(20, 110, 200, 20);
		confirmNewPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(confirmNewPass);// 文本框（显示密码两个字）

		JPasswordField newPassInput2 = new JPasswordField();
		newPassInput2.setHorizontalAlignment(JTextField.CENTER);// 输入内容居中
		newPassInput2.setBounds(140, 105, 200, 30);
		newPassInput2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		newPassInput2.setEchoChar('*');// 输入后看到的是*
		getContentPane().add(newPassInput2);// 输入框（输入密码）

		final JButton confirm = new JButton();
		confirm.setText("确定");
		confirm.setContentAreaFilled(false);// 按钮无颜色
		confirm.setBounds(40, 155, 130, 40);
		getContentPane().add(confirm);// 登陆按钮

		//修改密码块
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String oldPass = oldPassInput.getText().trim();
				String newPass = newPassInput.getText().trim();
				String newPass2 = newPassInput2.getText().trim();
				if(oldPass.equals(dataBase.passWord)&&newPass.equals(newPass2)){
					final String URL = "jdbc:sqlserver://localhost:1433;DatabaseName=moneyManager";
					final String USERNAME = "sa";
					final String PASSWORD = "159753";
					try {
						Connection conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
						String changePass = "update LoginInfo set upw = ? where uid = ?";
						PreparedStatement statement = conn.prepareStatement(changePass);
						statement.setString(2, dataBase.userName);
						statement.setString(1, newPass);
						int i = statement.executeUpdate();
						System.out.println(i);
						conn.close();
						statement.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
					
					//修改成功提示框
					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50,50,300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);
					
					JLabel errorText = new JLabel();
					errorText.setText("修改成功请重新进入系统");
					errorText.setBounds(25, 40, 400, 25);
					errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
					error.add(errorText);
					
					JButton confirm = new JButton();
					confirm.setText("确定");
					confirm.setBounds(100, 90, 80, 40);
					confirm.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
					confirm.setContentAreaFilled(false);
					error.add(confirm);
					
					confirm.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							error.dispose();
							dispose();
							mainMenu.dispose();
							new Login(dataBase).setVisible(true);
						}
					});
					error.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//设置弹出的窗口不可被关闭
					//修改成功提示框
					
				}else if(!oldPass.equals(dataBase.passWord)){
					//旧密码错误提示框
					oldPassInput.setText("");
					newPassInput.setText("");
					newPassInput2.setText("");
					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50,50,300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);
					
					JLabel errorText = new JLabel();
					errorText.setText("旧密码错误");
					errorText.setBounds(75, 40, 250, 25);
					errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
					error.add(errorText);
					
					JButton confirm = new JButton();
					confirm.setText("确定");
					confirm.setBounds(100, 90, 80, 40);
					confirm.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
					confirm.setContentAreaFilled(false);
					error.add(confirm);
					
					confirm.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							error.dispose();
						}
					});
					//旧密码错误提示框
				}else if(!newPass.equals(newPass2)){
					//两次输入的新密码不一致提示框
					oldPassInput.setText("");
					newPassInput.setText("");
					newPassInput2.setText("");
					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50,50,300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);
					
					JLabel errorText = new JLabel();
					errorText.setText("两次输入的新密码不一致");
					errorText.setBounds(25, 40, 400, 25);
					errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
					error.add(errorText);
					
					JButton confirm = new JButton();
					confirm.setText("确定");
					confirm.setBounds(100, 90, 80, 40);
					confirm.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
					confirm.setContentAreaFilled(false);
					error.add(confirm);
					
					confirm.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							error.dispose();
						}
					});
					//两次输入的新密码不一致提示框
				}
			}
		});
		//修改密码块结束
		
		final JButton exit = new JButton();
		exit.setText("取消");
		exit.setContentAreaFilled(false);// 按钮无颜色
		exit.setBounds(195, 155, 135, 40);
		getContentPane().add(exit);// 退出按钮
		// 取消按钮的点击事件
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		// 取消按钮的点击事件
	}

}
