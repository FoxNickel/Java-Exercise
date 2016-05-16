/**
 * 
 */
package com.moneymanager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class MainMenu extends JFrame {

	static boolean isDate(String date)
	{
		if(date.length()!=8) return false;
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
		try {
			format.setLenient(false);
			format.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}
	
	public MainMenu(DataBase dataBase) {

		/* ������ */
		setTitle("��ӭʹ�ø�������˱�");// ���ڱ���
		setSize(800, 750);// ���ô��ڿ�Ⱥ͸߶�
		setLocationRelativeTo(null);// ���ô��ھ���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);// ���ڴ�С���ɱ�
		getContentPane().setLayout(null);// ����Ϊnull��������ô�С
		/* �����ڽ��� */

		/* �˵��� */
		JMenuBar topMenuBar = new JMenuBar();// ���˵���������װ���˵���MenuBar��
		setJMenuBar(topMenuBar);// �����˵�����ʾ
		JMenu systemManage = new JMenu("ϵͳ����");// ���˵�1����
		topMenuBar.add(systemManage);// �����˵�1��ӵ�MenuBar��ȥ
		JMenuItem resetPassWord = new JMenuItem("��������");// �����Ӳ˵�1
		JMenuItem exit = new JMenuItem("�˳�ϵͳ");// �����Ӳ˵�2
		systemManage.add(resetPassWord);// �������Ӳ˵�1��ʾ����
		systemManage.addSeparator();// �ָ���
		systemManage.add(exit);// �������Ӳ˵�2��ʾ����
		// �������ð�ť�ĵ���¼�
		resetPassWord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePassWord changePass = new changePassWord(dataBase, MainMenu.this);
				changePass.setVisible(true);
			}
		});
		// �������ð�ť�ĵ���¼�
		// �˳�ϵͳ��ť�ĵ���¼�
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		// �˳�ϵͳ��ť�ĵ���¼�
		JMenu ioManage = new JMenu("��֧����");// ���˵�2����
		topMenuBar.add(ioManage);// �����˵�2��ӵ�MenuBar��ȥ
		JMenuItem editIO = new JMenuItem("��֧�༭");// �����Ӳ˵�
		ioManage.add(editIO);// ��ʾ�����Ӳ˵�
		// ��֧�༭��ť�ĵ���¼�
		editIO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				IOEditor iOEditor = new IOEditor(dataBase);
				iOEditor.setVisible(true);
				dispose();
			}
		});
		// ��֧�༭��ť�ĵ���¼�
		/* �˵������� */

		/* ��ѯ������ */
		// ���������
		Border titleBorder1 = BorderFactory.createTitledBorder("�����ѯ����");
		JPanel topJpanel = new JPanel();
		topJpanel.setBorder(titleBorder1);
		topJpanel.setBounds(0, 0, 795, 200);
		getContentPane().add(topJpanel);
		// ���������

		GridLayout gridLayout2 = new GridLayout(3, 1);
		gridLayout2.setVgap(5);
		topJpanel.setLayout(gridLayout2);// ʹtopJpanelһ��Ϊ��

		// ��һ��
		JPanel topIndexJpanel1 = new JPanel();
		topJpanel.add(topIndexJpanel1);

		JLabel typeOfIO = new JLabel();
		typeOfIO.setText("��֧����:");
		typeOfIO.setSize(80, 20);
		typeOfIO.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel1.add(typeOfIO);// ��֧����

		String[] type = { "����", "֧��" };
		JComboBox<String> selsectTypeOfIO = new JComboBox<String>(type);
		selsectTypeOfIO.setMaximumRowCount(2);
		selsectTypeOfIO.setSelectedItem("����");
		selsectTypeOfIO.setEditable(false);
		topIndexJpanel1.add(selsectTypeOfIO);// ѡ����֧���͵Ŀ�

		JButton search1 = new JButton();
		search1.setText("��ѯ");
		topIndexJpanel1.add(search1);// ��ѯ��ť
		// ��һ�н���

		// �ڶ���
		JPanel topIndexJpanel2 = new JPanel();
		topJpanel.add(topIndexJpanel2);
		topIndexJpanel2.setLayout(null);

		JLabel startTime = new JLabel();
		startTime.setText("��ʼʱ��:");
		startTime.setBounds(120, 10, 120, 22);
		startTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(startTime);// ��ʼʱ��

		JTextField inputStartTime = new JTextField();
		inputStartTime.setHorizontalAlignment(JTextField.CENTER);
		inputStartTime.setBounds(220, 10, 120, 25);
		inputStartTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(inputStartTime);

		JLabel endTime = new JLabel();
		endTime.setText("��ֹʱ��:");
		endTime.setBounds(350, 10, 120, 22);
		endTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(endTime);

		JTextField inputEndTime = new JTextField();
		inputEndTime.setHorizontalAlignment(JTextField.CENTER);
		inputEndTime.setBounds(450, 10, 120, 25);
		inputEndTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(inputEndTime);

		final JButton search2 = new JButton();
		search2.setText("��ѯ");
		search2.setBounds(580, 5, 70, 30);
		topIndexJpanel2.add(search2);// ��ѯ��ť
		// �ڶ��н���

		// ������
		JPanel topIndexJpanel3 = new JPanel();
		topJpanel.add(topIndexJpanel3);

		JLabel cautions = new JLabel();
		cautions.setText("ע��:ʱ���ʽΪYYYYMMDD,����:20150901");
		cautions.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel3.add(cautions);// ע��
		// �����н���
		/* ��ѯ���������� */

		/* ��֧��ϸ�� */
		// ����Ĵ��
		Border titleBorder2 = BorderFactory.createTitledBorder("��֧��ϸ��Ϣ");
		JPanel bottomJpanel = new JPanel();
		bottomJpanel.setBorder(titleBorder2);
		bottomJpanel.setLayout(null);
		bottomJpanel.setBounds(0, 205, 795, 490);
		getContentPane().add(bottomJpanel);
		// ����Ĵ��

		// ��������֧���
		JLabel sum = new JLabel();
		sum.setBounds(270, 20, 300, 20);
		sum.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		bottomJpanel.add(sum);
		// ��������֧������

		// ��֧��ϸ���
		// ��ű�����ݵĶ�ά����
		String columNames[] = { "���", "����", "����", "����", "���" };
		Object data[][] = new Object[50][5];
		// ��ű�����ݵĶ�ά����
		DefaultTableModel tableModel = new DefaultTableModel(data, columNames);
		JTable sumTable = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
		};
		sumTable.setBounds(5, 50, 785, 400);
		// �������ӵ����Թ�����Scroll��
		JScrollPane tableScroll = new JScrollPane(sumTable);
		tableScroll.setBounds(5, 50, 785, 400);
		bottomJpanel.add(tableScroll);
		// ��֧��ϸ������

		/* ��֧��ϸ������ */

		setVisible(true);// ��ʾ�������

		// ������ѯ�����¼�������/֧����
		search1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				try {
					Connection conn = DriverManager.getConnection(dataBase.URL, dataBase.USERNAME, dataBase.PASSWORD);
					java.sql.Statement statement = conn.createStatement();
					String select = "select *from IncomeAndSpending where rtype = '"
							+ selsectTypeOfIO.getSelectedItem().toString().trim() + "'";
					ResultSet rs = statement.executeQuery(select);
					tableModel.setRowCount(0);
					while (rs.next()) {
						String id = rs.getString(1);
						String date = rs.getString(2);
						String type = rs.getString(3);
						String item = rs.getString(4);
						int balance = rs.getInt(5);
						tableModel.addRow(new Object[] { id, date, type, item, balance });
					}
					rs.close();
					statement.close();
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		// ������ѯ�����¼�����

		// ʱ���ѯ�����¼�
		search2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				//if (inputEndTime.getText().substring(4, 6).trim().compareTo("12") > 0||inputEndTime.getText().substring(6, 8).trim().compareTo("31") > 0) {
				if(!isDate(inputStartTime.getText())||!isDate(inputEndTime.getText())){
					inputStartTime.setText("");
					inputEndTime.setText("");
					// ���������ʾ��
					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50, 50, 300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);

					JLabel errorText = new JLabel();
					errorText.setText("����ʱ������");
					errorText.setBounds(50, 40, 250, 25);
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
					// ���������ʾ��
				} else if (inputEndTime.getText().trim().compareTo(inputStartTime.getText().trim()) < 0) {
					inputStartTime.setText("");
					inputEndTime.setText("");
					// ���������ʾ��
					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50, 50, 300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);

					JLabel errorText = new JLabel();
					errorText.setText("��ʼ���ڴ�����ֹ����");
					errorText.setBounds(5, 40, 350, 25);
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
				} else {
					try {
						Connection conn = DriverManager.getConnection(dataBase.URL, dataBase.USERNAME,
								dataBase.PASSWORD);
						java.sql.Statement statement = conn.createStatement();
						String select = "select *from IncomeAndSpending where rdate >= "
								+ inputStartTime.getText().toString().trim() + " AND rdate <= "
								+ inputEndTime.getText().toString().trim() + "";
						ResultSet rs = statement.executeQuery(select);
						tableModel.setRowCount(0);
						while (rs.next()) {
							String id = rs.getString(1);
							String date = rs.getString(2);
							String type = rs.getString(3);
							String item = rs.getString(4);
							int balance = rs.getInt(5);
							// System.out.println(id + " " + date + " " + type +
							// " " + item + " " + balance);
							tableModel.addRow(new Object[] { id, date, type, item, balance });

						}
						rs.close();
						statement.close();
						conn.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
			}
		});

		// ��֧��������
		try {
			Connection conn = DriverManager.getConnection(dataBase.URL, dataBase.USERNAME, dataBase.PASSWORD);
			java.sql.Statement statement = conn.createStatement();
			String income = "select *from IncomeAndSpending where rtype = '����'";
			ResultSet rs1 = statement.executeQuery(income);
			while (rs1.next()) {
				int balance = rs1.getInt(5);
				dataBase.income += balance;
			}
			String outcome = "select *from IncomeAndSpending where rtype = '֧��'";
			ResultSet rs2 = statement.executeQuery(outcome);
			while (rs2.next()) {
				int balance = rs2.getInt(5);
				dataBase.outcome += balance;
			}
			dataBase.balance = dataBase.income - dataBase.outcome;
			rs2.close();
			rs1.close();
			statement.close();
			conn.close();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		sum.setText("��������֧���Ϊ" + dataBase.balance + "Ԫ");
		if(dataBase.balance<0){
			System.out.println("���ѽҲ�������������");
			JFrame info = new JFrame();
			info.setTitle("Infomation");
			info.setBounds(50, 50, 300, 200);
			info.setLocationRelativeTo(null);
			info.setVisible(true);
			info.setLayout(null);
			info.setAlwaysOnTop(true);

			JLabel errorText = new JLabel();
			errorText.setText("���ѽҲ�������������");
			errorText.setBounds(50, 40, 350, 25);
			errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
			info.add(errorText);

			JButton ok = new JButton();
			ok.setText("ȷ��");
			ok.setBounds(100, 90, 80, 40);
			ok.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
			ok.setContentAreaFilled(false);
			info.add(ok);

			ok.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					info.dispose();
				}
			});
		}
		// ��֧�����������
	}

}
