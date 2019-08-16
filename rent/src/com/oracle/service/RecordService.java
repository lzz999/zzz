package com.java.ls1;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Service {
	private RecordDao rd = new RecordDao();

	/**
	 * 查询
	 * 
	 * @param r
	 * @param dtm
	 * @return
	 * @throws Exception
	 */
	public ArrayList<Record> queryByName(DefaultTableModel dtm)
			throws Exception {
		ArrayList<Record> list = rd.queryByName(dtm);
		if (list == null) {
			throw new RuntimeException("未查询到信息");
		}
		return list;
	}

	/**
	 * 修改
	 * 
	 * @param r
	 * @return
	 * @throws Exception
	 */
	public int change(Record r) throws Exception {
		int no = rd.change(r);
		if (no != 1) {
			throw new RuntimeException("修改失败");
		}
		return no;

	}

	/**
	 * 删除
	 * 
	 * @param i
	 * @return
	 */
	public int delete(int i) {
		int no = rd.delete(i);
		return no;
	}

	/**
	 * 增加
	 * 
	 * @param r
	 */
	public void save(Record r) {
		rd.save(r);
	}
}
