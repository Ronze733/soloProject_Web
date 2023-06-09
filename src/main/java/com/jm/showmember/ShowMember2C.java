package com.jm.showmember;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jm.login.LoginDAO;

@WebServlet("/ShowMember2C")
public class ShowMember2C extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(1);
		
		boolean check = LoginDAO.getLogindao().loginCheck(request);
		
		if(check) {
			System.out.println("true");
			LoginDAO.getLogindao().getInformation(request);
			request.setAttribute("contentPage", "./showMember/showMember.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		} else {
			System.out.println("false");
			String alert = "로그인 후 시도해 주십시오.";
			request.setAttribute("alert", alert);
			
			request.setAttribute("contentPage", "./home.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
