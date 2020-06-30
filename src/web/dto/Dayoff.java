package web.dto;

import java.util.Date;

public class Dayoff {

	private int daynum;
	private int userid;
	private Date daystart;
	private Date dayend;
	private String dreason;
	private String dresult;
	
	

	@Override
	public String toString() {
		return "Dayoff [daynum=" + daynum + ", userid=" + userid + ", daystart=" + daystart + ", dayend=" + dayend
				+ ", dreason=" + dreason + ", dresult=" + dresult + "]";
	}
	
	public int getDaynum() {
		return daynum;
	}
	public void setDaynum(int daynum) {
		this.daynum = daynum;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getDaystart() {
		return daystart;
	}
	public void setDaystart(Date daystart) {
		this.daystart = daystart;
	}
	public Date getDayend() {
		return dayend;
	}
	public void setDayend(Date dayend) {
		this.dayend = dayend;
	}
	public String getDreason() {
		return dreason;
	}
	public void setDreason(String dreason) {
		this.dreason = dreason;
	}
	public String getDresult() {
		return dresult;
	}
	public void setDresult(String dresult) {
		this.dresult = dresult;
	}
	
	
	
	
}
