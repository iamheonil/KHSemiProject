package web.dto;

public class User_basic {
	private int userid;		 // 사번
	private String username; // 이름
	private String userrank; //직급
	private int deptno; //부서번호
	
	@Override
	public String toString() {
		return "User_basic [userid=" + userid + ", username=" + username + ", userrank=" + userrank + ", deptno="
				+ deptno + "]";
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
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
}