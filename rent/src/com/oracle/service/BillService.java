package View;

import java.sql.SQLException;

/** 周江
 *  查询原始单据的业务类
 * @author MoveWorkStation
 *
 */
public class ServiceBill {
	Bill_DAO bd=new Bill_DAO();  //连接DAO层对象
	
//第一个方法,查询原始单据按钮的方法
	
	public void serch(int num) throws SQLException{
		
		bd.serch(num);
		
	}
//插入方法
	public void insert(){
		
		
		
	}
	//删除方法
	public void del(int list) throws SQLException {
		bd.del(list);
		
	}
	
	
	//修改方法
	public void modify(String date, Double nuit, int amount, String cONTRACTOR,
			String rEMARK, int list) throws SQLException {
		bd.modify(date, nuit,amount , cONTRACTOR, rEMARK, list);
		
	}
	
	
	
	
}
