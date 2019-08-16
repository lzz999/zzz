package com.java.ls1;

import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.table.DefaultTableModel;
import javax.xml.crypto.Data;

public class RecordDao {

	/**
	 * Ìí¼Ó
	 * 
	 * @param stu
	 * @return
	 */
	public int save(Record r) {
		DButils db = new DButils();
		String amount = Double.toString(r.getAmount());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String PaymentTime = sdf.format(r.getPaymentTime());
		String sql = "insert into record(serialNumber,pattern,amount,paymentTime,state,payee,record_id)values(?,?,?,?,?,?,?)";
		int no = db.preUpdate(sql, r.getSerialNumber(), r.getPattern(), amount,
				PaymentTime, r.getState(), r.getPayee(), r.getRecord_id());
		return no;
	}

	/**
	 * É¾
	 * 
	 * @param stu
	 * @return
	 */
	public int delete(int i) {
		DButils db = new DButils();
		String sql = "delete from record where record_id=?";
		int no = db.preUpdate(sql, i);
		return no;
	}

	/**
	 * ¸Ä
	 * 
	 * @param stu
	 * @return
	 */
	public int change(Record r) {
		DButils db = new DButils();
		String sql = "update  record set serialNumber=? pattern=?,amount=?,paymentTime=?,state=?,payee=? where  record_id=?";
		String amount = Double.toString(r.getAmount());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String PaymentTime = sdf.format(r.getPaymentTime());
		int no = db.preUpdate(sql, r.getSerialNumber(), r.getPattern(), amount,
				PaymentTime, r.getState(), r.getPayee(), r.getRecord_id());

		return no;
	}

	/**
	 * 
	 * @param dtm
	 * @param ²é
	 * @return
	 * @throws Exception
	 */

	public ArrayList<Record> queryByName(DefaultTableModel dtm)
			throws Exception {
		DButils db = new DButils();
		String sql = "select * from RECORD ";
		ResultSet rs = db.preQuer(sql);
		ArrayList<Record> list = new ArrayList<Record>();

		while (rs.next()) {
			int serialNumber = rs.getInt("serialNumber");
			int record_id = rs.getInt("record_id");
			String pattern = rs.getString("pattern");
			String amount = rs.getString("amount");
			double amount1 = Double.parseDouble(amount);
			String paymentTime = rs.getString("paymentTime");
			String state = rs.getString("state");
			String payee = rs.getString("payee");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date PaymentTime = sdf.parse(paymentTime);
			Record r = new Record(serialNumber, pattern, amount1, PaymentTime,
					state, payee, record_id);
			list.add(r);
		}
		return list;
	}

}
