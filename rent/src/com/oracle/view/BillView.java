package View;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
//原始单据的增删修改
public class BillUI extends JFrame{
	
	private JTable table;
	public BillUI() throws ParseException {
		ServiceBill ser=new ServiceBill();//创建业务类对象,以连接业务类方法
		InsertBillUi inser=new InsertBillUi();  //预创建插入窗体对象,以进行插入操作
		Image icon = Toolkit.getDefaultToolkit().getImage("src/timg (1).jpg");
	    this.setIconImage(icon);
		int num=1;
		setSize(663, 499);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 157, 647, 303);
		getContentPane().add(scrollPane);
		
		
		
		table = new JTable();  //创建表格
		DefaultTableModel  tm = new DefaultTableModel();   //创建表模型
		  table.setModel(tm);//表模型中放表格
		  tm.addColumn("单据编号");
		  tm.addColumn("项目名称");//用模型的方法来实现动态表格生成
		  tm.addColumn("单据日期");
		  tm.addColumn("物资型号");
		  tm.addColumn("物资数量");
		  tm.addColumn("经办人");
		  tm.addColumn("备注");
		  
		  //预留行,这里使用业务方法,插入单据信息  
		  
		  Object [] rowData={"1","测试单据","测试日期","测试型号",100,"测试李占泽","测试备注"};
		  tm.addRow(rowData);//测试添加行,传入行DAta对象
		  
		  
		scrollPane.setViewportView(table); //设置此窗体显示
		setLocationRelativeTo(null);//设置窗口相对于指定组件的位置。
		
		JButton SerchBtn = new JButton("查询");
		SerchBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {//查询按钮功能
				
				//查询之前先清除表内数据
				int rowCount=tm.getRowCount();             //看看表模型tm里面有几行数据
			    for (int i = 0; i < rowCount; i++) {
			     tm.removeRow(0);		//循环移除一行
			    }
			    
				
				try {
					Bill_DAO bd=new Bill_DAO();
					ResultSet rs=bd.serch(num);   
					//循环插入每一行的每一个属性信息
					while (rs.next()){
						int num=rs.getInt("SERIALNUMBER");
						String BILL_LIST=rs.getString("BILL_LIST");
						String nuit = rs.getString("NUIT");
						String type = rs.getString("TYPE");
						String status = rs.getString("STATUS");
						String initialdate = rs.getString("INITIALDATE");
						String name = rs.getString("NAME");
						String amount = rs.getString("AMOUNT");
						String contractor = rs.getString("CONTRACTOR");
						String remark=rs.getString("REMARK");
						tm.addRow(new Object[] { BILL_LIST,num, initialdate, nuit, amount, contractor,
						        remark });
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		
		SerchBtn.setBounds(55, 63, 93, 23);
		getContentPane().add(SerchBtn);
		
		JButton InertBtn = new JButton("插入单据");
		InertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//插入单据按钮功能
				
				inser.setVisible(true);
				
				
			}
		});
		InertBtn.setBounds(203, 63, 93, 23);
		getContentPane().add(InertBtn);
		
		JButton DelBtn = new JButton("删除单据");
		DelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//删除单据按钮功能
				    int no = table.getSelectedRowCount();
				         if(no>1){
				          // 提示窗体一次只能删除一行
				          JOptionPane.showMessageDialog(null, "一次只能删除一行");
				         }else if(no==0){
				          // 提示窗体请选择要删除的行
				          JOptionPane.showMessageDialog(null, "请选择要删除的行");
				         }else{
				          // 提示窗体确定要删除吗
				         int confirmNo =  JOptionPane.showConfirmDialog(null, "确定要删除吗?");
				         if(confirmNo==0){
				          // 真改
				          
				         int rowNo =  table.getSelectedRow();// 获取行的索引
				      String listnum= (String)tm.getValueAt(rowNo, 0);   //获取 表模型查询到的单据序列号
				         int list=Integer.parseInt(listnum);      //获取到的String转换成int
				         
				         
				         				try {
											ser.del(list);
										//	System.out.println(list);  //测试输出获取到的序号
										} catch (SQLException e1) {
										
											e1.printStackTrace();
										}
				         				tm.removeRow(rowNo);  //把表模型里面的删除掉	         
				         }
				         }
				   }
				  });
		DelBtn.setBounds(351, 63, 93, 23);
		getContentPane().add(DelBtn);
		
		JButton FixBtn = new JButton("修改单据");
		FixBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {//修改单据按钮功能
				  int no = table.getSelectedRowCount();
			         if(no>1){
			          // 一次只能修改一行
			          JOptionPane.showMessageDialog(null, "一次只能修改一行");
			         }else if(no==0){
			          // 请选择要修改的行
			          JOptionPane.showMessageDialog(null, "请选择要修改的行");
			         }else{
			          // 确定要修改吗
			         int confirmNo =  JOptionPane.showConfirmDialog(null, "确定要修改吗?");
			   
			         if(confirmNo==0){
			          // 真改
			          
			         int rowNo =  table.getSelectedRow();// 获取行的索引
			         String listnum= (String)tm.getValueAt(rowNo, 0);   //获取 表模型查询到的单据序列号
			         int list=Integer.parseInt(listnum);
			         Bill_DAO bd=new Bill_DAO();
			         
			         //获取所选行的所有可修改信息
			         String date =(String)tm.getValueAt(rowNo, 2);					//开单日期	
			         String NUIT =(String)tm.getValueAt(rowNo, 3);					//物资型号
			         Double nuit= Double.parseDouble(NUIT);
			         String AMOUNT =(String)tm.getValueAt(rowNo, 4);				//物资数量	
			         int amount=Integer.parseInt(AMOUNT);
			         String CONTRACTOR =(String)tm.getValueAt(rowNo, 5);	//经办人
			         String REMARK =(String)tm.getValueAt(rowNo, 6);				//备注信息
			         
			         
			         try {
						ser.modify(date, nuit, amount, CONTRACTOR, REMARK,list);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
											//把新数据更新到表模型
											//把新数据使用DAO层方法更新到数据库
			       //思路,直接在表格中修改,按按钮后.把所有数据全部重新放入数据库
									
							//	System.out.println(date+nuit+ amount+ CONTRACTOR+ REMARK+list); //测试输出获取到的信息			         
			         }
			         }			
				
			}
		});
		FixBtn.setBounds(499, 63, 93, 23);
		getContentPane().add(FixBtn);
	}
	}
	


		
		
	

