package com.oracle.bill;

import java.util.Date;

public class SBill implements Comparable<SBill>{
	private String gName;//����
	private String nuit;//��λ
	private double  type;//�ͺ�
	private double amount;//����
	private Date initialDate;//��ʼʱ��
	private Date finisDate;//����ʱ��
	private long daySum;//����
	private double rent;//���
	private double price;//����
	private double money;//���
	private String reMark;//��ע
	private int bNum;//���
	private int status;//״̬
	private double sMoney;//�ܽ��
	private String month;//�����·�
 
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	private String pName;//��Ŀ��

	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public int getbNum() {
		return bNum;
	}
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getNuit() {
		return nuit;
	}
	public void setNuit(String nuit) {
		this.nuit = nuit;
	}
	public double getType() {
		return type;
	}
	public void setType(double type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinisDate() {
		return finisDate;
	}
	public void setFinisDate(Date finisDate) {
		this.finisDate = finisDate;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public String getReMark() {
		return reMark;
	}
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
	public long getDaySum() {
		return daySum;
	}
	public void setDaySum(long daySum) {
		this.daySum = daySum;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public double getsMoney() {
		return sMoney;
	}
	public void setsMoney(double sMoney) {
		this.sMoney = sMoney;
	}
	@Override
	public int compareTo(SBill o) {
		if((o.getInitialDate().compareTo(initialDate)>0)){
			return -1;
		}else if((o.getInitialDate().compareTo(initialDate)==0)){
			return o.getbNum()-bNum;
		}else{
			return 1;
		}
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	
	}
	
	
	


