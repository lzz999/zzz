package com.oracle.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;


import com.oracle.bill.SBill;
import com.oracle.service.BillSearch;

public class ShowBillView extends JFrame {
	private JEditorPane stopField;
	private JEditorPane startField;
	private JTable table;
	private JEditorPane pName;

	public ShowBillView() throws SQLException, ParseException {
		super();
		setBounds(new Rectangle(0, 0, 1300, 1000));
		setSize(1300, 696);
		setResizable(false);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		DefaultTableModel tm = new DefaultTableModel();

		final JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1300, 35);
		getContentPane().add(panel);

		final JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 54, 1300, 35);
		getContentPane().add(panel_2);

		final JLabel startLabel = new JLabel();
		startLabel.setText("��ʼ����");
		panel_2.add(startLabel);

		startField = new JEditorPane();
		startField.setEditable(false);
		panel_2.add(startField);

		final JLabel stopLabel = new JLabel();
		stopLabel.setText("��������");
		panel_2.add(stopLabel);

		stopField = new JEditorPane();
		panel_2.add(stopField);

		final JButton elect_item_btn = new JButton();
		elect_item_btn.setText("ѡ����Ŀ");
		panel.add(elect_item_btn);

		final JButton show_btn = new JButton();
		show_btn.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {

				int sum = tm.getRowCount();
				for (int i = 0; i < sum; i++) {
					tm.removeRow(0);
				}
				int num = 1;
				String stopDate = stopField.getText();
				BillSearch bs = new BillSearch();
				// ����
				TreeSet<SBill> set = new TreeSet<SBill>();
				try {
					set = bs.search(num, stopDate);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
				ArrayList<SBill> arr = null;
				try {
					arr = bs.sumBill(num, stopDate);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				double leftSum = 0, leftMon = 0;
				for (SBill b : arr) {
					tm.addRow(new Object[] { b.getMonth(), b.getgName(),
							b.getType(), b.getNuit(), b.getAmount(),
							sm.format(b.getInitialDate()),
							sm.format(b.getFinisDate()), b.getDaySum(),
							b.getRent(), b.getMoney(), b.getReMark() });
					leftSum += b.getAmount();
					leftMon += b.getMoney();
				}

				for (SBill s : set) {
					tm.addRow(new Object[] { sm.format(s.getInitialDate()),
							s.getgName(), s.getType(), s.getNuit(),
							s.getAmount(), sm.format(s.getInitialDate()),
							sm.format(s.getFinisDate()), s.getDaySum(),
							s.getRent(), s.getMoney(), s.getReMark() });
					leftMon += s.getMoney();
				}

				tm.addRow(new Object[] { "����ܼƣ�", null, null, null, null, null,
						null, null, null, leftMon });
			}
		});

		show_btn.setText("�鿴ԭ����");
		panel.add(show_btn);

		final JButton pay_btn = new JButton();
		pay_btn.setText("���Ѽ�¼");
		panel.add(pay_btn);

		final JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 101, 1300, 35);
		getContentPane().add(panel_1);

		pName = new JEditorPane();
		pName.setEditable(false);
		panel_1.add(pName);
		pName.setSize(100, 100);

		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 151, 1300, 500);
		getContentPane().add(scrollPane);

		table = new JTable();

		table.setModel(tm);
		tm.addColumn("����");
		tm.addColumn("Ʒ��");
		tm.addColumn("���");
		tm.addColumn("��λ");
		tm.addColumn("����");
		tm.addColumn("��������");
		tm.addColumn("ֹ������");
		tm.addColumn("����");
		tm.addColumn("����");
		tm.addColumn("���");
		tm.addColumn("��ע");
		scrollPane.setViewportView(table);

		// ��ʾ
		int num = 1;
		BillSearch bs = new BillSearch();
		String[] msg = null;

		msg = bs.showMsg(num);

		startField.setText(msg[0]);
		pName.setText(msg[1]);

	}

}
