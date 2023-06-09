package com.jm.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

import com.jm.main.DBManager;

public class JoinDAO {
	private static final JoinDAO JOINDAO = new JoinDAO();
	
	private JoinDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static JoinDAO getJoindao() {
		return JOINDAO;
	}


	public void duplicateCheck(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String id = request.getParameter("idJoin");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select m_id from solo_project1_site_member where m_id = ?";
		String result = null;
		String resulti = null;
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = "존재하는 ID입니다.";
				resulti = "1";
			}
			else {
				result = "사용 가능한 ID입니다.";
				resulti = "2";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "DB오류";
			resulti = "3";
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		request.setAttribute("result", result);
		request.setAttribute("resultI", resulti);
	}

}
