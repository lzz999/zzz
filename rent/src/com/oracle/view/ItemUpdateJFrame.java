package com.oracle.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.oracle.entity.Item;
import com.oracle.service.ItemService;

public class ItemUpdateJFrame extends JFrame {
	private JTextField txt_FasteningPrice;
	private JTextField txt_ScrewPrice;
	private JTextField txt_SteelPrice;
	private JTextField txt_FasteningRent;
	private JTextField txt_ScrewRent;
	private JTextField txt_SteelRent;
	private JTextField txt_Name;
	private JTextField txt_Id;

	public ItemUpdateJFrame(final DefaultTableModel tm, final int updateRow) {
		super();
		getContentPane().setLayout(null);
		setResizable(false);
		setSize(500, 500);

		final JLabel label_Id = new JLabel();
		label_Id.setText("项目编号:");
		label_Id.setBounds(47, 35, 66, 18);
		getContentPane().add(label_Id);

		final JLabel label_Name = new JLabel();
		label_Name.setText("项目名称:");
		label_Name.setBounds(47, 91, 66, 18);
		getContentPane().add(label_Name);

		final JLabel label_SteelRent = new JLabel();
		label_SteelRent.setText("钢管租价:");
		label_SteelRent.setBounds(47, 144, 66, 18);
		getContentPane().add(label_SteelRent);

		final JLabel label_ScrewRent = new JLabel();
		label_ScrewRent.setText("丝杠租价:");
		label_ScrewRent.setBounds(47, 208, 81, 18);
		getContentPane().add(label_ScrewRent);

		final JLabel label_FasteningRent = new JLabel();
		label_FasteningRent.setText("扣件租价:");
		label_FasteningRent.setBounds(47, 266, 66, 18);
		getContentPane().add(label_FasteningRent);

		final JLabel label_SteelPrice = new JLabel();
		label_SteelPrice.setText("钢管售价:");
		label_SteelPrice.setBounds(47, 144, 66, 18);
		getContentPane().add(label_SteelPrice);

		final JLabel label_ScrewPrice = new JLabel();
		label_ScrewPrice.setText("丝杠售价:");
		label_ScrewPrice.setBounds(47, 208, 81, 18);
		getContentPane().add(label_ScrewPrice);

		final JLabel label_FasteningPrice = new JLabel();
		label_FasteningPrice.setText("扣件售价:");
		label_FasteningPrice.setBounds(47, 266, 66, 18);
		getContentPane().add(label_FasteningPrice);

		txt_Id = new JTextField();
		txt_Id.setBounds(165, 33, 112, 22);
		getContentPane().add(txt_Id);

		txt_Name = new JTextField();
		txt_Name.setBounds(165, 89, 112, 22);
		getContentPane().add(txt_Name);

		txt_SteelRent = new JTextField();
		txt_SteelRent.setBounds(165, 142, 112, 22);
		getContentPane().add(txt_SteelRent);

		txt_ScrewRent = new JTextField();
		txt_ScrewRent.setBounds(165, 206, 112, 22);
		getContentPane().add(txt_ScrewRent);

		txt_FasteningRent = new JTextField();
		txt_FasteningRent.setBounds(165, 264, 112, 22);
		getContentPane().add(txt_FasteningRent);

		txt_SteelPrice = new JTextField();
		txt_SteelPrice.setBounds(165, 142, 112, 22);
		getContentPane().add(txt_SteelPrice);

		txt_ScrewPrice = new JTextField();
		txt_ScrewPrice.setBounds(165, 206, 112, 22);
		getContentPane().add(txt_ScrewPrice);

		txt_FasteningPrice = new JTextField();
		txt_FasteningPrice.setBounds(165, 264, 112, 22);
		getContentPane().add(txt_FasteningPrice);

		final JButton bt_Show = new JButton();
		bt_Show.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// 点击显示时,将所选中行的信息显示到文本框中
				txt_Id.setText(tm.getValueAt(updateRow, 0).toString());
				txt_Name.setText(tm.getValueAt(updateRow, 1).toString());
				txt_SteelRent.setText(tm.getValueAt(updateRow, 2).toString());
				txt_ScrewRent.setText(tm.getValueAt(updateRow, 3).toString());
				txt_FasteningRent.setText(tm.getValueAt(updateRow, 4)
						.toString());
				txt_SteelPrice.setText(tm.getValueAt(updateRow, 5).toString());
				txt_ScrewPrice.setText(tm.getValueAt(updateRow, 6).toString());
				txt_FasteningPrice.setText(tm.getValueAt(updateRow, 7)
						.toString());
				txt_Id.setEditable(false);

			}
		});
		bt_Show.setText("显示");
		bt_Show.setBounds(67, 312, 106, 28);
		getContentPane().add(bt_Show);

		final JButton bt_Update = new JButton();
		bt_Update.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				// 点击修改时,获取文本框的值,将文本框中的值显示到表模型的相应位置以及数据库中相应记录也发生变化
				String id = txt_Id.getText();
				int number = Integer.parseInt(id);
				String name = txt_Name.getText();
				String steelRent = txt_SteelRent.getText();
				String screwRent = txt_ScrewRent.getText();
				String fasteningRent = txt_FasteningRent.getText();

				String steelPrice = txt_SteelPrice.getText();
				String screwPrice = txt_ScrewPrice.getText();
				String fasteningPrice = txt_FasteningPrice.getText();
				tm.setValueAt(name, updateRow, 1);
				tm.setValueAt(steelRent, updateRow, 2);
				tm.setValueAt(screwRent, updateRow, 3);
				tm.setValueAt(fasteningRent, updateRow, 4);
				tm.setValueAt(steelPrice, updateRow, 5);
				tm.setValueAt(screwPrice, updateRow, 6);
				tm.setValueAt(fasteningPrice, updateRow, 7);
				ItemService is = new ItemService();
				Item item = new Item();
				item.setSerialNumber(number);
				item.setProjectName(name);
				item.setSteelRent(steelRent);
				item.setScrewRent(screwRent);
				item.setFasteningRent(fasteningRent);
				item.setSteelPrice(steelPrice);
				item.setScrewPrice(screwPrice);
				item.setFasteningPrice(fasteningPrice);
				int no = 0;
				try {
					no = is.update(item);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					// e1.printStackTrace();
				}
				if(no==1){
				JOptionPane.showMessageDialog(null, "修改成功!");
				}

			}
		});
		bt_Update.setText("修改");
		bt_Update.setBounds(216, 312, 106, 28);
		getContentPane().add(bt_Update);
	}

}
