package com.moneymanager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Register extends JFrame {
	public Register(DataBase dataBase) {
		//界面区
		setTitle("用户注册");// 窗口标题
		setSize(400, 270);// 设置窗口宽度和高度
		setLocationRelativeTo(null);// 设置窗口居中
		getContentPane().setLayout(null);// Layout为空
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 可关闭的窗口
		// 主窗口

		JLabel userName = new JLabel();
		userName.setText("用户名:");
		userName.setBounds(40, 20, 80, 20);
		userName.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(userName);// 文本框（显示用户名三个字）

		JTextField userNameInput = new JTextField();
		userNameInput.setHorizontalAlignment(JTextField.CENTER);
		userNameInput.setBounds(140, 15, 200, 30);
		userNameInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(userNameInput);

		JLabel password = new JLabel();
		password.setText("密码:");
		password.setBounds(40, 65, 200, 20);
		password.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(password);// 文本框（显示密码两个字）

		JPasswordField passwordInput = new JPasswordField();
		passwordInput.setHorizontalAlignment(JTextField.CENTER);// 输入内容居中
		passwordInput.setBounds(140, 60, 200, 30);
		passwordInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		passwordInput.setEchoChar('*');// 输入后看到的是*
		getContentPane().add(passwordInput);

		JLabel confirmPass = new JLabel();
		confirmPass.setText("确认密码:");
		confirmPass.setBounds(20, 110, 200, 20);
		confirmPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(confirmPass);// 文本框（显示密码两个字）

		JPasswordField confirmPassInput = new JPasswordField();
		confirmPassInput.setHorizontalAlignment(JTextField.CENTER);// 输入内容居中
		confirmPassInput.setBounds(140, 105, 200, 30);
		confirmPassInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		confirmPassInput.setEchoChar('*');// 输入后看到的是*
		getContentPane().add(confirmPassInput);// 输入框（输入密码）

		final JButton confirm = new JButton();
		confirm.setText("确定");
		confirm.setContentAreaFilled(false);// 按钮无颜色
		confirm.setBounds(40, 155, 130, 40);
		getContentPane().add(confirm);
		//界面区
		
		//功能区
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = userNameInput.getText().trim();
				String password = passwordInput.getText().trim();
				String confirmPassword = confirmPassInput.getText().trim();
				if (!password.equals(confirmPassword)) {
					// 两次输入的新密码不一致提示框
					userNameInput.setText("");
					passwordInput.setText("");
					confirmPassInput.setText("");
					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50, 50, 300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);

					JLabel errorText = new JLabel();
					errorText.setText("两次输入的密码不一致");
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
					// 两次输入的新密码不一致提示框
				} else {
					try {
						Connection conn = DriverManager.getConnection(dataBase.URL, dataBase.USERNAME,
								dataBase.PASSWORD);
						String register = "insert into LoginInfo values ('"+userNameInput.getText().trim()+"','"+passwordInput.getText().trim()+"')";
						Statement statement = conn.createStatement();
						statement.execute(register);
					} catch (SQLException ex) {
						ex.printStackTrace();
					}

					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50, 50, 300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);

					JLabel errorText = new JLabel();
					errorText.setText("注册成功请登陆系统");
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
						}
					});
					error.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// 设置弹出的窗口不可被关闭
				}
			}
		});

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
		
		//功能区
	}
}
