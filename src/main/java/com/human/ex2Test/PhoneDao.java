package com.human.ex2Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PhoneDao {
	private Statement stmt;
	private PreparedStatement psmt;
	private ResultSet rs;
	private MysqlConnectCfg mysqlConn=null;
	private Connection conn=null;

	public PhoneDao(MysqlConnectCfg mc) {
		this.mysqlConn=mc;
	} // 기본생성자

	public boolean insertDB(Phone p) {
		this.conn=mysqlConn.getConn();
		System.out.println("insert 로직.....");
		
		boolean result = false;
		System.out.println(conn);
		if (conn != null) {
			try {
				String sql = "INSERT INTO phone VALUES (?,?,?)";
				// 쿼리 문장을 미리 생성해 놓도 다음에 바인딩해라.. 그리고 완성되면 질의를 던져라..
				psmt = conn.prepareStatement(sql);
				// 바인딩하자
				psmt.setString(1, p.getCom());
				psmt.setString(2, p.getModelName());
				psmt.setString(3, p.getPrice());

				int r = psmt.executeUpdate();

				if (r > 0) {
					result = true;
				}
				psmt.close();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("DB연결 실패");
			System.exit(0);
		}

		return result;
	}

	public void updateDB() {
		System.out.println("update 로직......");
	}

}
