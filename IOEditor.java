package com.moneymanager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

public class IOEditor extends JFrame {

	static boolean isDate(String date) {
		if (date.length() != 8)
			return false;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		try {
			format.setLenient(false);
			format.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	static int isMoneyTrue(JTextField text) {
		if (text.getText().trim().compareTo("0") < 0) {
			JFrame error = new JFrame();
			error.setTitle("Error");
			error.setBounds(50, 50, 300, 200);
			error.setLocationRelativeTo(null);
			error.setVisible(true);
			error.setLayout(null);

			JLabel errorText = new JLabel();
			errorText.setText("输入金额小于0");
			errorText.setBounds(55, 40, 250, 25);
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
			return 0;
		} else
			return 1;
	}

	static int isTimeTrue(JTextField time) {
		if (!isDate(time.getText())) {
			JFrame error = new JFrame();
			error.setTitle("Error");
			error.setBounds(50, 50, 300, 200);
			error.setLocationRelativeTo(null);
			error.setVisible(true);
			error.setLayout(null);

			JLabel errorText = new JLabel();
			errorText.setText("输入时间有误");
			errorText.setBounds(65, 40, 250, 25);
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
			return 0;
		}else 
			return 1;
	}

	public IOEditor(DataBase dataBase) {
		//界面区
		setTitle("收支编辑");// 窗口标题
		setSize(900, 430);// 设置窗口宽度和高度
		setLocationRelativeTo(null);// 设置窗口居中
		getContentPane().setLayout(null);// Layout为空
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// 可关闭的窗口

		JMenuBar topMenuBar = new JMenuBar();// 主菜单栏，用来装主菜单（MenuBar）
		setJMenuBar(topMenuBar);// 将主菜单栏显示
		JMenu menu = new JMenu("菜单");// 主菜单1名称
		topMenuBar.add(menu);// 将主菜单1添加到MenuBar中去
		JMenuItem back = new JMenuItem("返回前页");// 下拉子菜单1
		menu.add(back);// 将下拉子菜单1显示出来

		// 编辑收支信息
		Border leftTitleBorder = BorderFactory.createTitledBorder("编辑收支信息");
		JPanel leftJpanel = new JPanel();
		leftJpanel.setBorder(leftTitleBorder);
		leftJpanel.setBounds(0, 0, 230, 355);
		getContentPane().add(leftJpanel);
		GridLayout gridLayout1 = new GridLayout(5, 2);
		gridLayout1.setVgap(5);
		leftJpanel.setLayout(gridLayout1);

		JLabel number = new JLabel();
		number.setText("编号：");
		number.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(number);

		JTextField numberInput = new JTextField();
		numberInput.setHorizontalAlignment(JTextField.CENTER);
		numberInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(numberInput);

		JLabel data = new JLabel();
		data.setText("日期:");
		data.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(data);

		JTextField dateInput = new JTextField();
		dateInput.setHorizontalAlignment(JTextField.CENTER);
		dateInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(dateInput);

		JLabel type = new JLabel();
		type.setText("类型:");
		type.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(type);

		String[] typechoice = { "收入", "支出" };
		JComboBox<String> selsectTypeOfIO = new JComboBox<String>(typechoice);
		selsectTypeOfIO.setEditable(true);
		selsectTypeOfIO.setMaximumRowCount(2);
		selsectTypeOfIO.setSelectedItem("收入");
		selsectTypeOfIO.setEditable(false);
		leftJpanel.add(selsectTypeOfIO);

		JLabel content = new JLabel();
		content.setText("内容:");
		content.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(content);

		String[] contentchoice = { "购物", "餐饮", "居家", "交通", "娱乐", "人情", "工资", "奖金", "其他" };
		JComboBox<String> contentChoice = new JComboBox<String>(contentchoice);
		contentChoice.setEditable(true);
		contentChoice.setMaximumRowCount(4);
		contentChoice.setSelectedItem("购物");
		contentChoice.setEditable(false);
		leftJpanel.add(contentChoice);

		JLabel money = new JLabel();
		money.setText("金额:");
		money.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(money);

		JTextField moneyInput = new JTextField();
		moneyInput.setHorizontalAlignment(JTextField.CENTER);
		moneyInput.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		leftJpanel.add(moneyInput);
		// 编辑收支信息

		// 中间的五个Button
		JButton insert = new JButton();
		insert.setText("录入");
		insert.setBounds(235, 10, 120, 60);
		insert.setContentAreaFilled(false);
		getContentPane().add(insert);

		JButton change = new JButton();
		change.setText("修改");
		change.setBounds(235, 80, 120, 60);
		change.setContentAreaFilled(false);
		getContentPane().add(change);

		JButton delete = new JButton();
		delete.setText("删除");
		delete.setBounds(235, 150, 120, 60);
		delete.setContentAreaFilled(false);
		getContentPane().add(delete);

		JButton search = new JButton();
		search.setText("查询");
		search.setBounds(235, 220, 120, 60);
		search.setContentAreaFilled(false);
		getContentPane().add(search);

		JButton clear = new JButton();
		clear.setText("清空");
		clear.setBounds(235, 290, 120, 60);
		clear.setContentAreaFilled(false);
		getContentPane().add(clear);
		// 中间的五个Button

		// 右边的收支信息
		Border rightTitleBorder = BorderFactory.createTitledBorder("显示收支信息");
		JPanel rightJpanel = new JPanel();
		rightJpanel.setBorder(rightTitleBorder);
		rightJpanel.setBounds(360, 0, 520, 355);
		rightJpanel.setLayout(null);
		getContentPane().add(rightJpanel);

		String columNames[] = { "编号", "日期", "类型", "内容", "金额" };
		Object data1[][] = new Object[50][5];
		DefaultTableModel tableModel = new DefaultTableModel(data1, columNames);
		JTable sumTable = new JTable(tableModel) {
			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				return false;
			}
		};
		sumTable.setBounds(5, 50, 785, 400);
		// 将表格添加到可以滚动的Scroll中
		JScrollPane tableScroll = new JScrollPane(sumTable);
		tableScroll.setBounds(5, 20, 510, 400);
		rightJpanel.add(tableScroll);
		// 右边的收支信息
		//界面区
		
		//功能区
		search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(dataBase.URL, dataBase.USERNAME, dataBase.PASSWORD);
					java.sql.Statement statement = conn.createStatement();
					String select = "select *from IncomeAndSpending where uid = '"+dataBase.userName+"'";
					ResultSet rs = statement.executeQuery(select);
					tableModel.setRowCount(0);
					while (rs.next()) {
						String id = rs.getString("id");
						String date = rs.getString("rdate");
						String type = rs.getString("rtype");
						String item = rs.getString("ritem");
						int balance = rs.getInt("bal");
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

		insert.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Connection conn = DriverManager.getConnection(dataBase.URL, dataBase.USERNAME, dataBase.PASSWORD);
					java.sql.Statement statement = conn.createStatement();
					String select = "select id from IncomeAndSpending where uid = '"+dataBase.userName+"'";
					ResultSet rSet = statement.executeQuery(select);
					int i = 0, flag1 = 0, flag2 = 0;
					while (rSet.next()) {
						if (numberInput.getText().equals(rSet.getString("id"))) {
							// 输入错误提示框
							JFrame error = new JFrame();
							error.setTitle("Error");
							error.setBounds(50, 50, 300, 200);
							error.setLocationRelativeTo(null);
							error.setVisible(true);
							error.setLayout(null);

							JLabel errorText = new JLabel();
							errorText.setText("编号重复");
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
							// 输入错误提示框
							numberInput.setText("");
							i++;
						}
					}
					if (i == 0 && ((flag1 = isMoneyTrue(moneyInput)) == 1) && ((flag2 = isTimeTrue(dateInput)) == 1)) {
						String insert = "insert into IncomeAndSpending values("
								+ numberInput.getText().toString().trim() + ",'" + dataBase.userName +"'," +dateInput.getText().toString().trim()
								+ ",'" + selsectTypeOfIO.getSelectedItem().toString().trim() + "','"
								+ contentChoice.getSelectedItem().toString().trim() + "',"
								+ Integer.valueOf(moneyInput.getText()) + ")";
						statement.executeUpdate(insert);
						JFrame success = new JFrame();
						success.setTitle("Success");
						success.setBounds(50, 50, 300, 200);
						success.setLocationRelativeTo(null);
						success.setVisible(true);
						success.setLayout(null);

						JLabel errorText = new JLabel();
						errorText.setText("录入成功");
						errorText.setBounds(85, 40, 350, 25);
						errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
						success.add(errorText);

						JButton ok = new JButton();
						ok.setText("确定");
						ok.setBounds(100, 90, 80, 40);
						ok.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
						ok.setContentAreaFilled(false);
						success.add(ok);

						ok.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								success.dispose();
							}
						});
						rSet.close();
					}
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		});

		clear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				numberInput.setEditable(true);
				numberInput.setText("");
				dateInput.setText("");
				moneyInput.setText("");
			}
		});

		sumTable.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				
			}

			@Override
			public void focusGained(FocusEvent e) {
				int selectedRow = sumTable.getSelectedRow();
				numberInput.setEditable(false);
				numberInput.setText(sumTable.getValueAt(selectedRow, 0).toString());
				dateInput.setText(sumTable.getValueAt(selectedRow, 1).toString());
				selsectTypeOfIO.setSelectedItem(sumTable.getValueAt(selectedRow, 2));
				contentChoice.setSelectedItem(sumTable.getValueAt(selectedRow, 3));
				moneyInput.setText(sumTable.getValueAt(selectedRow, 4).toString());
			}
		});

		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				JFrame error = new JFrame();
				error.setTitle("Confirm");
				error.setBounds(50, 50, 300, 200);
				error.setLocationRelativeTo(null);
				error.setVisible(true);
				error.setLayout(null);

				JLabel errorText = new JLabel();
				errorText.setText("确认删除？");
				errorText.setBounds(85, 40, 350, 25);
				errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
				error.add(errorText);

				JButton confirm = new JButton();
				confirm.setText("确定");
				confirm.setBounds(45, 90, 80, 40);
				confirm.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
				confirm.setContentAreaFilled(false);
				error.add(confirm);

				JButton cancel = new JButton();
				cancel.setText("取消");
				cancel.setBounds(170, 90, 80, 40);
				cancel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
				cancel.setContentAreaFilled(false);
				error.add(cancel);

				confirm.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent arg0) {
						int selectedRow = sumTable.getSelectedRow();
						try {
							Connection connection = DriverManager.getConnection(dataBase.URL, dataBase.USERNAME,
									dataBase.PASSWORD);
							Statement statement = connection.createStatement();
							String delete = "delete from IncomeAndSpending where id = "
									+ sumTable.getValueAt(selectedRow, 0).toString() + " AND uid = '"+dataBase.userName+"'";
							statement.executeUpdate(delete);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}

						JFrame success = new JFrame();
						success.setTitle("Success");
						success.setBounds(50, 50, 300, 200);
						success.setLocationRelativeTo(null);
						success.setVisible(true);
						success.setLayout(null);

						JLabel errorText = new JLabel();
						errorText.setText("删除成功");
						errorText.setBounds(85, 40, 350, 25);
						errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
						success.add(errorText);

						JButton ok = new JButton();
						ok.setText("确定");
						ok.setBounds(100, 90, 80, 40);
						ok.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
						ok.setContentAreaFilled(false);
						success.add(ok);

						ok.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent arg0) {
								success.dispose();
							}
						});
						error.dispose();
					}
				});

				cancel.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent arg0) {
						error.dispose();
					}
				});
			}
		});

		change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int flag1 = 0,flag2=0;
				if (((flag1 = isMoneyTrue(moneyInput)) == 1) && ((flag2 = isTimeTrue(dateInput)) == 1)) {
					JFrame error = new JFrame();
					error.setTitle("Confirm");
					error.setBounds(50, 50, 300, 200);
					error.setLocationRelativeTo(null);
					error.setVisible(true);
					error.setLayout(null);

					JLabel errorText = new JLabel();
					errorText.setText("确认修改？");
					errorText.setBounds(85, 40, 350, 25);
					errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
					error.add(errorText);

					JButton confirm = new JButton();
					confirm.setText("确定");
					confirm.setBounds(45, 90, 80, 40);
					confirm.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
					confirm.setContentAreaFilled(false);
					error.add(confirm);

					JButton cancel = new JButton();
					cancel.setText("取消");
					cancel.setBounds(170, 90, 80, 40);
					cancel.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
					cancel.setContentAreaFilled(false);
					error.add(cancel);

					confirm.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							int selectedRow = sumTable.getSelectedRow();
							try {
								Connection connection = DriverManager.getConnection(dataBase.URL, dataBase.USERNAME,
										dataBase.PASSWORD);
								Statement statement = connection.createStatement();
								String change = "update IncomeAndSpending set rdate = " + dateInput.getText()
										+ ",rtype = '" + selsectTypeOfIO.getSelectedItem().toString().trim()
										+ "',ritem = '" + contentChoice.getSelectedItem().toString().trim() + "',bal = "
										+ Integer.valueOf(moneyInput.getText()) + " where id= "
										+ sumTable.getValueAt(selectedRow, 0) + " AND uid = '"+dataBase.userName+"' ";
								statement.executeUpdate(change);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}

							JFrame success = new JFrame();
							success.setTitle("Success");
							success.setBounds(50, 50, 300, 200);
							success.setLocationRelativeTo(null);
							success.setVisible(true);
							success.setLayout(null);

							JLabel errorText = new JLabel();
							errorText.setText("修改成功");
							errorText.setBounds(85, 40, 350, 25);
							errorText.setFont(new Font(Font.DIALOG, Font.BOLD, 25));
							success.add(errorText);

							JButton ok = new JButton();
							ok.setText("确定");
							ok.setBounds(100, 90, 80, 40);
							ok.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
							ok.setContentAreaFilled(false);
							success.add(ok);

							ok.addActionListener(new ActionListener() {
								@Override
								public void actionPerformed(ActionEvent arg0) {
									success.dispose();
								}
							});
							error.dispose();
						}
					});

					cancel.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent arg0) {
							error.dispose();
						}
					});
				}
			}
		});

		back.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dataBase.balance = 0;
				dataBase.income = 0;
				dataBase.outcome = 0;// 返回之前将数据清空
				MainMenu mainMenu = new MainMenu(dataBase);
				mainMenu.setVisible(true);
				dispose();
			}
		});
		//功能区
	}
}
