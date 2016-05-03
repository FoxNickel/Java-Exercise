/**
 * 
 */
package com.moneymanager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.table.TableModel;
import javax.swing.text.FieldView;
import javax.xml.bind.JAXBContext;

public class MainMenu extends JFrame {

	public MainMenu() {
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
				changePassWord changePass = new changePassWord();
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
				IOEditor iOEditor= new IOEditor();
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
		selsectTypeOfIO.setEditable(true);
		selsectTypeOfIO.setMaximumRowCount(2);
		selsectTypeOfIO.setSelectedItem("����");
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
		sum.setText("��������֧���Ϊ5000Ԫ");
		sum.setBounds(270, 20, 250, 20);
		sum.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
		bottomJpanel.add(sum);
		// ��������֧������

		// ��֧��ϸ���
		String columNames[] = { "���", "����", "����", "����", "���" };
		Object data[][] = new Object[50][5];
		JTable sumTable = new JTable(data, columNames);
		sumTable.setBounds(5, 50, 785, 400);
		// �������ӵ����Թ�����Scroll��
		JScrollPane tableScroll = new JScrollPane(sumTable);
		tableScroll.setBounds(5, 50, 785, 400);
		bottomJpanel.add(tableScroll);
		// ��֧��ϸ������

		/* ��֧��ϸ������ */

		setVisible(true);// ��ʾ�������
	}

	public static void main(String[] args) {
		MainMenu mainMenu = new MainMenu();
	}

}
