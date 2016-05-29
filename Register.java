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
		//������
		setTitle("�û�ע��");// ���ڱ���
		setSize(400, 270);// ���ô��ڿ�Ⱥ͸߶�
		setLocationRelativeTo(null);// ���ô��ھ���
		getContentPane().setLayout(null);// LayoutΪ��
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �ɹرյĴ���
		// ������

		JLabel userName = new JLabel();
		userName.setText("�û���:");
		userName.setBounds(40, 20, 80, 20);
		userName.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(userName);// �ı�����ʾ�û��������֣�

		JTextField userNameInput = new JTextField();
		userNameInput.setHorizontalAlignment(JTextField.CENTER);
		userNameInput.setBounds(140, 15, 200, 30);
		userNameInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(userNameInput);

		JLabel password = new JLabel();
		password.setText("����:");
		password.setBounds(40, 65, 200, 20);
		password.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(password);// �ı�����ʾ���������֣�

		JPasswordField passwordInput = new JPasswordField();
		passwordInput.setHorizontalAlignment(JTextField.CENTER);// �������ݾ���
		passwordInput.setBounds(140, 60, 200, 30);
		passwordInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		passwordInput.setEchoChar('*');// ����󿴵�����*
		getContentPane().add(passwordInput);

		JLabel confirmPass = new JLabel();
		confirmPass.setText("ȷ������:");
		confirmPass.setBounds(20, 110, 200, 20);
		confirmPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(confirmPass);// �ı�����ʾ���������֣�

		JPasswordField confirmPassInput = new JPasswordField();
		confirmPassInput.setHorizontalAlignment(JTextField.CENTER);// �������ݾ���
		confirmPassInput.setBounds(140, 105, 200, 30);
		confirmPassInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		confirmPassInput.setEchoChar('*');// ����󿴵�����*
		getContentPane().add(confirmPassInput);// ������������룩

		final JButton confirm = new JButton();
		confirm.setText("ȷ��");
		confirm.setContentAreaFilled(false);// ��ť����ɫ
		confirm.setBounds(40, 155, 130, 40);
		getContentPane().add(confirm);
		//������
		
		//������
		confirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName = userNameInput.getText().trim();
				String password = passwordInput.getText().trim();
				String confirmPassword = confirmPassInput.getText().trim();
				if (!password.equals(confirmPassword)) {
					// ��������������벻һ����ʾ��
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
					errorText.setText("������������벻һ��");
					errorText.setBounds(25, 40, 400, 25);
					errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
					error.add(errorText);

					JButton confirm = new JButton();
					confirm.setText("ȷ��");
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
					// ��������������벻һ����ʾ��
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
					errorText.setText("ע��ɹ����½ϵͳ");
					errorText.setBounds(25, 40, 400, 25);
					errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
					error.add(errorText);

					JButton confirm = new JButton();
					confirm.setText("ȷ��");
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
					error.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);// ���õ����Ĵ��ڲ��ɱ��ر�
				}
			}
		});

		final JButton exit = new JButton();
		exit.setText("ȡ��");
		exit.setContentAreaFilled(false);// ��ť����ɫ
		exit.setBounds(195, 155, 135, 40);
		getContentPane().add(exit);// �˳���ť
		// ȡ����ť�ĵ���¼�
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		// ȡ����ť�ĵ���¼�
		
		//������
	}
}
