package com.oracle.service;
import java.sql.ResultSet;

import javax.management.RuntimeErrorException;

public class CusService {
/**
 * 注册
 * @param cus
 */
	CusDao dao = new CusDao();
	public int login(Cus cus) throws Exception {
		// TODO Auto-generated method stub
		int no = 0;
		if(cus.getName()==null||cus.getName().equals("")){
			throw new RuntimeException("用户名不能为空");
		}
		if(cus.getPass()==null||cus.getPass().equals("")){
			throw new RuntimeException("密码不能为空");
		}
		if(cus.getPassword()==null||cus.getPassword().equals("")){
			throw new RuntimeException("确认密码不能为空");
		}
		if(cus.getPass().equals(cus.getPassword())){
			    no = dao.login(cus);
		}else{
			throw new RuntimeException("两次密码不一致,请从新输入");
		}
		return no;
		
	}
	/**
	 * 登陆
	 * @param cus
	 * @throws Exception 
	 */
	public void enter(Cus cus) throws Exception {
		// TODO Auto-generated method stub
		if(cus.getName()==null||cus.getName().equals("")){
			throw new RuntimeException("用户名不能为空");
		}
		if(cus.getPass()==null||cus.getPass().equals("")){
			throw new RuntimeException("密码不能为空");
		}
		 dao.enter(cus);
		
		
		
		
		
		
		
		
	}

}

