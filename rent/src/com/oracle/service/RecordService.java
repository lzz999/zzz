package com.java.ls1;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Service {
	private RecordDao rd = new RecordDao();

	/**
	 * ��ѯ
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
			throw new RuntimeException("δ��ѯ����Ϣ");
		}
		return list;
	}

	/**
	 * �޸�
	 * 
	 * @param r
	 * @return
	 * @throws Exception
	 */
	public int change(Record r) throws Exception {
		int no = rd.change(r);
		if (no != 1) {
			throw new RuntimeException("�޸�ʧ��");
		}
		return no;

	}

	/**
	 * ɾ��
	 * 
	 * @param i
	 * @return
	 */
	public int delete(int i) {
		int no = rd.delete(i);
		return no;
	}

	/**
	 * ����
	 * 
	 * @param r
	 */
	public void save(Record r) {
		rd.save(r);
	}
}
