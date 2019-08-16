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
			throw new RuntimeException("����д���ڣ�");
		}
		
		TreeSet<SBill> set1=null;
		
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		Date sDate = sm.parse(stopDate);//��������
		SBillDao sbd = new SBillDao();
		TreeSet<SqlMsg> set = new TreeSet<SqlMsg>();//ԭʼ����
		set = sbd.search(num);
		set1 = new TreeSet<SBill>();// �����������
		double rent=0,price = 0;
		double money = 0;//�ܼ�
		double sMoney=0;//���
		long daySum = 0;//������
		for (SqlMsg sqlMsg : set) {
			if (sqlMsg.getName().equals("�ֹ�")) {
				
					rent = sqlMsg.getSteelRent();
					price = sqlMsg.getSteelPrice();
				
			} else if (sqlMsg.getName().equals("�ۼ�")) {
				
					rent = sqlMsg.getFasteningRent();
					price = sqlMsg.getFasteningPrice();
				
			} else if (sqlMsg.getName().equals("˿��")) {
				
					rent = sqlMsg.getScrewRent();
					price = sqlMsg.getScrewPrice();
				
			}
			Date bDate = sqlMsg.getInitialDate();
			daySum = -(bDate.getTime() - sDate.getTime() + 1000000)
					/ (60 * 60 * 24 * 1000)+1;// ��������
			//�ܽ��
			money=rent*sqlMsg.getAmount()*sqlMsg.getType()*daySum*sqlMsg.getStatus();
			sMoney+=money;
			
			
			
		
			
			
			SBill sb=new SBill();
			sb.setInitialDate(sqlMsg.getInitialDate());//��ʼ����
			sb.setgName(sqlMsg.getName());//Ʒ��
			sb.setType(sqlMsg.getType());//�ͺ�
			sb.setNuit(sqlMsg.getNuit());//��λ
			sb.setAmount(sqlMsg.getAmount());//����
			sb.setFinisDate(sDate);//��������
			sb.setDaySum(daySum);//������
			sb.setPrice(price);//�ۼ�
			sb.setRent(rent);//���
			sb.setMoney(money);//�ܶ�
			sb.setReMark(sqlMsg.getReMark());//��ע
			sb.setsMoney(sMoney);//�ܽ��
			sb.setbNum(sqlMsg.getbNum());//���
			sb.setStatus(sqlMsg.getStatus());//״̬
			set1.add(sb);
			
			
		}
		return set1;

	}
	public ArrayList<SBill> sumBill(int num, String stopDate) throws Exception{
		
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		String[] day=stopDate.split("-");
		day[2]="1";
		String date=day[0]+"-"+day[1]+"-"+day[2];
		Date dDate=sm.parse(date);//Ĭ������
		TreeSet<SBill> ts=search(num, stopDate);
		int sumSteel = 0;//�ֹ�����
		int sumFast = 0;//�ۼ�����
		int sumScrew = 0;//˿������
		double srent=0;
		double frent=0;
		double scrent=0;
		for (SBill s: ts) {
			if(dDate.compareTo(s.getInitialDate())> 0){
				if(s.getgName().equals("�ֹ�")){
					sumSteel+=s.getAmount()*s.getStatus();
					srent=s.getRent();
				}else if(s.getgName().equals("�ۼ�")){
					sumFast+=s.getAmount()*s.getStatus();
					frent=s.getRent();
					
				}else if(s.getgName().equals("˿��")){
					sumScrew+=s.getAmount()*s.getStatus();
					scrent=s.getRent();
				}
				
			}
		}
		
		/**
		 * �ֹ�
		 */
		SBill sb=new SBill();
		sb.setMonth(day[1]+"�½���");
		sb.setgName("�ֹ�");
		sb.setType(1);
		sb.setNuit("��");
		sb.setAmount(sumSteel);
		sb.setInitialDate(dDate);
		sb.setFinisDate(sm.parse(stopDate));
		long daySum = 0;//������
		
		
		daySum = -(dDate.getTime() - sm.parse(stopDate).getTime() + 1000000)
				/ (60 * 60 * 24 * 1000)+1;// ��������
		sb.setDaySum(daySum);
		sb.setRent(srent);
		sb.setMoney(sumSteel*daySum*srent);
		sb.setReMark("");
		/**
		 * �ۼ�
		 */
		SBill sb1=new SBill();
		sb1.setMonth(day[1]+"�½���");
		sb1.setgName("�ۼ�");
		sb1.setType(1);
		sb1.setNuit("��");
		sb1.setAmount(sumFast);
		sb1.setInitialDate(dDate);
		sb1.setFinisDate(sm.parse(stopDate));
		sb1.setDaySum(daySum);
		sb1.setRent(frent);
		sb1.setMoney(sumFast*daySum*frent);
		sb1.setReMark("");
		/**
		 * ˿��
		 */
		SBill sb2=new SBill();
		sb2.setMonth(day[1]+"�½���");
		sb2.setgName("˿��");
		sb2.setType(1);
		sb2.setNuit("��");
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
