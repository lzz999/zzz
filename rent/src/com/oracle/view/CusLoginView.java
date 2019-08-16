package com.oracle.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EnrollJFrame extends JFrame {
	private JPasswordField password;
	private JPasswordField pass;
	private JTextField text_name;
	CusService ce = new CusService();
	public EnrollJFrame() {
		super();
		setTitle("注册页面");
		getContentPane().setLayout(null);
         setSize(451,449);
		final JLabel label = new JLabel();
		label.setText("用户名");
		label.setBounds(69, 46, 66, 18);
		getContentPane().add(label);

		text_name = new JTextField();
		text_name.setBounds(233, 44, 112, 22);
		getContentPane().add(text_name);

		final JLabel label_1 = new JLabel();
		label_1.setText("密码");
		label_1.setBounds(69, 119, 66, 18);
		getContentPane().add(label_1);

		pass = new JPasswordField();
		pass.setBounds(233, 117, 112, 22);
		getContentPane().add(pass);

		final JLabel label_2 = new JLabel();
		label_2.setText("确认密码");
		label_2.setBounds(69, 186, 66, 18);
		getContentPane().add(label_2);

		password = new JPasswordField();
		password.setBounds(233, 184, 112, 22);
		getContentPane().add(password);

		final JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(final ActionEvent e) {
		String name	= text_name.getText();
		String pass1 = pass.getText();
		String password1 = password.getText();
		     Cus cus = new Cus(name,pass1,password1);
		        try {
					int no = ce.login(cus);
					if(no>0){
						JOptionPane.showConfirmDialog(null,"注册成功");
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					JOptionPane.showConfirmDialog(null,e1.getMessage());
					//e1.printStackTrace();
				}
			}
		});
		button.setText("提交");
		button.setBounds(140, 277, 106, 28);
		getContentPane().add(button);
	}

}
