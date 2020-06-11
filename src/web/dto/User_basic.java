package web.dto;

public class User_basic {
	private int userid;
	private String username;
	
	@Override
	public String toString() {
		return "User_basic [userid=" + userid + ", username=" + username + "]";
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
}