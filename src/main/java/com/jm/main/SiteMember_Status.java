package com.jm.main;

import java.util.Date;

public class SiteMember_Status extends SiteMember {
	private Date joinDate;
	private Date birth;
	private int point;
	private String sex;
	
	public SiteMember_Status() {
		// TODO Auto-generated constructor stub
	}

	public SiteMember_Status(Date joinDate, Date birth, int point, String sex) {
		super();
		this.joinDate = joinDate;
		this.birth = birth;
		this.point = point;
		this.sex = sex;
	}
	

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
