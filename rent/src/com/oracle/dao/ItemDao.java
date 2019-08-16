package com.oracle.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.oracle.entity.Item;
import com.oracle.util.DButils;

public class ItemDao {
/**
 * ��ȡ��Ŀ
 * @return
 * @throws SQLException
 */
	public ArrayList<Item> getItem() throws SQLException {
		DButils db=new DButils();
		String sql="select * from item";
		ResultSet rs=db.preQuery(sql);
		Item item=null;
		ArrayList<Item> arr=new ArrayList<Item>();
		while(rs.next()){
			item=new Item();
			item.setSerialNumber(rs.getInt("SerialNumber"));
			item.setProjectName(rs.getString("ProjectName"));
			item.setSteelRent(rs.getString("SteelRent"));
			item.setSteelPrice(rs.getString("SteelPrice"));
			item.setScrewRent(rs.getString("ScrewRent"));
			item.setScrewPrice(rs.getString("ScrewPrice"));
			item.setFasteningRent(rs.getString("FasteningRent"));
			item.setFasteningPrice(rs.getString("FasteningPrice"));
			arr.add(item);
		}
		return arr;


import com.oracle.entity.Item;
import com.oracle.utli.DButils;

/**
 * ����Ŀ������޸��Լ�ɾ��
 * 
 * @author zws
 *
 */
public class ItemDao {
	DButils du = new DButils();

	// �޸���Ŀ����ĳ��������
	public int update(Item item) throws Exception {

		String sql = "update item  set ProjectName=?,steelRent=?,screwRent=?,fasteningRent=?,steelPrice=?,screwPrice=?,fasteningPrice=? where serialNumber=?";
		int no = du.preUpdate(sql, item.getProjectName(), item.getSteelRent(),
				item.getScrewRent(), item.getFasteningRent(),
				item.getSteelPrice(), item.getScrewPrice(),
				item.getFasteningPrice(), item.getSerialNumber());
		return no;

	}

	/*
	 * ��ѯ���ݱ����Ƿ��иñ�Ŷ�Ӧ����Ϣ
	 */
	public boolean isBill(int serialNumber) throws SQLException {
		boolean flag = false;
		String sql = "select * from  bill where serialNumber=?";
		ResultSet rs = du.preQuery(sql, serialNumber);
		if (rs.next()) {
			// ���Բ�ѯ����Ϣ�����ص�service��
			flag = true;

		}
		return flag;
	}

	// ɾ����Ŀ���е�ĳ����Ϣ
	public int delete(int id) throws SQLException  {
		String sql = "delete from item where serialNumer=?";
		int no = du.preUpdate(sql, id);
		return no;
	}

	/*
	 * ��ѯ�����¼�����Ƿ��иñ�Ŷ�Ӧ����Ϣ
	 */
	public boolean isPayRecord(int serialNumber) throws SQLException {
		boolean flag = false;
		String sql = "select * from  Record where serialNumber=?";
		ResultSet rs = du.preQuery(sql, serialNumber);
		if (rs.next()) {
			// ���Բ�ѯ����Ϣ�����ص�service��
			flag = true;

		}
		return flag;


	}

}
