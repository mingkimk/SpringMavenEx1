package com.human.ex2Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlConnectCfg {

	private Connection conn;

	private String className=null;
	private String id=null;
	private String url = null;
	private String pwd=null;
	
	MysqlConnectCfg(String cName, String id, String url, String pwd) {
		this.className=cName;
		this.id=id;
		this.url=url;
		this.pwd=pwd;
		conn();
	}
	
	MysqlConnectCfg() {
		conn();
	}
	public void conn() {
		try{
			// 1. 드라이버 로딩
			// 드라이버 인터페이스를 구현한 클래스를 로딩
			// mysql, oracle 등 각 벤더사 마다 클래스 이름이 다르다.
			// mysql은 "com.mysql.jdbc.Driver"이며, 이는 외우는 것이 아니라 구글링하면 된다.
			// 참고로 이전에 연동했던 jar 파일을 보면 com.mysql.jdbc 패키지에 Driver 라는 클래스가 있다.
			Class.forName(className);
			// 2. 연결하기
			// 드라이버 매니저에게 Connection 객체를 달라고 요청한다.
			// Connection을 얻기 위해 필요한 url 역시, 벤더사마다 다르다.
			// mysql은 "jdbc:mysql://localhost/사용할db이름" 이다.
			// @param getConnection(url, userName, password);
			// @return  Connection
			conn = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결 성공");
		}catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패");
		}catch(SQLException e){
			System.out.println("에러: " + e);
		}/*finally{
			try{
				if( conn != null && !conn.isClosed()){
					conn.close();
				}
			}
			catch( SQLException e){
				e.printStackTrace();
			}
		}*/
	}
	
	public String getUrl() {
		return url;
	}

	public Connection getConn() {
		return conn;
	}


}
