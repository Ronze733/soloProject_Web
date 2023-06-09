package com.jm.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.jm.main.DBManager;
import com.jm.main.SiteMember;
import com.jm.main.SiteMember_Status;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class LoginDAO {
	
	private static final LoginDAO LOGINDAO = new LoginDAO();
	
	private LoginDAO() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static LoginDAO getLogindao() {
		return LOGINDAO;
	}

	public boolean loginCheck(HttpServletRequest req) {
		SiteMember account = (SiteMember) req.getSession().getAttribute("account");
		
		if(account == null) {
			System.out.println(account);
			req.setAttribute("loginStatus", "./login/login.jsp");
			return false;
		} else {
			System.out.println(account);
			System.out.println(account.getId());
			req.setAttribute("id", account.getId());
			req.setAttribute("loginStatus", "./login/loginOk.jsp");
			return true;
		}
	}

	public void Login(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select m_pw, m_name, m_point, m_pic from solo_project1_site_member where m_id = ?";
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			SiteMember m = null;
			if(rs.next()) {
				if(pw.equals(rs.getString("m_pw"))) {
					String name = rs.getString("m_name");
					int point = rs.getInt("m_point");
					String pic = rs.getString("m_pic");
					
					m = new SiteMember_Status(null, null, point, null);
					m.setName(name);
					m.setPic(pic);
				}
			}
			
			HttpSession hs = request.getSession();
			hs.setAttribute("account", m);
			hs.setMaxInactiveInterval(5 * 60 * 60);
			
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

	public void logout(HttpServletRequest request) {
		HttpSession hs = request.getSession();
		
		hs.setAttribute("account", null);
	}


	public void join(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into solo_project1_site_member values (?, ?, ?, ?, ?, 0, sysdate, ?)";
		String result = "";
		try {
			String savePath = request.getServletContext().getRealPath("imgs");
			MultipartRequest mr = new MultipartRequest(request, savePath, 30 * 1024 * 1024, "utf-8",
					new DefaultFileRenamePolicy());
			String id = mr.getParameter("idJoin");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String birth = mr.getParameter("birth");
			String pic = mr.getFilesystemName("pic");
			String gender = mr.getParameter("gender");
			
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, pic);
			pstmt.setString(5, gender);
			pstmt.setString(6, birth);
			
			if(pstmt.executeUpdate() >= 1)
				result = "등록 성공";
			else
				result = "등록 실패";
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result = "DB 오류";
		} finally {
			DBManager.close(con, pstmt, null);
		}
		System.out.println(result);
		
		
	}


	public void getInformation(HttpServletRequest request) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from solo_project1_site_member where m_id = ?";
		String id = request.getParameter("id");
		System.out.println(id);
		
		try {
			con = DBManager.connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String pw = rs.getString("m_pw");
				String name = rs.getString("m_name");
				System.out.println(name);
				String pic = rs.getString("m_pic");
				String gender = rs.getString("m_sex");
				int point = Integer.parseInt(rs.getString("m_point"));
				Date crDate = rs.getDate("m_createdate");
				Date birth = rs.getDate("m_birth");
				
				SiteMember m = new SiteMember_Status(crDate, birth, point, gender);
				m.setId(id);
				m.setName(name);
				m.setPic(pic);
				request.setAttribute("member", m);
				request.setAttribute("pw", pw);
				System.out.println("가져옴");
			} else
				System.out.println("못 가져옴");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("DB오류");
		} finally {
			DBManager.close(con, pstmt, rs);
		}
		
	}

}
