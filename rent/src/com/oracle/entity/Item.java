package com.oracle.entity;

public class Item {
	private int serialNumber;// ��Ŀ���
	private String projectName;// ��Ŀ����
	private String steelRent;// �ֹ����
	private String screwRent;// ˿�����
	private String fasteningRent;// �ۼ����
	private String steelPrice;// �ֹ��ۼ�
	private String screwPrice;// ˿���ۼ�
	private String fasteningPrice;// �ۼ��ۼ�

	

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
