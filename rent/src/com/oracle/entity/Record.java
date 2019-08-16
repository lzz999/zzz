package com.java.ls1;

import java.util.Date;

import javax.xml.crypto.Data;

public class Record {
	private int record_id;
	
	private int serialNumber;
	private String pattern;
	private double amount;
	private Date paymentTime;
	private String state;
	private String payee;
	
	public int getRecord_id() {
		return record_id;
	}
	public void setRecord_id(int record_id) {
		this.record_id = record_id;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPattern() {
		return pattern;
	}
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getPaymentTime() {
		return paymentTime;
	}
	public void setPaymentTime(Date paymentTime2) {
		this.paymentTime = paymentTime2;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPayee() {
		return payee;
	}
	public void setPayee(String payee) {
		this.payee = payee;
	}
	
	
	
	@Override
	public String toString() {
		return "Record [record_id=" + record_id + ", serialNumber="
				+ serialNumber + ", pattern=" + pattern + ", amount=" + amount
				+ ", paymentTime=" + paymentTime + ", state=" + state
				+ ", payee=" + payee + "]";
	}
	
	public Record( int serialNumber, String pattern,
			double amount, Date paymentTime, String state, String payee,int record_id) {
		super();
		this.record_id = record_id;
		this.serialNumber = serialNumber;
		this.pattern = pattern;
		this.amount = amount;
		this.paymentTime = paymentTime;
		this.state = state;
		this.payee = payee;
	}
	public Record() {
		// TODO 自动生成的构造函数存根
	}
}
