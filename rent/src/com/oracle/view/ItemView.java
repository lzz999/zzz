package com.oracle.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.oracle.entity.Item;
import com.oracle.service.ItemService;

public class ItemView extends JFrame {
	DefaultTableModel tm = new DefaultTableModel();
	private JTable table = new JTable();

	public ItemView() {
		super();
		setResizable(false);
		setSize(600, 600);
		setTitle("项目表");

		final JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		final JButton btn_Query = new JButton();
		btn_Query.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// 选中一行信息点击进入按钮,将其项目编号作为参数传给煜哥
				int count = table.getSelectedRowCount();
				if (count > 1) {
					JOptionPane.showMessageDialog(null, "只能选择一行");

				} else if (count == 0) {
					JOptionPane.showMessageDialog(null, "请选择一行");

				} else {

					int chooseRow = table.getSelectedRow();
					int serialNumber = (int) tm.getValueAt(chooseRow, 0);
					System.out.println(".................");
				}

			}
		});
		btn_Query.setText("进入项目");
		panel.add(btn_Query);

		final JButton btn_Update = new JButton();
		btn_Update.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// 选中一条信息点击修改按钮时,出现一个修改内容的界面,该界面有两个按钮,
				// 且除了项目编号都可以修改,点击新界面的修改按钮后,tm模型中相应行的信息修改且数据库中相应行的内容发生修改
				int count = table.getSelectedRowCount();
				if (count > 1) {
					JOptionPane.showMessageDialog(null, "只能修改一行");

				} else if (count == 0) {
					JOptionPane.showMessageDialog(null, "请选择要修改的行");

				} else {
					// 进行修改
					int updateRow = table.getSelectedRow();
					UpdateJFrame uf = new UpdateJFrame(tm, updateRow);
					uf.setVisible(true);
				}

			}
		});
		btn_Update.setText("修改");
		panel.add(btn_Update);

		final JButton btn_Insert = new JButton();
		btn_Insert.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {

			}
		});
		btn_Insert.setText("添加");
		panel.add(btn_Insert);

		final JButton btn_Delete = new JButton();
		btn_Delete.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// 点击删除时,tm模型中选中行的信息删除且数据库中对应内容删除
				int count = table.getSelectedRowCount();
				if (count > 1) {
					JOptionPane.showMessageDialog(null, "只能删除一行");

				} else if (count == 0) {
					JOptionPane.showMessageDialog(null, "请选择要删除的行");

				} else {
					// 真删除
					// 用户选中一条项目点击删除后，先判断付款记录表以及单据表中是否有该编号对应的信息，若没有，则直接删除该项目信息，若有，
					// 则先让用户去删除付款记录表以及单据表中对应编号的信息，删除完毕后再删除项目信息
					int deleteRow = table.getSelectedRow();// 获取所要删除行的索引
					int serialNumber = (int) tm.getValueAt(deleteRow, 0);// 获取所要删除项目的项目编号
					// 查询付款记录表以及单据表中是否有该编号对应的信息 转去dao层
					ItemService is = new ItemService();
					boolean flag = true;
					int no = 0;
					try {
						flag = is.isBill(serialNumber);
						// 继续判断付款记录表中是否有该编号对应的信息
						boolean compare = is.isPayRecord(serialNumber);
						// 删除项目表中对应项目编号的信息
						no = is.delete(serialNumber);
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, e1.getMessage());
						
						// e1.printStackTrace();
					}
					if (no == 1) {
						JOptionPane.showMessageDialog(null, "删除成功!");

					}
				}

			}
		});
		btn_Delete.setText("删除");
		panel.add(btn_Delete);

		final JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);

		scrollPane.setViewportView(table);
		table.setModel(tm);
		tm.addColumn("项目编号");
		tm.addColumn("项目名称");
		tm.addColumn("钢管租价");
		tm.addColumn("丝杠租价");
		tm.addColumn("扣件租价");
		tm.addColumn("钢管售价");
		tm.addColumn("丝杠售价");
		tm.addColumn("扣件售价");

	}

}
