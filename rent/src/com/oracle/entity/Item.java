package com.oracle.entity;

public class Item {
	private int serialNumber;// 项目编号
	private String projectName;// 项目名称
	private String steelRent;// 钢管租价
	private String screwRent;// 丝杠租价
	private String fasteningRent;// 扣件租价
	private String steelPrice;// 钢管售价
	private String screwPrice;// 丝杠售价
	private String fasteningPrice;// 扣件售价

	

	public int getSerialNumber() {
		return serialNumber;
	}



	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}



	public String getProjectName() {
		return projectName;
	}



	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	public String getSteelRent() {
		return steelRent;
	}



	public void setSteelRent(String steelRent) {
		this.steelRent = steelRent;
	}



	public String getScrewRent() {
		return screwRent;
	}



	public void setScrewRent(String screwRent) {
		this.screwRent = screwRent;
	}



	public String getFasteningRent() {
		return fasteningRent;
	}



	public void setFasteningRent(String fasteningRent) {
		this.fasteningRent = fasteningRent;
	}



	public String getSteelPrice() {
		return steelPrice;
	}



	public void setSteelPrice(String steelPrice) {
		this.steelPrice = steelPrice;
	}



	public String getScrewPrice() {
		return screwPrice;
	}



	public void setScrewPrice(String screwPrice) {
		this.screwPrice = screwPrice;
	}



	public String getFasteningPrice() {
		return fasteningPrice;
	}



	public void setFasteningPrice(String fasteningPrice) {
		this.fasteningPrice = fasteningPrice;
	}



	@Override
	public String toString() {
		return "Item [serialNumber=" + serialNumber + ", projectName="
				+ projectName + ", steelRent=" + steelRent + ", screwRent="
				+ screwRent + ", fasteningRent=" + fasteningRent
				+ ", steelPrice=" + steelPrice + ", screwPrice=" + screwPrice
				+ ", fasteningPrice=" + fasteningPrice + "]";
	}



	public Item() {
		super();
	}

}
