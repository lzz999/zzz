package com.oracle.bill;

import java.util.Date;

public class SqlMsg implements Comparable<SqlMsg>{
	private String name;//����
	private double type;//�ͺ�
	private String nuit;//��λ
	private int amount;//����
	private Date initialDate;//��ʼʱ��
	private double steelRent;//�ֹ����
	private double steelPrice;//�ֹ��ۼ�
	private double screwRent;//˿�����
	private double screwPrice;//˿���ۼ�
	private double fasteningRent;//�ۼ����
	private double fasteningPrice;//�ۼ��ۼ�
	private String reMark;//��ע
	private int bNum;//���
	private int status;//״̬
	private String pName;//��Ŀ��
	
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getType() {
		return type;
	}
	public void setType(double type) {
		this.type = type;
	}
	public String getNuit() {
		return nuit;
	}
	public void setNuit(String nuit) {
		this.nuit = nuit;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public double getSteelRent() {
		return steelRent;
	}
	public void setSteelRent(double steelRent) {
		this.steelRent = steelRent;
	}
	public double getSteelPrice() {
		return steelPrice;
	}
	public void setSteelPrice(double steelPrice) {
		this.steelPrice = steelPrice;
	}
	public double getScrewRent() {
		return screwRent;
	}
	public void setScrewRent(double screwRent) {
		this.screwRent = screwRent;
	}
	public double getScrewPrice() {
		return screwPrice;
	}
	public void setScrewPrice(double screwPrice) {
		this.screwPrice = screwPrice;
	}
	public double getFasteningRent() {
		return fasteningRent;
	}
	public void setFasteningRent(double fasteningRent) {
		this.fasteningRent = fasteningRent;
	}
	public double getFasteningPrice() {
		return fasteningPrice;
	}
	public void setFasteningPrice(double fasteningPrice) {
		this.fasteningPrice = fasteningPrice;
	}
	public String getReMark() {
		return reMark;
	}
	public void setReMark(String reMark) {
		this.reMark = reMark;
	}
	@Override
	public int compareTo(SqlMsg o) {
		if((o.getInitialDate().compareTo(initialDate)>0)){
			return -1;
		}else if((o.getInitialDate().compareTo(initialDate)==0)){
			return o.getbNum()-bNum;
		}else{
			return 1;
		}
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	
}
