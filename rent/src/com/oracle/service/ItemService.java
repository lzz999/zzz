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
}

