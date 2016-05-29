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
		setTitle("�޸�����");// ���ڱ���
		setSize(400, 270);// ���ô��ڿ�Ⱥ͸߶�
		setLocationRelativeTo(null);// ���ô��ھ���
		getContentPane().setLayout(null);// LayoutΪ��
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// �ɹرյĴ���
		// ������
		
		JLabel oldPass = new JLabel();
		oldPass.setText("������:");
		oldPass.setBounds(40, 20, 80, 20);
		oldPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(oldPass);// �ı�����ʾ�û��������֣�

		JPasswordField oldPassInput = new JPasswordField();
		oldPassInput.setHorizontalAlignment(JTextField.CENTER);
		oldPassInput.setBounds(140, 15, 200, 30);
		oldPassInput.setEchoChar('*');// ����󿴵�����*
		oldPassInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(oldPassInput); 

		JLabel newPass = new JLabel();
		newPass.setText("������:");
		newPass.setBounds(40, 65, 200, 20);
		newPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(newPass);// �ı�����ʾ���������֣�

		JPasswordField newPassInput = new JPasswordField();
		newPassInput.setHorizontalAlignment(JTextField.CENTER);// �������ݾ���
		newPassInput.setBounds(140, 60, 200, 30);
		newPassInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		newPassInput.setEchoChar('*');// ����󿴵�����*
		getContentPane().add(newPassInput);

		JLabel confirmNewPass = new JLabel();
		confirmNewPass.setText("ȷ��������:");
		confirmNewPass.setBounds(20, 110, 200, 20);
		confirmNewPass.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(confirmNewPass);// �ı�����ʾ���������֣�

		JPasswordField newPassInput2 = new JPasswordField();
		newPassInput2.setHorizontalAlignment(JTextField.CENTER);// �������ݾ���
		newPassInput2.setBounds(140, 105, 200, 30);
		newPassInput2.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		newPassInput2.setEchoChar('*');// ����󿴵�����*
		getContentPane().add(newPassInput2);// ������������룩

		final JButton confirm = new JButton();
		confirm.setText("ȷ��");
		confirm.setContentAreaFilled(false);// ��ť����ɫ
		confirm.setBounds(40, 155, 130, 40);
		getContentPane().add(confirm);// ��½��ť

		//�޸������
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
					
					//�޸ĳɹ���ʾ��
					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50,50,300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);
					
					JLabel errorText = new JLabel();
					errorText.setText("�޸ĳɹ������½���ϵͳ");
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
							mainMenu.dispose();
							new Login(dataBase).setVisible(true);
						}
					});
					error.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//���õ����Ĵ��ڲ��ɱ��ر�
					//�޸ĳɹ���ʾ��
					
				}else if(!oldPass.equals(dataBase.passWord)){
					//�����������ʾ��
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
					errorText.setText("���������");
					errorText.setBounds(75, 40, 250, 25);
					errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
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
					//�����������ʾ��
				}else if(!newPass.equals(newPass2)){
					//��������������벻һ����ʾ��
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
					errorText.setText("��������������벻һ��");
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
					//��������������벻һ����ʾ��
				}
			}
		});
		//�޸���������
		
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
	}

}
