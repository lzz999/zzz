package com.oracle.bill;

import java.util.Date;

public class SqlMsg implements Comparable<SqlMsg>{
	private String name;//货名
	private double type;//型号
	private String nuit;//单位
	private int amount;//数量
	private Date initialDate;//开始时间
	private double steelRent;//钢管租价
	private double steelPrice;//钢管售价
	private double screwRent;//丝杠租价
	private double screwPrice;//丝杠售价
	private double fasteningRent;//扣件租价
	private double fasteningPrice;//扣件售价
	private String reMark;//备注
	private int bNum;//编号
	private int status;//状态
	private String pName;//项目名
	
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
