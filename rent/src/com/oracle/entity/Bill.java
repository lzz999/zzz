package View;

import java.util.Date;



//实体类 ,用于打包输入的信息,并验证输入的信息是否正确,最后统一放入数据库
public class Bill {
private int SERIALNUMBER;
private double NUIT;
private String TYPE;
private int  STATUS;
private Date INITIALDATE;
private String NAME;
private int AMOUNT;
private String CONTRACTOR;
private String REMARK;
private int NUMERICAL;
public int getSERIALNUMBER() {
	return SERIALNUMBER;
}
public void setSERIALNUMBER(int sERIALNUMBER) {
	SERIALNUMBER = sERIALNUMBER;
}
public double getNUIT() {
	return NUIT;
}
public void setNUIT(double nUIT) {
	NUIT = nUIT;
}
public String getTYPE() {
	return TYPE;
}
public void setTYPE(String tYPE) {
	TYPE = tYPE;
}
public int getSTATUS() {
	return STATUS;
}
public void setSTATUS(int sTATUS) {
	STATUS = sTATUS;
}
public Date getINITIALDATE() {
	return INITIALDATE;
}
public void setINITIALDATE(Date iNITIALDATE) {
	INITIALDATE = iNITIALDATE;
}
public String getNAME() {
	return NAME;
}
public void setNAME(String nAME) {
	NAME = nAME;
}
public int getAMOUNT() {
	return AMOUNT;
}
public void setAMOUNT(int aMOUNT) {
	AMOUNT = aMOUNT;
}
public String getCONTRACTOR() {
	return CONTRACTOR;
}
public void setCONTRACTOR(String cONTRACTOR) {
	CONTRACTOR = cONTRACTOR;
}
public String getREMARK() {
	return REMARK;
}
public void setREMARK(String rEMARK) {
	REMARK = rEMARK;
}
public int getNUMERICAL() {
	return NUMERICAL;
}
public void setNUMERICAL(int nUMERICAL) {
	NUMERICAL = nUMERICAL;
}
@Override
public String toString() {
	return "Bill [SERIALNUMBER=" + SERIALNUMBER + ", NUIT=" + NUIT + ", TYPE="
			+ TYPE + ", STATUS=" + STATUS + ", INITIALDATE=" + INITIALDATE
			+ ", NAME=" + NAME + ", AMOUNT=" + AMOUNT + ", CONTRACTOR="
			+ CONTRACTOR + ", REMARK=" + REMARK + ", NUMERICAL=" + NUMERICAL
			+ "]";
}




}
