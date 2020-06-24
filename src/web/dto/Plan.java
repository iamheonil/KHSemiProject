package web.dto;

import java.util.Date;

public class Plan {

	private int plan_num;
	private int userid;
	private String plan_name;
	private Date ptime_start;
	private Date ptime_end;

	@Override
	public String toString() {
		return "Plan [plan_num=" + plan_num + ", userid=" + userid + ", plan_name=" + plan_name + ", ptime_start="
				+ ptime_start + ", ptime_end=" + ptime_end + "]";
	}

	public int getPlan_num() {
		return plan_num;
	}

	public void setPlan_num(int plan_num) {
		this.plan_num = plan_num;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	public Date getPtime_start() {
		return ptime_start;
	}

	public void setPtime_start(Date ptime_start) {
		this.ptime_start = ptime_start;
	}

	public Date getPtime_end() {
		return ptime_end;
	}

	public void setPtime_end(Date ptime_end) {
		this.ptime_end = ptime_end;
	}

}
