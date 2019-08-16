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
	}

}
