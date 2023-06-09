package com.jm.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// db관련 작업을 할때 연결 코드를 쓴 이후에 작업 해옴
// 다 쓰면 닫음

// AOP 적용하기
public class DBManager {

	// db 작업시엔 어쨋든 연결 해야 함
	public static Connection connect() throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "c##jm";
		String pw = "jm";

		return DriverManager.getConnection(url, id, pw);
	}

	// 닫을게 많은데 한번에 닫기

	public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if(pstmt != null)
				pstmt.close();
			if(con != null)
				con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
