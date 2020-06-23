package web.dto;

import java.util.Date;

public class Board {

//	CATEGORY	VARCHAR2(100 BYTE)
	private String category;
	
//	B_NUM	NUMBER
	private int b_num;
	
//	B_TITLE	VARCHAR2(200 BYTE)
	private String b_title;
	
//	B_CONTENT	VARCHAR2(4000 BYTE)
	private String b_content;
	
//	B_DATE	DATE
	private Date b_date;
	
//	HITS	NUMBER
	private int hits;
	
//	USERID	NUMBER(10,0)
	private int userid;
	
//	USERNAME	VARCHAR2(200 BYTE)
	private String username;
	
	private String userrank;
	
	private String dept;

	@Override
	public String toString() {
		return "Board [category=" + category + ", b_num=" + b_num + ", b_title=" + b_title + ", b_content=" + b_content
				+ ", b_date=" + b_date + ", hits=" + hits + ", userid=" + userid + ", username=" + username
				+ ", userrank=" + userrank + ", dept=" + dept + "]";
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getB_num() {
		return b_num;
	}

	public void setB_num(int b_num) {
		this.b_num = b_num;
	}

	public String getB_title() {
		return b_title;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public Date getB_date() {
		return b_date;
	}

	public void setB_date(Date b_date) {
		this.b_date = b_date;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
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
