package com.oracle.service;

import java.sql.SQLException;

import java.util.ArrayList;


import javax.swing.JOptionPane;

import com.oracle.dao.ItemDao;
import com.oracle.entity.Item;

public class ItemService {


	/***
	 * ѡ����Ŀ
	 * @author Administrator
	 *
	 */
	public ArrayList<Item> getItem() throws SQLException {
		ItemDao eid=new ItemDao();
		ArrayList<Item> arr=eid.getItem();
		return arr;
	}

}

	ItemDao ida = new ItemDao();

	public int update(Item item) throws Exception {
		int no = ida.update(item);
		if (no != 1) {
			throw new RuntimeException("�޸�ʧ��!");
		}
		return no;
	}

	public boolean isBill(int serialNumber) throws Exception {

		boolean flag = ida.isBill(serialNumber);
		if (flag) {
			// bill�����ж�Ӧ��Ŀ��ŵ���Ϣ,��ʾ�û���ɾ��bill���еĶ�Ӧ��Ϣ
			throw new RuntimeException("����ɾ�����ݱ��е���Ϣ!");

		}
		// bill����û�ж�Ӧ��Ŀ��ŵ���Ϣ,���ض������
		return flag;

	}

	public int delete(int id) throws Exception {
		int no = ida.delete(id);
		if (no != 1) {
			throw new RuntimeException("ɾ��ʧ��!");
		}
		return no;
	}

	public boolean isPayRecord(int serialNumber) throws SQLException {
		boolean flag = ida.isBill(serialNumber);
		if (flag) {
			// Record�����ж�Ӧ��Ŀ��ŵ���Ϣ,��ʾ�û���ɾ��bill���еĶ�Ӧ��Ϣ
			throw new RuntimeException("����ɾ�������¼���е���Ϣ!");

		}
		// Record����û�ж�Ӧ��Ŀ��ŵ���Ϣ,���ض������
		return flag;
	}
	//�鿴
	public ArrayList<Item> select() throws Exception{
		ArrayList<Item> list = ida.select();
		return list;
	}
/**
 * ����
 * @param item
 * @return 
 * @throws Exception
 */
	public int add(Item item) throws Exception {
		// TODO Auto-generated method stub
		if(item.getProjectName()==null||item.getProjectName().equals("")){
			throw new RuntimeException("��Ŀ����Ϊ��");
		}
		if(item.getSteelRent()==null||item.getSteelRent().equals("")){
			throw new RuntimeException("�ֹ���۲���Ϊ��");
		}
		if(item.getScrewRent()==null||item.getScrewPrice().equals("")){
			throw new RuntimeException("˿����۲���Ϊ��");
		}
		if(item.getFasteningRent()==null||item.getFasteningRent().equals("")){
			throw new RuntimeException("�ۼ���۲���Ϊ��");
		}
		if(item.getSteelPrice()==null||item.getSteelPrice().equals("")){
			throw new RuntimeException("�ֹ��ۼ۲���Ϊ��");
		}
		if(item.getScrewPrice()==null||item.getScrewPrice().equals("")){
			throw new RuntimeException("˿���ۼ۲���Ϊ��");
		}
		if(item.getFasteningPrice()==null||item.getFasteningPrice().equals("")){
			throw new RuntimeException("�ۼ��ۼ۲���Ϊ��");
		}
		     int no = ida.add(item);
			return no;
	}
}

