package View;

import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

//插入输入框 界面

public class InsertBillUi extends JFrame{
	
	private JTextField NuitField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_2;
	private JTextField InputDate;
	public InsertBillUi() throws ParseException {
		
		Image icon = Toolkit.getDefaultToolkit().getImage("src/timg.jpg");
	    this.setIconImage(icon);
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");//首先定义好日期的格式
		setSize(556, 441);
		setTitle("出入库单据添加");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("型号");
		lblNewLabel.setBounds(111, 158, 54, 15);
		getContentPane().add(lblNewLabel);
		
		NuitField = new JTextField();
		NuitField.setText("    ");
		NuitField.setBounds(110, 183, 66, 21);
		getContentPane().add(NuitField);
		NuitField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("单位");
		lblNewLabel_1.setBounds(198, 158, 40, 15);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(274, 183, 66, 21);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("数量");
		lblNewLabel_2.setBounds(274, 158, 40, 15);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("承办人");
		lblNewLabel_3.setBounds(362, 158, 66, 15);
		getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(362, 183, 66, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label = new JLabel("项目名字在这里显示");
		label.setFont(new Font("SimSun", Font.BOLD, 20));
		label.setBounds(156, 10, 227, 45);
		getContentPane().add(label);
		
		JLabel lblNewLabel_4 = new JLabel("物资名称");
		lblNewLabel_4.setBounds(22, 158, 59, 15);
		getContentPane().add(lblNewLabel_4);
		
		JComboBox<String> NAME = new JComboBox<String>();
		NAME.setBounds(22, 183, 66, 21);
		getContentPane().add(NAME);
		NAME.addItem("钢管");
		NAME.addItem("扣件");
		NAME.addItem("丝杠");
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		comboBox_1.setBounds(198, 183, 54, 21);
		getContentPane().add(comboBox_1);
		comboBox_1.addItem("米");
		comboBox_1.addItem("个");
		comboBox_1.addItem("根");
		
		JComboBox<String> STABOX = new JComboBox<String>();
		STABOX.setBounds(93, 90, 66, 21);
		getContentPane().add(STABOX);
		STABOX.addItem("发货单");
		STABOX.addItem("收货单");
		
		JLabel lblNewLabel_5 = new JLabel("单据类型");
		lblNewLabel_5.setBounds(105, 65, 54, 15);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("备注");
		lblNewLabel_6.setBounds(450, 158, 66, 15);
		getContentPane().add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(450, 183, 66, 21);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("日期(yyyy-mm-dd)");
		lblNewLabel_7.setBounds(288, 59, 122, 26);
		getContentPane().add(lblNewLabel_7);
		
		InputDate = new JTextField();
		InputDate.setBounds(299, 90, 111, 21);
		getContentPane().add(InputDate);
		InputDate.setColumns(10);
		InputDate.setText("2015-06-09");
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {//提交按钮功能
				Bill bill=new Bill();
				
				String STATUS=(String) (STABOX.getSelectedItem());
				try {
					Date date= format1.parse(InputDate.getText());
					bill.setINITIALDATE(date);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				//输入窗体的内容,转化为java DATE格式
				
				String name=(String)(NAME.getSelectedItem());
				Double NUIT=Double.valueOf(NuitField.getText());
				String TYPE=(String) (comboBox_1.getSelectedItem());
				int AMOUNT= Integer.parseInt(textField_1.getText());
				String CONTRACTOR=textField_3.getText();
				String REMARK=textField_2.getText();
				
				
				bill.setAMOUNT(AMOUNT);
				bill.setCONTRACTOR(CONTRACTOR);
				bill.setNAME(name);
				bill.setNUIT(NUIT);
			//	bill.setNUMERICAL(nUMERICAL);					//设置数据库中的单据序号,这里可能需要固定语句来存入单据,读取序号的时候另说,无需此变量
				bill.setREMARK(REMARK);
			//	bill.setSERIALNUMBER(sERIALNUMBER);  //设置项目编号  这里需要主程序给定项目编号才可以存
				int sta=0;
				if(STATUS.equals("发货单")){
					sta=1;
				}else if(STATUS.equals("收货单")){
					
					sta=-1;
				}
				bill.setSTATUS(sta);								//状态值,先判断是发货单还是收货单,再给其赋值
				bill.setTYPE(TYPE);
				System.out.println(bill);
				//数据获取完毕,把对象传给DAO层方法,同时传入数据库
				Bill_DAO bd=new Bill_DAO();
				try {
					bd.add(bill);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
				
				
			}
		});
		button.setBounds(204, 290, 93, 23);
		getContentPane().add(button);
		
		JLabel label_1 = new JLabel("承租方项目名称:");
		label_1.setFont(new Font("SimSun", Font.BOLD, 15));
		label_1.setBounds(23, 12, 127, 45);
		getContentPane().add(label_1);
		
		
		
		
	}
	public void add(){
		
		
		
	}

}
