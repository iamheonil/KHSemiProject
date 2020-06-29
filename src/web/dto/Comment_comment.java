package web.dto;

import java.util.Date;

public class Comment_comment {

	//rownum
	private int rnum;
	
	// C_num number
	private int c_num;
	
	// C_cnum number
	private int c_cnum;
	
	private Date c_cdate;
	
	private String c_ccontent;
	
	private int userid;
	
	private String username;
	
	private String userrank;
	
	private String dept;

	@Override
	public String toString() {
		return "Comment_comment [rnum=" + rnum + ", c_num=" + c_num + ", c_cnum=" + c_cnum + ", c_cdate=" + c_cdate
				+ ", c_ccontent=" + c_ccontent + ", userid=" + userid + ", username=" + username + ", userrank="
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

	public int getC_cnum() {
		return c_cnum;
	}

	public void setC_cnum(int c_cnum) {
		this.c_cnum = c_cnum;
	}

	public Date getC_cdate() {
		return c_cdate;
	}

	public void setC_cdate(Date c_cdate) {
		this.c_cdate = c_cdate;
	}

	public String getC_ccontent() {
		return c_ccontent;
	}

	public void setC_ccontent(String c_ccontent) {
		this.c_ccontent = c_ccontent;
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
