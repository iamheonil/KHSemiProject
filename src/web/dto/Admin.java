package web.dto;

public class Admin {
	
	private int adminnum; //관리자 번호
	private String adminid; // 관리자 아이디
	private String adminpw; //관리자 비밀번호
	
	@Override
	public String toString() {
		return "Admin [adminnum=" + adminnum + ", adminid=" + adminid + ", adminpw=" + adminpw + "]";
	}
	
	public int getAdminnum() {
		return adminnum;
	}
	public void setAdminnum(int adminnum) {
		this.adminnum = adminnum;
	}
	public String getAdminid() {
		return adminid;
	}
	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}
	public String getAdminpw() {
		return adminpw;
	}
	public void setAdminpw(String adminpw) {
		this.adminpw = adminpw;
	}
}