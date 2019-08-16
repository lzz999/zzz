package com.oracle.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import com.oracle.entity.Item;
import com.oracle.util.DButils;

public class ItemDao {
/**
 * 获取项目
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
 * 对项目表进行修改以及删除
 * 
 * @author zws
 *
 */
public class ItemDao {
	DButils du = new DButils();

	// 修改项目表中某条的内容
	public int update(Item item) throws Exception {

		String sql = "update item  set ProjectName=?,steelRent=?,screwRent=?,fasteningRent=?,steelPrice=?,screwPrice=?,fasteningPrice=? where serialNumber=?";
		int no = du.preUpdate(sql, item.getProjectName(), item.getSteelRent(),
				item.getScrewRent(), item.getFasteningRent(),
				item.getSteelPrice(), item.getScrewPrice(),
				item.getFasteningPrice(), item.getSerialNumber());
		return no;

	}

	/*
	 * 查询单据表中是否有该编号对应的信息
	 */
	public boolean isBill(int serialNumber) throws SQLException {
		boolean flag = false;
		String sql = "select * from  bill where serialNumber=?";
		ResultSet rs = du.preQuery(sql, serialNumber);
		if (rs.next()) {
			// 可以查询到信息，返回到service层
			flag = true;

		}
		return flag;
	}

	// 删除项目表中的某条信息
	public int delete(int id) throws SQLException  {
		String sql = "delete from item where serialNumer=?";
		int no = du.preUpdate(sql, id);
		return no;
	}

	/*
	 * 查询付款记录表中是否有该编号对应的信息
	 */
	public boolean isPayRecord(int serialNumber) throws SQLException {
		boolean flag = false;
		String sql = "select * from  Record where serialNumber=?";
		ResultSet rs = du.preQuery(sql, serialNumber);
		if (rs.next()) {
			// 可以查询到信息，返回到service层
			flag = true;

		}
		return flag;


	}

}
