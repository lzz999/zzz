package com.java.ls1;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Increase extends JFrame {

	private JTextField text_Job;
	private JTextField text_Name;
	private JTextField text_Id;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public Increase(final DefaultTableModel tm, Service s) {
		getContentPane().setLayout(null);
		setSize(new Dimension(462, 421));

		final JLabel label = new JLabel();
		label.setText("\u9879\u76EE\u7F16\u53F7");
		label.setBounds(124, 74, 66, 18);
		getContentPane().add(label);

		final JLabel label_1 = new JLabel();
		label_1.setText("\u4ED8\u6B3E\u91D1\u989D");
		label_1.setBounds(124, 166, 66, 18);
		getContentPane().add(label_1);

		final JLabel label_2 = new JLabel();
		label_2.setText("\u53D1\u7968\u72B6\u6001");
		label_2.setBounds(124, 258, 66, 18);
		getContentPane().add(label_2);

		text_Id = new JTextField();
		text_Id.setBounds(255, 258, 66, 18);
		getContentPane().add(text_Id);

		text_Name = new JTextField();
		text_Name.setBounds(255, 166, 66, 18);
		getContentPane().add(text_Name);

		text_Job = new JTextField();
		text_Job.setEditable(false);
		text_Job.setBounds(255, 74, 66, 18);
		text_Job.setText(tm);
		getContentPane().add(text_Job);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
				String id = text_Job.getText();
				String name = textField_1.getText();
				String Amount = text_Name.getText();
				String PaymentTime = textField.getText();
				String State = text_Id.getText();
				String Payee = textField_3.getText();
				String record_id = textField_2.getText();
				// 2 将数据添加到表模型
				int id1 = Integer.parseUnsignedInt(record_id);
				int a = Integer.parseUnsignedInt(id);
				double amount = Double.parseDouble(Amount);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date paymentTime = null;
				try {
					paymentTime = sdf.parse(PaymentTime);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				// 2 将数据添加到表模型

				Record r = new Record(a, name, amount, paymentTime, State,
						Payee, id1);
				s.save(r);

			}
		});
		button.setText("确定");
		button.setBounds(160, 341, 106, 28);
		getContentPane().add(button);

		JLabel lblNewLabel = new JLabel("\u4ED8\u6B3E\u65B9\u5F0F");
		lblNewLabel.setBounds(124, 120, 66, 18);
		getContentPane().add(lblNewLabel);

		JLabel label_3 = new JLabel("\u4ED8\u6B3E\u65F6\u95F4");
		label_3.setBounds(124, 212, 66, 18);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel("\u6536\u6B3E\u4EBA");
		label_4.setBounds(124, 304, 66, 18);
		getContentPane().add(label_4);

		textField = new JTextField();
		textField.setBounds(255, 212, 66, 18);
		getContentPane().add(textField);

		textField_1 = new JTextField();
		textField_1.setBounds(255, 120, 66, 18);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(255, 28, 66, 18);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setBounds(255, 304, 66, 18);
		getContentPane().add(textField_3);

		JLabel label_5 = new JLabel();
		label_5.setText("\u7F16\u53F7");
		label_5.setBounds(124, 28, 66, 18);
		getContentPane().add(label_5);
	}

}
