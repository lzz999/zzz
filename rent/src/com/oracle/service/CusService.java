package com.oracle.service;
import java.sql.ResultSet;

import javax.management.RuntimeErrorException;

public class CusService {
/**
 * ע��
 * @param cus
 */
	CusDao dao = new CusDao();
	public int login(Cus cus) throws Exception {
		// TODO Auto-generated method stub
		int no = 0;
		if(cus.getName()==null||cus.getName().equals("")){
			throw new RuntimeException("�û�������Ϊ��");
		}
		if(cus.getPass()==null||cus.getPass().equals("")){
			throw new RuntimeException("���벻��Ϊ��");
		}
		if(cus.getPassword()==null||cus.getPassword().equals("")){
			throw new RuntimeException("ȷ�����벻��Ϊ��");
		}
		if(cus.getPass().equals(cus.getPassword())){
			    no = dao.login(cus);
		}else{
			throw new RuntimeException("�������벻һ��,���������");
		}
		return no;
		
	}
	/**
	 * ��½
	 * @param cus
	 * @throws Exception 
	 */
	public void enter(Cus cus) throws Exception {
		// TODO Auto-generated method stub
		if(cus.getName()==null||cus.getName().equals("")){
			throw new RuntimeException("�û�������Ϊ��");
		}
		if(cus.getPass()==null||cus.getPass().equals("")){
			throw new RuntimeException("���벻��Ϊ��");
		}
		 dao.enter(cus);
		
		
		
		
		
		
		
		
	}

}

