package com.oracle.bankutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DButils {
	private static final String URL="jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String USER="scott";
	private static final String PASSWORD="tiger";
	/***
	 * ��������
	 */
	static {
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	private Connection conn=null;
	private PreparedStatement ps=null;
	private ResultSet rs=null;
	
	/**
	 * ����
	 * 
	 * @throws SQLException
	 */
	public int preUpdate(String sql,Object...arr) throws SQLException {
		// ps 3.ִ��
		int no=0;
	
			//��������
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			//����ִ�ж���
			//ps 1Ԥ����
			ps=conn.prepareStatement(sql);
			//ps 2.����ֵ
			if(arr!=null) {
				for (int i = 0; i < arr.length; i++) {
					ps.setObject(i+1, arr[i]);
				}
			}
			no = ps.executeUpdate();
		
	
			close();
		
		return no;
	}
	/**
	 * ��ѯ
	 * @throws SQLException 
	 */
	public ResultSet preQuery(String sql,Object...arr) throws SQLException {
		//��������
		
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			//����ִ�ж���
			//ps 1.Ԥ����
			ps=conn.prepareStatement(sql);
			//ps 2.����ֵ
			if(arr!=null) {
				for (int i = 0; i < arr.length; i++) {
					ps.setObject(i+1, arr[i]);
				}
			}
			//ps 3.ִ��
			rs=ps.executeQuery();
		
		return rs;
		
	}
	/**
	 * �ر�
	 */
	public void close() {
		try {
			if(rs!=null) {
				
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(ps!=null) {
				
				ps.close();
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			if(conn!=null) {
				
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
