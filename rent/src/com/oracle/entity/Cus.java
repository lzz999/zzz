package com.oracle.entity;
/**
 * ʵ����
 * @author Administrator
 *
 */
public class Cus {
private String name;//�û���Ψһ
private String pass;//����
private String password;//ȷ������
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPass() {
	return pass;
}
public void setPass(String pass) {
	this.pass = pass;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Cus [name=" + name + ", pass=" + pass + ", password=" + password
			+ "]";
}
public Cus() {
	super();
}
public Cus(String name, String pass, String password) {
	// TODO Auto-generated constructor stub
	this.name=name;
	this.pass=pass;
	this.password=password;
}
public Cus(String name, String pass) {
	// TODO Auto-generated constructor stub
   this.pass=pass;
   this.name=name;
}

}
