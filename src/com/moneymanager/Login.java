package com.moneymanager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	public Login(DataBase dataBase) {
		setTitle("��ӭʹ�ø�������˱�");// ���ڱ���
		setSize(400, 270);// ���ô��ڿ�Ⱥ͸߶�
		setLocationRelativeTo(null);// ���ô��ھ���
		getContentPane().setLayout(null);// LayoutΪ��
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// �ɹرյĴ���
		// ������

		JLabel welcome = new JLabel();
		welcome.setText("��ӭʹ�ø������ϵͳ");
		welcome.setBounds(80, 10, 300, 20);// ���꣬���
		welcome.setFont(new Font(Font.DIALOG, Font.BOLD, 20));// �������ã��������ͣ��Ӵ֣���С��
		getContentPane().add(welcome);// �������ʾ����
		// �ı�����ʾ��ӭ��ʾ��

		JLabel userName = new JLabel();
		userName.setText("�û���:");
		userName.setBounds(40, 60, 80, 20);
		userName.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(userName);// �ı�����ʾ�û��������֣�

		JTextField nameInput = new JTextField();
		nameInput.setHorizontalAlignment(JTextField.CENTER);
		nameInput.setBounds(130, 55, 200, 30);
		nameInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(nameInput);// ����������û�����

		JLabel passWord = new JLabel();
		passWord.setText("��    ��:");
		passWord.setBounds(40, 100, 80, 20);
		passWord.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		getContentPane().add(passWord);// �ı�����ʾ���������֣�

		JPasswordField passWordInput = new JPasswordField();
		passWordInput.setHorizontalAlignment(JTextField.CENTER);// �������ݾ���
		passWordInput.setBounds(130, 95, 200, 30);
		passWordInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		passWordInput.setEchoChar('*');// ����󿴵�����*
		getContentPane().add(passWordInput);// ������������룩

		final JButton login = new JButton();
		login.setText("��½");
		login.setContentAreaFilled(false);// ��ť����ɫ
		login.setBounds(40, 155, 130, 40);
		getContentPane().add(login);// ��½��ť

		// ��½��Ť����¼�
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String userName1 = nameInput.getText().trim();
				String passWord1 = passWordInput.getText().trim();
				if (userName1.equals(dataBase.userName)&&passWord1.equals(dataBase.passWord)) {
					MainMenu mainMenu = new MainMenu(dataBase);
					mainMenu.setVisible(true);
					dispose();
				}else{
					//���������ʾ��
					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50,50,300, 200);
					error.setLocationRelativeTo(login);
					error.setVisible(true);
					error.setLayout(null);
					
					JLabel errorText = new JLabel();
					errorText.setText("�û������������");
					errorText.setBounds(25, 40, 250, 25);
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
					//���������ʾ��
				}
			}
		});
		// ��½��Ť����¼�����

		final JButton exit = new JButton();
		exit.setText("�˳�");
		exit.setContentAreaFilled(false);// ��ť����ɫ
		exit.setBounds(195, 155, 135, 40);
		getContentPane().add(exit);// �˳���ť

		// �˳���Ť����¼�
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		// �˳���Ť����¼�����
	}

}
