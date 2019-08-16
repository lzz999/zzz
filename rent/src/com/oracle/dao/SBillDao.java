package com.oracle.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.TreeSet;

import com.oracle.bill.SBill;
import com.oracle.bill.SqlMsg;
import com.oracle.service.BillSearch;
import com.oracle.utill.DButils;

public class SBillDao {
	TreeSet<SqlMsg> set = new TreeSet<SqlMsg>();

	public TreeSet<SqlMsg> search(int num) throws SQLException, ParseException {
		// 获取显示信息
		DButils db = new DButils();
		String sql = "select b.name,b.nuit,b.type,b.initialDate,b.amount,b.ReMark,b.numerical,b.status,i.SteelRent,i.ScrewRent,i.FasteningRent,i.FasteningPrice,i.SteelPrice,i.ScrewPrice,i.ProjectName from bill b,item i where b.SerialNumber=? and i.SerialNumber=? and b.SerialNumber=i.SerialNumber  ";
		ResultSet rs = db.preQuery(sql, num, num);
		while (rs.next()) {
			SqlMsg sqm = new SqlMsg();
			sqm.setName(rs.getString("name"));
			sqm.setType(Double.parseDouble(rs.getString("type")));
			sqm.setNuit(rs.getString("nuit"));
			sqm.setAmount(Integer.parseInt(rs.getString("amount")));
			SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
			sqm.setInitialDate(sm.parse(rs.getString("initialDate")));
			sqm.setSteelRent(Double.parseDouble(rs.getString("steelRent")));
			sqm.setSteelPrice(Double.parseDouble(rs.getString("steelPrice")));
			sqm.setScrewRent(Double.parseDouble(rs.getString("screwRent")));
			sqm.setScrewPrice(Double.parseDouble(rs.getString("screwPrice")));
			sqm.setFasteningRent(Double.parseDouble(rs
					.getString("fasteningRent")));
			sqm.setFasteningPrice(Double.parseDouble(rs
					.getString("fasteningPrice")));
			sqm.setReMark(rs.getString("ReMark"));
			sqm.setbNum(rs.getInt("numerical"));
			sqm.setStatus(Integer.parseInt(rs.getString("status")));
			sqm.setpName(rs.getString("ProjectName"));
			set.add(sqm);
		}

		return set;

	}


}
