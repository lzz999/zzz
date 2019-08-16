package com.oracle.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.RasterFormatException;
import java.util.concurrent.ExecutionException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class AddJFrame extends JFrame {
	private JTextField text_fasteningPrice;
	private JTextField text_screwPrice;
	private JTextField text_steelPrice;
	private JTextField text_fasteningRent;
	private JTextField text_screwRent;
	private JTextField text_steelRent;
	private JTextField text_projectName;
	private JTextField text_serialNumber;
	ItemService se = new ItemService();

	public AddJFrame(DefaultTableModel tm) {
		super();
		setSize(500, 445);
		getContentPane().setLayout(null);

		final JLabel label_1 = new JLabel();
		label_1.setText("项目名称");
		label_1.setBounds(86, 72, 66, 18);
		getContentPane().add(label_1);

		text_projectName = new JTextField();
		text_projectName.setBounds(296, 70, 87, 22);
		getContentPane().add(text_projectName);

		final JLabel label_2 = new JLabel();
		label_2.setText("钢管租价");
		label_2.setBounds(86, 111, 66, 18);
		getContentPane().add(label_2);

		text_steelRent = new JTextField();
		text_steelRent.setBounds(296, 109, 87, 22);
		getContentPane().add(text_steelRent);

		final JLabel label_3 = new JLabel();
		label_3.setText("丝杠租价");
		label_3.setBounds(86, 148, 66, 18);
		getContentPane().add(label_3);

		text_screwRent = new JTextField();
		text_screwRent.setBounds(296, 146, 87, 22);
		getContentPane().add(text_screwRent);

		final JLabel label_4 = new JLabel();
		label_4.setText("扣件租价");
		label_4.setBounds(86, 185, 66, 18);
		getContentPane().add(label_4);

		text_fasteningRent = new JTextField();
		text_fasteningRent.setBounds(296, 183, 87, 22);
		getContentPane().add(text_fasteningRent);

		final JLabel label_5 = new JLabel();
		label_5.setText("钢管售价");
		label_5.setBounds(86, 222, 66, 18);
		getContentPane().add(label_5);

		text_steelPrice = new JTextField();
		text_steelPrice.setBounds(296, 220, 87, 22);
		getContentPane().add(text_steelPrice);

		final JLabel label_6 = new JLabel();
		label_6.setText("丝杠售价");
		label_6.setBounds(86, 262, 66, 18);
		getContentPane().add(label_6);

		text_screwPrice = new JTextField();
		text_screwPrice.setBounds(296, 260, 87, 22);
		getContentPane().add(text_screwPrice);

		final JLabel label_7 = new JLabel();
		label_7.setText("扣件售价");
		label_7.setBounds(86, 306, 66, 18);
		getContentPane().add(label_7);

		text_fasteningPrice = new JTextField();
		text_fasteningPrice.setBounds(296, 304, 87, 22);
		getContentPane().add(text_fasteningPrice);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String projectName = text_projectName.getText();
				String steelRent = text_steelRent.getText();
				String screwRent = text_screwRent.getText();
				String fasteningRent = text_fasteningRent.getText();
				String steelPrice = text_steelPrice.getText();
				String screwPrice = text_screwPrice.getText();
				String fasteningPrice = text_fasteningPrice.getText();
				Item item = new Item(projectName, steelRent, screwRent,
						fasteningRent, steelPrice, screwPrice, fasteningPrice);

				try {
					int no = se.add(item);
					if (no > 0) {
						JOptionPane.showMessageDialog(null, "添加成功");
						int serialNumber = se.show(projectName);
						tm.addRow(new Object[] { serialNumber, projectName,
								steelRent, screwRent, fasteningRent,
								steelPrice, screwPrice, fasteningPrice });

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, e1.getMessage());
					// e1.printStackTrace();
				}

			}
		});
		button.setText("添加");
		button.setBounds(191, 353, 106, 28);
		getContentPane().add(button);
	}

}
