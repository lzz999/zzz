package com.oracle.service;

import java.sql.SQLException;
import java.util.ArrayList;

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
