package web.dto;

import java.util.Date;

public class Board_comment {
	
	//rownum
	private int rnum;
	
	//	c_num	NUMBER
	private int c_num;
	
//	b_num	NUMBER
	private int b_num;
	
//	c_date	DATE
	private Date c_date;
	
//	c_content	VARCHAR2(500)
	private String c_content;
	
//	userid	NUMBER(10)
	private int userid;
	
//	username	VARCHAR2(200)
	private String username;

	private String userrank;
	
	private String dept;

	@Override
	public String toString() {
		return "Board_comment [rnum=" + rnum + ", c_num=" + c_num + ", b_num=" + b_num + ", c_date=" + c_date
				+ ", c_content=" + c_content + ", userid=" + userid + ", username=" + username + ", userrank="
				+ userrank + ", dept=" + dept + "]";
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getC_num() {
		return c_num;
	}

	public void setC_num(int c_num) {
		this.c_num = c_num;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public Date getC_date() {
		return c_date;
	}

	public void setC_date(Date c_date) {
		this.c_date = c_date;
	}

	public String getC_content() {
		return c_content;
	}

	public void setC_content(String c_content) {
		this.c_content = c_content;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserrank() {
		return userrank;
	}

	public void setUserrank(String userrank) {
		this.userrank = userrank;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	

	
	
	
}
