package web.dto;

public class Admin {
	
	private int adminnum; //관리자 사번(아이디 겸함)
	private String adminpw; //관리자 비밀번호
	
	
	@Override
	public String toString() {
		return "Admin [adminnum=" + adminnum + ", adminpw=" + adminpw + "]";
	}
	public int getAdminnum() {
		return adminnum;
	}
	public void setAdminnum(int adminnum) {
		this.adminnum = adminnum;
	}
	public String getAdminpw() {
		return adminpw;
	}
	public void setAdminpw(String adminpw) {
		this.adminpw = adminpw;
	}

}
