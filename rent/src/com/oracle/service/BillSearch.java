package com.oracle.service;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TreeSet;

import com.oracle.bill.SBill;
import com.oracle.bill.SqlMsg;
import com.oracle.dao.SBillDao;


public class BillSearch {
	public TreeSet<SBill> search(int num, String stopDate) throws Exception,
			ParseException {
		if(stopDate.equals("")){
			throw new RuntimeException("请填写日期！");
		}
		
		TreeSet<SBill> set1=null;
		
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = sm.parse(stopDate);//结束日期
		SBillDao sbd = new SBillDao();
		TreeSet<SqlMsg> set = new TreeSet<SqlMsg>();//原始单据
		set = sbd.search(num);
		set1 = new TreeSet<SBill>();// 处理过的数据
		double rent=0,price = 0;
		double money = 0;//总价
		double sMoney=0;//金额
		long daySum = 0;//总天数
		for (SqlMsg sqlMsg : set) {
			if (sqlMsg.getName().equals("钢管")) {
				
					rent = sqlMsg.getSteelRent();
					price = sqlMsg.getSteelPrice();
				
			} else if (sqlMsg.getName().equals("扣件")) {
				
					rent = sqlMsg.getFasteningRent();
					price = sqlMsg.getFasteningPrice();
				
			} else if (sqlMsg.getName().equals("丝杠")) {
				
					rent = sqlMsg.getScrewRent();
					price = sqlMsg.getScrewPrice();
				
			}
			Date bDate = sqlMsg.getInitialDate();
			daySum = -(bDate.getTime() - sDate.getTime() + 1000000)
					/ (60 * 60 * 24 * 1000)+1;// 计算天数
			//总金额
			money=rent*sqlMsg.getAmount()*sqlMsg.getType()*daySum*sqlMsg.getStatus();
			sMoney+=money;
			
			
			
		
			
			
			SBill sb=new SBill();
			sb.setInitialDate(sqlMsg.getInitialDate());//开始日期
			sb.setgName(sqlMsg.getName());//品名
			sb.setType(sqlMsg.getType());//型号
			sb.setNuit(sqlMsg.getNuit());//单位
			sb.setAmount(sqlMsg.getAmount());//总数
			sb.setFinisDate(sDate);//结束日期
			sb.setDaySum(daySum);//总天数
			sb.setPrice(price);//售价
			sb.setRent(rent);//租价
			sb.setMoney(money);//总额
			sb.setReMark(sqlMsg.getReMark());//备注
			sb.setsMoney(sMoney);//总金额
			sb.setbNum(sqlMsg.getbNum());//编号
			sb.setStatus(sqlMsg.getStatus());//状态
			set1.add(sb);
			
			
		}
		return set1;

	}
	public ArrayList<SBill> sumBill(int num, String stopDate) throws Exception{
		
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String[] day=stopDate.split("-");
		day[2]="1";
		String date=day[0]+"-"+day[1]+"-"+day[2];
		Date dDate=sm.parse(date);//默认日期
		TreeSet<SBill> ts=search(num, stopDate);
		int sumSteel = 0;//钢管总量
		int sumFast = 0;//扣件总量
		int sumScrew = 0;//丝杠总量
		double srent=0;
		double frent=0;
		double scrent=0;
		for (SBill s: ts) {
			if(dDate.compareTo(s.getInitialDate())> 0){
				if(s.getgName().equals("钢管")){
					sumSteel+=s.getAmount()*s.getStatus();
					srent=s.getRent();
				}else if(s.getgName().equals("扣件")){
					sumFast+=s.getAmount()*s.getStatus();
					frent=s.getRent();
					
				}else if(s.getgName().equals("丝杠")){
					sumScrew+=s.getAmount()*s.getStatus();
					scrent=s.getRent();
				}
				
			}
		}
		
		/**
		 * 钢管
		 */
		SBill sb=new SBill();
		sb.setMonth(day[1]+"月结余");
		sb.setgName("钢管");
		sb.setType(1);
		sb.setNuit("米");
		sb.setAmount(sumSteel);
		sb.setInitialDate(dDate);
		sb.setFinisDate(sm.parse(stopDate));
		long daySum = 0;//总天数
		
		
		daySum = -(dDate.getTime() - sm.parse(stopDate).getTime() + 1000000)
				/ (60 * 60 * 24 * 1000)+1;// 计算天数
		sb.setDaySum(daySum);
		sb.setRent(srent);
		sb.setMoney(sumSteel*daySum*srent);
		sb.setReMark("");
		/**
		 * 扣件
		 */
		SBill sb1=new SBill();
		sb1.setMonth(day[1]+"月结余");
		sb1.setgName("扣件");
		sb1.setType(1);
		sb1.setNuit("套");
		sb1.setAmount(sumFast);
		sb1.setInitialDate(dDate);
		sb1.setFinisDate(sm.parse(stopDate));
		sb1.setDaySum(daySum);
		sb1.setRent(frent);
		sb1.setMoney(sumFast*daySum*frent);
		sb1.setReMark("");
		/**
		 * 丝杠
		 */
		SBill sb2=new SBill();
		sb2.setMonth(day[1]+"月结余");
		sb2.setgName("丝杠");
		sb2.setType(1);
		sb2.setNuit("根");
		sb2.setAmount(sumScrew);
		sb2.setInitialDate(dDate);
		sb2.setFinisDate(sm.parse(stopDate));
		sb2.setDaySum(daySum);
		sb2.setRent(scrent);
		sb2.setMoney(sumScrew*daySum*scrent);
		sb2.setReMark("");
		ArrayList<SBill> arr=new ArrayList<SBill>();
		arr.add(sb);
		arr.add(sb1);
		arr.add(sb2);
		
		return arr;
		
		
		
		
		
		}
	public String[] showMsg(int num) throws SQLException, ParseException {
		SBillDao sd=new SBillDao();
		TreeSet<SqlMsg> ts=sd.search(num);
		Date minDate=new Date();
		String pName="";
		for (SqlMsg s : ts) {
			if(minDate.compareTo(s.getInitialDate())>0){
				minDate=s.getInitialDate();
			}
			pName=s.getpName();
		}
		SimpleDateFormat sm=new SimpleDateFormat("yyyy-MM-dd");
		String minDay=sm.format(minDate);
		String[] msg=new String[]{minDay,pName};
		return msg;
		
	}

	
    
}
