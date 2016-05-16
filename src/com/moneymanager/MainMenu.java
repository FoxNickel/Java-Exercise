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

		/* 主窗口 */
		setTitle("欢迎使用个人理财账本");// 窗口标题
		setSize(800, 750);// 设置窗口宽度和高度
		setLocationRelativeTo(null);// 设置窗口居中
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);// 窗口大小不可变
		getContentPane().setLayout(null);// 设置为null后才能设置大小
		/* 主窗口结束 */

		/* 菜单栏 */
		JMenuBar topMenuBar = new JMenuBar();// 主菜单栏，用来装主菜单（MenuBar）
		setJMenuBar(topMenuBar);// 将主菜单栏显示
		JMenu systemManage = new JMenu("系统管理");// 主菜单1名称
		topMenuBar.add(systemManage);// 将主菜单1添加到MenuBar中去
		JMenuItem resetPassWord = new JMenuItem("密码重置");// 下拉子菜单1
		JMenuItem exit = new JMenuItem("退出系统");// 下拉子菜单2
		systemManage.add(resetPassWord);// 将下拉子菜单1显示出来
		systemManage.addSeparator();// 分隔符
		systemManage.add(exit);// 将下拉子菜单2显示出来
		// 密码重置按钮的点击事件
		resetPassWord.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				changePassWord changePass = new changePassWord(dataBase, MainMenu.this);
				changePass.setVisible(true);
			}
		});
		// 密码重置按钮的点击事件
		// 退出系统按钮的点击事件
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		// 退出系统按钮的点击事件
		JMenu ioManage = new JMenu("收支管理");// 主菜单2名称
		topMenuBar.add(ioManage);// 将主菜单2添加到MenuBar中去
		JMenuItem editIO = new JMenuItem("收支编辑");// 下拉子菜单
		ioManage.add(editIO);// 显示下拉子菜单
		// 收支编辑按钮的点击事件
		editIO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				IOEditor iOEditor = new IOEditor(dataBase);
				iOEditor.setVisible(true);
				dispose();
			}
		});
		// 收支编辑按钮的点击事件
		/* 菜单栏结束 */

		/* 查询条件栏 */
		// 上面的外大框
		Border titleBorder1 = BorderFactory.createTitledBorder("输入查询条件");
		JPanel topJpanel = new JPanel();
		topJpanel.setBorder(titleBorder1);
		topJpanel.setBounds(0, 0, 795, 200);
		getContentPane().add(topJpanel);
		// 上面的外大框

		GridLayout gridLayout2 = new GridLayout(3, 1);
		gridLayout2.setVgap(5);
		topJpanel.setLayout(gridLayout2);// 使topJpanel一分为三

		// 第一行
		JPanel topIndexJpanel1 = new JPanel();
		topJpanel.add(topIndexJpanel1);

		JLabel typeOfIO = new JLabel();
		typeOfIO.setText("收支类型:");
		typeOfIO.setSize(80, 20);
		typeOfIO.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel1.add(typeOfIO);// 收支类型

		String[] type = { "收入", "支出" };
		JComboBox<String> selsectTypeOfIO = new JComboBox<String>(type);
		selsectTypeOfIO.setMaximumRowCount(2);
		selsectTypeOfIO.setSelectedItem("收入");
		selsectTypeOfIO.setEditable(false);
		topIndexJpanel1.add(selsectTypeOfIO);// 选择收支类型的框

		JButton search1 = new JButton();
		search1.setText("查询");
		topIndexJpanel1.add(search1);// 查询按钮
		// 第一行结束

		// 第二行
		JPanel topIndexJpanel2 = new JPanel();
		topJpanel.add(topIndexJpanel2);
		topIndexJpanel2.setLayout(null);

		JLabel startTime = new JLabel();
		startTime.setText("起始时间:");
		startTime.setBounds(120, 10, 120, 22);
		startTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(startTime);// 起始时间

		JTextField inputStartTime = new JTextField();
		inputStartTime.setHorizontalAlignment(JTextField.CENTER);
		inputStartTime.setBounds(220, 10, 120, 25);
		inputStartTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(inputStartTime);

		JLabel endTime = new JLabel();
		endTime.setText("终止时间:");
		endTime.setBounds(350, 10, 120, 22);
		endTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(endTime);

		JTextField inputEndTime = new JTextField();
		inputEndTime.setHorizontalAlignment(JTextField.CENTER);
		inputEndTime.setBounds(450, 10, 120, 25);
		inputEndTime.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel2.add(inputEndTime);

		final JButton search2 = new JButton();
		search2.setText("查询");
		search2.setBounds(580, 5, 70, 30);
		topIndexJpanel2.add(search2);// 查询按钮
		// 第二行结束

		// 第三行
		JPanel topIndexJpanel3 = new JPanel();
		topJpanel.add(topIndexJpanel3);

		JLabel cautions = new JLabel();
		cautions.setText("注意:时间格式为YYYYMMDD,例如:20150901");
		cautions.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		topIndexJpanel3.add(cautions);// 注意
		// 第三行结束
		/* 查询条件栏结束 */

		/* 收支明细栏 */
		// 下面的大框
		Border titleBorder2 = BorderFactory.createTitledBorder("收支明细信息");
		JPanel bottomJpanel = new JPanel();
		bottomJpanel.setBorder(titleBorder2);
		bottomJpanel.setLayout(null);
		bottomJpanel.setBounds(0, 205, 795, 490);
		getContentPane().add(bottomJpanel);
		// 下面的大框

		// 个人总收支余额
		JLabel sum = new JLabel();
		sum.setBounds(270, 20, 300, 20);
		sum.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		bottomJpanel.add(sum);
		// 个人总收支余额结束

		// 收支明细表格
		// 存放表格数据的二维数组
		String columNames[] = { "编号", "日期", "类型", "内容", "金额" };
		Object data[][] = new Object[50][5];
		// 存放表格数据的二维数组
		DefaultTableModel tableModel = new DefaultTableModel(data, columNames);
		JTable sumTable = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
		};
		sumTable.setBounds(5, 50, 785, 400);
		// 将表格添加到可以滚动的Scroll中
		JScrollPane tableScroll = new JScrollPane(sumTable);
		tableScroll.setBounds(5, 50, 785, 400);
		bottomJpanel.add(tableScroll);
		// 收支明细表格结束

		/* 收支明细栏结束 */

		setVisible(true);// 显示所有组件

		// 条件查询监听事件（收入/支出）
		search1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
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
		// 条件查询监听事件结束

		// 时间查询监听事件
		search2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				//if (inputEndTime.getText().substring(4, 6).trim().compareTo("12") > 0||inputEndTime.getText().substring(6, 8).trim().compareTo("31") > 0) {
				if(!isDate(inputStartTime.getText())||!isDate(inputEndTime.getText())){
					inputStartTime.setText("");
					inputEndTime.setText("");
					// 输入错误提示框
					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50, 50, 300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);

					JLabel errorText = new JLabel();
					errorText.setText("输入时间有误");
					errorText.setBounds(50, 40, 250, 25);
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
					// 输入错误提示框
				} else if (inputEndTime.getText().trim().compareTo(inputStartTime.getText().trim()) < 0) {
					inputStartTime.setText("");
					inputEndTime.setText("");
					// 输入错误提示框
					JFrame error = new JFrame();
					error.setTitle("Error");
					error.setBounds(50, 50, 300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);

					JLabel errorText = new JLabel();
					errorText.setText("起始日期大于终止日期");
					errorText.setBounds(5, 40, 350, 25);
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

		// 收支总余额计算
		try {
			Connection conn = DriverManager.getConnection(dataBase.URL, dataBase.USERNAME, dataBase.PASSWORD);
			java.sql.Statement statement = conn.createStatement();
			String income = "select *from IncomeAndSpending where rtype = '收入'";
			ResultSet rs1 = statement.executeQuery(income);
			while (rs1.next()) {
				int balance = rs1.getInt(5);
				dataBase.income += balance;
			}
			String outcome = "select *from IncomeAndSpending where rtype = '支出'";
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
		sum.setText("个人总收支余额为" + dataBase.balance + "元");
		if(dataBase.balance<0){
			System.out.println("您已揭不开锅啦！！！");
			JFrame info = new JFrame();
			info.setTitle("Infomation");
			info.setBounds(50, 50, 300, 200);
			info.setLocationRelativeTo(null);
			info.setVisible(true);
			info.setLayout(null);
			info.setAlwaysOnTop(true);

			JLabel errorText = new JLabel();
			errorText.setText("您已揭不开锅啦！！！");
			errorText.setBounds(50, 40, 350, 25);
			errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
			info.add(errorText);

			JButton ok = new JButton();
			ok.setText("确定");
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
		// 收支总余额计算结束
	}

}
