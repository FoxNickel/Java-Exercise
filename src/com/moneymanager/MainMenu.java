/**
 * 
 */
package com.moneymanager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.nio.channels.SelectableChannel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.text.FieldView;
import javax.xml.bind.JAXBContext;

public class MainMenu extends JFrame {

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
				IOEditor iOEditor = new IOEditor();
				iOEditor.setVisible(true);
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

		// selsectTypeOfIO.addItemListener(new ItemListener() {
		// @Override
		// public void itemStateChanged(ItemEvent e) {
		// // TODO �Զ����ɵķ������
		// ItemSelectable is = e.getItemSelectable();
		// if(is.getSelectedObjects()[0].toString().equals("����")){
		// System.out.println("��ѡ��������");
		// }else if (is.getSelectedObjects()[0].toString().equals("֧��")) {
		// System.out.println("��ѡ����֧��");
		// }
		// //����getItemSelectable()�������һ���Ƿ�ѡ�е�ItemSelectable����
		// //���øö����getSelectedObjects()�������һ��ѡ�ж������飬�������һ��Ԫ�ؼ�Ϊѡ�е�Item
		// }
		// });
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
		sum.setText("��������֧���Ϊ5000Ԫ");
		sum.setBounds(270, 20, 250, 20);
		sum.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		bottomJpanel.add(sum);
		// ��������֧������

		// ��֧��ϸ���
		// ��ű�����ݵĶ�ά����
		String columNames[] = { "���", "����", "����", "����", "���" };
		Object data[][] = new Object[50][5];
		// ��ű�����ݵĶ�ά����
		DefaultTableModel tableModel = new DefaultTableModel(data, columNames);
		JTable sumTable = new JTable(tableModel);
		sumTable.setBounds(5, 50, 785, 400);
		//sumTable.setModel(new DefaultTableModel(data,columNames));
		// �������ӵ����Թ�����Scroll��
		JScrollPane tableScroll = new JScrollPane(sumTable);
		tableScroll.setBounds(5, 50, 785, 400);
		bottomJpanel.add(tableScroll);
		// ��֧��ϸ������

		/* ��֧��ϸ������ */

		setVisible(true);// ��ʾ�������

		search1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				try {
					Connection conn = DriverManager.getConnection(dataBase.URL, dataBase.USERNAME, dataBase.PASSWORD);
					java.sql.Statement statement = conn.createStatement();
					String select = "select *from IncomeAndSpending where rtype = '"+ selsectTypeOfIO.getSelectedItem().toString().trim()+"'";
					ResultSet rs = statement.executeQuery(select);
					tableModel.setRowCount(0);
					while (rs.next()) {
						String id = rs.getString(1);
						String date = rs.getString(2);
						String type = rs.getString(3);
						String item = rs.getString(4);
						int balance = rs.getInt(5);
						System.out.println(id + " " + date + " " + type + " " + item + " " + balance);
						tableModel.addRow(new Object[] {id,date,type,item,balance});
					}
					rs.close();
					conn.close();
					statement.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});
		// ����ѡ������¼�������/֧����
		// System.out.println(selsectTypeOfIO.getSelectedItem());// ��֮ǰ��ѡ��״̬
		// ��֮���ѡ��״̬
//		selsectTypeOfIO.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO �Զ����ɵķ������
//				if (((JComboBox) e.getSource()).getSelectedItem().equals("����")) {
//					System.out.println("��ѡ��������");
//					search1.addActionListener(new ActionListener() {
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							// TODO �Զ����ɵķ������
//							try {
//								Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//								java.sql.Statement statement = conn.createStatement();
//								String select = "select *from IncomeAndSpending where rtype = '����'";
//								ResultSet rs = statement.executeQuery(select);
//								int i = 0;
//								tableModel.setRowCount(0);
//								while (rs.next()) {
//									String id = rs.getString(1);
//									String date = rs.getString(2);
//									String type = rs.getString(3);
//									String item = rs.getString(4);
//									int balance = rs.getInt(5);
//									System.out.println(id + " " + date + " " + type + " " + item + " " + balance);
////									sumTable.setValueAt(id, i, 0);
////									sumTable.setValueAt(date, i, 1);
////									sumTable.setValueAt(type, i, 2);
////									sumTable.setValueAt(item, i, 3);
////									sumTable.setValueAt(balance, i, 4);
//									tableModel.addRow(new Object[] {id,date,type,item,balance});
//									i++;
//								}
//								rs.close();
//								conn.close();
//								statement.close();
//							} catch (SQLException ex) {
//								ex.printStackTrace();
//							}
//						}
//					});
//				} else if (((JComboBox) e.getSource()).getSelectedItem().equals("֧��")) {
//					System.out.println("��ѡ����֧��");
//					search1.addActionListener(new ActionListener() {
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							// TODO �Զ����ɵķ������
//							try {
//								Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
//								java.sql.Statement statement = conn.createStatement();
//								String select = "select *from IncomeAndSpending where rtype = '֧��'";
//								ResultSet rs = statement.executeQuery(select);
//								int i = 0;
//								tableModel.setRowCount(0);
//								while (rs.next()) {
//									String id = rs.getString(1);
//									String date = rs.getString(2);
//									String type = rs.getString(3);
//									String item = rs.getString(4);
//									int balance = rs.getInt(5);
//									System.out.println(id + " " + date + " " + type + " " + item + " " + balance);
////									sumTable.setValueAt(id, i, 0);
////									sumTable.setValueAt(date, i, 1);
////									sumTable.setValueAt(type, i, 2);
////									sumTable.setValueAt(item, i, 3);
////									sumTable.setValueAt(balance, i, 4);
//									tableModel.addRow(new Object[] {id,date,type,item,balance});
//									i++;
//								}
//								rs.close();
//								conn.close();
//								statement.close();
//							} catch (SQLException ex) {
//								ex.printStackTrace();
//							}
//						}
//					});
//				}
//			}
//		});
		// ��֮���ѡ��״̬
		// ����ѡ������¼�����

	}

}
