package com.ceer.leyrt01;

public class Item {
	private int SerialNumber;// ��Ŀ���
	private String ProjectName;// ��Ŀ����
	private String SteelRent;// �ֹ����
	private String ScrewRent;// ˿�����
	private String FasteningRent;// �ۼ����
	private String SteelPrice;// �ֹ��ۼ�
	private String ScrewPrice;// ˿���ۼ�
	private String FasteningPrice;// �ۼ��ۼ�

	public int getSerialNumber() {
		return SerialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		SerialNumber = serialNumber;
	}

	public String getProjectName() {
		return ProjectName;
	}

	public void setProjectName(String projectName) {
		ProjectName = projectName;
	}

	public String getSteelRent() {
		return SteelRent;
	}

	public void setSteelRent(String steelRent) {
		SteelRent = steelRent;
	}

	public String getScrewRent() {
		return ScrewRent;
	}

	public void setScrewRent(String screwRent) {
		ScrewRent = screwRent;
	}

	public String getFasteningRent() {
		return FasteningRent;
	}

	public void setFasteningRent(String fasteningRent) {
		FasteningRent = fasteningRent;
	}

	public String getSteelPrice() {
		return SteelPrice;
	}

	public void setSteelPrice(String steelPrice) {
		SteelPrice = steelPrice;
	}

	public String getScrewPrice() {
		return ScrewPrice;
	}

	public void setScrewPrice(String screwPrice) {
		ScrewPrice = screwPrice;
	}

	public String getFasteningPrice() {
		return FasteningPrice;
	}

	public void setFasteningPrice(String fasteningPrice) {
		FasteningPrice = fasteningPrice;
	}

	@Override
	public String toString() {
		return "Entity [SerialNumber=" + SerialNumber + ", ProjectName="
				+ ProjectName + ", SteelRent=" + SteelRent + ", ScrewRent="
				+ ScrewRent + ", FasteningRent=" + FasteningRent
				+ ", SteelPrice=" + SteelPrice + ", ScrewPrice=" + ScrewPrice
				+ ", FasteningPrice=" + FasteningPrice + "]";
	}

	public Item() {
		super();
	}

}
