package com.jm.main;


public class SiteMember_Login extends SiteMember {
	private String pw;
	
	public SiteMember_Login() {
		// TODO Auto-generated constructor stub
	}

	public SiteMember_Login(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
