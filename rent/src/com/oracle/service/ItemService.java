package com.oracle.service;

import java.sql.SQLException;

import java.util.ArrayList;


import javax.swing.JOptionPane;

import com.oracle.dao.ItemDao;
import com.oracle.entity.Item;

public class ItemService {


	/***
	 * 选择项目
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
			throw new RuntimeException("修改失败!");
		}
		return no;
	}

	public boolean isBill(int serialNumber) throws Exception {

		boolean flag = ida.isBill(serialNumber);
		if (flag) {
			// bill表中有对应项目编号的信息,提示用户先删除bill表中的对应信息
			throw new RuntimeException("请先删除单据表中的信息!");

		}
		// bill表中没有对应项目编号的信息,返回都界面层
		return flag;

	}

	public int delete(int id) throws Exception {
		int no = ida.delete(id);
		if (no != 1) {
			throw new RuntimeException("删除失败!");
		}
		return no;
	}

	public boolean isPayRecord(int serialNumber) throws SQLException {
		boolean flag = ida.isBill(serialNumber);
		if (flag) {
			// Record表中有对应项目编号的信息,提示用户先删除bill表中的对应信息
			throw new RuntimeException("请先删除付款记录表中的信息!");

		}
		// Record表中没有对应项目编号的信息,返回都界面层
		return flag;
	}
	//查看
	public ArrayList<Item> select() throws Exception{
		ArrayList<Item> list = ida.select();
		return list;
	}
/**
 * 增加
 * @param item
 * @return 
 * @throws Exception
 */
	public int add(Item item) throws Exception {
		// TODO Auto-generated method stub
		if(item.getProjectName()==null||item.getProjectName().equals("")){
			throw new RuntimeException("项目部能为空");
		}
		if(item.getSteelRent()==null||item.getSteelRent().equals("")){
			throw new RuntimeException("钢管租价不能为空");
		}
		if(item.getScrewRent()==null||item.getScrewPrice().equals("")){
			throw new RuntimeException("丝杠租价不能为空");
		}
		if(item.getFasteningRent()==null||item.getFasteningRent().equals("")){
			throw new RuntimeException("扣件租价不能为空");
		}
		if(item.getSteelPrice()==null||item.getSteelPrice().equals("")){
			throw new RuntimeException("钢管售价不能为空");
		}
		if(item.getScrewPrice()==null||item.getScrewPrice().equals("")){
			throw new RuntimeException("丝杠售价不能为孔");
		}
		if(item.getFasteningPrice()==null||item.getFasteningPrice().equals("")){
			throw new RuntimeException("扣件售价不能为空");
		}
		     int no = ida.add(item);
			return no;
	}
}

