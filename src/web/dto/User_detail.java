package web.dto;

public class User_detail {
	private int usernum; // 회원번호
	private int userid; // 사번
	private String userphoto_origin; // 프로필사진 원본명
	private String userphoto_rename; // 프로필사진 수정명
	private String userpw; // 비밀번호
	private String userbirth; // 생년월일
	private String usergender; // 성별
	private String userphone; // 휴대전화
	private String useraddr; // 주소
	
	@Override
	public String toString() {
		return "User_detail [usernum=" + usernum + ", userid=" + userid + ", userphoto_origin=" + userphoto_origin
				+ ", userphoto_rename=" + userphoto_rename + ", userpw=" + userpw + ", userbirth=" + userbirth
				+ ", usergender=" + usergender + ", userphone=" + userphone + ", useraddr=" + useraddr + "]";
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

	public String getUserphoto_origin() {
		return userphoto_origin;
	}

	public void setUserphoto_origin(String userphoto_origin) {
		this.userphoto_origin = userphoto_origin;
	}

	public String getUserphoto_rename() {
		return userphoto_rename;
	}

	public void setUserphoto_rename(String userphoto_rename) {
		this.userphoto_rename = userphoto_rename;
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