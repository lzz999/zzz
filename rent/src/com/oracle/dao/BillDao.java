package View;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

//Dao层   对于原始单据的增删改查 功能均放于此类

public class Bill_DAO {
String sql="select *  from BILL where SERIALNUMBER=?"; //根据项目编号查询当前项目的所有单据信息
String sql1="delete from BILL where  BILL_LIST=?";   //删除语句 ,判定条件按照BILL的序列号,进行删除

String sql2="insert into BILL(SERIALNUMBER,NUIT,TYPE,STATUS,INITIALDATE,NAME,AMOUNT,CONTRACTOR,REMARK,BILL_LIST) values(?,?,?,?,?,?,?,?,?,BILL_LIST.nextval)";
String sql3="delete from BILL where BILL_LIST=?";
String sql4="update BILL set INITIALDATE=?,NUIT=?,AMOUNT=?,CONTRACTOR=? ,REMARK=? where BILL_LIST=?";
DButils du=new DButils();
	
//查询单据方法
public ResultSet serch (int num) throws SQLException{
		
	ResultSet rs=du.preQuery(sql, num);
	
	return rs;
	
}
//增加单据的方法
public boolean add(Bill bill) throws SQLException{
	int SERIALNUMBER=1;                           //项目编号在这里
	double NUIT=bill.getNUIT();
	String TYPE=bill.getTYPE();
	int STATUS=bill.getSTATUS();
	SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
	String dateString = dd.format(bill.getINITIALDATE());
	String INITIALDATE=(dateString);
	String NAME=bill.getNAME();
	int AMOUNT=bill.getAMOUNT();
	String CONTRACTOR=bill.getCONTRACTOR();
	String REMARK=bill.getREMARK();
	du.preUpdate(sql2, SERIALNUMBER,NUIT,TYPE,STATUS,INITIALDATE,NAME,AMOUNT,CONTRACTOR,REMARK);
	
	return false;
}

//删除方法

public void del(  int list     ) throws SQLException{
	
	du.preUpdate(sql3, list);
	
}

//修改方法
public void modify(String date,double NUIT,int AMOUNT,String CONTRACTOR,String REMARK,int BILL_LIST) throws SQLException{
	du.preUpdate(sql4, date,NUIT,AMOUNT,CONTRACTOR,REMARK,BILL_LIST);
	
	
}

	
}
