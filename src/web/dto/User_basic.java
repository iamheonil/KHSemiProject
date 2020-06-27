package web.dto;

public class User_basic {
	private int basicnum; // 사원번호
	private int userid;		 // 사번
	private String username; // 이름
	private String userrank; //직급
	private String dept; //부서
	
	@Override
	public String toString() {
		return "User_basic [basicnum=" + basicnum + ", userid=" + userid + ", username=" + username + ", userrank="
				+ userrank + ", dept=" + dept + "]";
	}
	
	public int getBasicnum() {
		return basicnum;
	}
	public void setBasicnum(int basicnum) {
		this.basicnum = basicnum;
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