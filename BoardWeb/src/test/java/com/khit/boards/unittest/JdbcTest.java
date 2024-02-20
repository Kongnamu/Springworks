package com.khit.boards.unittest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j //�α�(log) : ����� ����ϴ� ���̺귯��
public class JdbcTest {

	@Test //main �޼���ó�� �����
	public void testConnection() {
		String ClassName = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/springdb?serverTime=Asia/Seoul";
		String username = "springuser";
		String password = "pwspring";
		
		try {
			Class.forName(ClassName);
			Connection con = DriverManager.getConnection(url, username, password);
			//System.out.println("db ���� ��ü ����: " + con);
			log.info("db ���� ��ü ����: " + con);
			
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
