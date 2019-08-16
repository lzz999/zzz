package com.java.ls1;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PayRecord extends JFrame {
	Service s = new Service();
	private JTable table;

	private DefaultTableModel dtm = new DefaultTableModel();
	private Record r = new Record();

	public PayRecord() {
		setSize(500, 500);
		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		final JButton button = new JButton();
		// 查
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int rowCount = dtm.getRowCount();
				for (int i = 0; i < rowCount; i++) {
					dtm.removeRow(0);
				}
				try {
					ArrayList<Record> list = s.queryByName(dtm);
					for (Record record : list) {
						String paymentTime = new SimpleDateFormat("yyyy-MM-dd")
								.format(record.getPaymentTime());
						dtm.addRow(new Object[] { record.getSerialNumber(),
								record.getPattern(), record.getAmount(),
								paymentTime, record.getState(),
								record.getPayee(), record.getRecord_id() });
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		button.setText("查询");
		panel.add(button);
		final JButton button_1 = new JButton();
		// 修改
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				int no = table.getSelectedRowCount();
				if (no > 1) {
					// 一次只能修改一行
					JOptionPane.showMessageDialog(null, "一次只能修改一行");
				} else if (no == 0) {
					// 请选择要修改的行
					JOptionPane.showMessageDialog(null, "请选择要修改的行");
				} else {
					// 确定要修改吗
					int confirmNo = JOptionPane.showConfirmDialog(null,
							"确定要修改吗?");
					// System.out.println(confirmNo+"....");
					if (confirmNo == 0) {
						// 真改;
						int rowNo = table.getSelectedRow();// 获取行的索引
						// System.out.println(rowNo);
						Modify m = new Modify(dtm, rowNo, r, s);
						m.setVisible(true);
					}
				}
			}
		});
		button_1.setText("修改");
		panel.add(button_1);

		final JButton button_2 = new JButton();
		// 删除
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int no = table.getSelectedRowCount();
				if (no > 1) {
					// 一次只能删一行
					JOptionPane.showMessageDialog(null, "一次只能删一行");
				} else if (no == 0) {
					// 请选择要删除的行
					JOptionPane.showMessageDialog(null, "请选择要删除的行");
				} else {
					// 删
					int confirmNo = JOptionPane.showConfirmDialog(null,
							"确定要删除吗?");
					// System.out.println(confirmNo+"....");
					if (confirmNo == 0) {
						// 真删
						int rowNo = table.getSelectedRow();// 获取行的索引
						// System.out.println(rowNo);

						int id = (int) dtm.getValueAt(rowNo, 6);
						dtm.removeRow(rowNo);
						r.setRecord_id(id);
						int no1 = s.delete(r.getRecord_id());
						if (no1 != 0) {
							JOptionPane.showMessageDialog(null, "删除成功");
						} else {
							JOptionPane.showMessageDialog(null, "删除失败");
						}
					}

				}
			}
		});
		button_2.setText("删除");
		panel.add(button_2);

		JButton button_3 = new JButton("\u589E\u52A0");
		// 增加
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//
				Increase increase = new Increase(dtm, s);
				increase.setVisible(true);
			}
		});
		button_3.setActionCommand("\u589E\u52A0");
		panel.add(button_3);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		dtm.addColumn("项目编号");
		dtm.addColumn("付款方式");
		dtm.addColumn("付款金额");
		dtm.addColumn("付款时间");
		dtm.addColumn("发票状态");
		dtm.addColumn("收款人");
		dtm.addColumn("编号");

	}

	public static void main(String[] args) {
		new PayRecord().setVisible(true);

	}
}
