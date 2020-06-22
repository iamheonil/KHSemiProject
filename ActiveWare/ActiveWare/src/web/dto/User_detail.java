package web.dto;

public class User_detail {
	private int usernum; // 회원번호
	private int userid; // 사번
	private String userphoto; // 프로필사진
	private String userpw; // 비밀번호
	private String userbirth; // 생년월일
	private String usergender; // 성별
	private String userphone; // 휴대전화
	private String useraddr; // 주소
	
	@Override
	public String toString() {
		return "User_detail [usernum=" + usernum + ", userid=" + userid + ", userphoto=" + userphoto + ", userpw="
				+ userpw + ", userbirth=" + userbirth + ", usergender=" + usergender + ", userphone=" + userphone
				+ ", useraddr=" + useraddr + "]";
	}
	
	public int getUsernum() {
		return usernum;
	}
	public void setUsernum(int usernum) {
		this.usernum = usernum;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserphoto() {
		return userphoto;
	}
	public void setUserphoto(String userphoto) {
		this.userphoto = userphoto;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	public String getUserbirth() {
		return userbirth;
	}
	public void setUserbirth(String userbirth) {
		this.userbirth = userbirth;
	}
	public String getUsergender() {
		return usergender;
	}
	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}
	public String getUseraddr() {
		return useraddr;
	}
	public void setUseraddr(String useraddr) {
		this.useraddr = useraddr;
	}
}