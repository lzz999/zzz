package com.oracle.dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import com.creter.emtity.DButils;

public class CusDao {
/**
 * 注册
 * @param cus
 * @throws Exception 
 */
	public int login(Cus cus) throws Exception {
		// TODO Auto-generated method stub
	   DButils db = new DButils();
		String sql = "Insert into cus(name, pass)values(?,?);";
		int no = db.preUpdate(sql,cus.getName(),cus.getPass());
		return no;  
	}
	/**
	 * 登陆
	 * 
	 * @param cus
	 * @throws Exception 
	 */

public String enter(Cus cus) throws Exception {
	// TODO Auto-generated method stub
	DButils db = new DButils();
	
    String sql = "select * from cus where name=?";
    ResultSet rs = db.preQuery(sql,cus.getName());
    String pass = null;
	String name = null;
    while(rs.next()){
    	 name = rs.getString("name");
		  pass =rs.getString("pass");
		  if(pass.equals(cus.getPass())){
				return "登陆成功";
			}else{
				throw new RuntimeException("用户名或密码错误");
			}
    	
    }
	throw new RuntimeException("该用户不存在!"); 
	
}

}
