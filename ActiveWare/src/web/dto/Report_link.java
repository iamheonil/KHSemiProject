package web.dto;

public class Report_link {
	private int link_num;		// 결재번호
	private int doc_num;		// 문서번호
	private int sender_id;		// 보고자 사번
	private int receiver_id;	// 수신자 사번
	private String report_type; // 보고종류 
	private int report_version; // 보고버전
	
	@Override
	public String toString() {
		return "Report_link [link_num=" + link_num + ", doc_num=" + doc_num + ", sender_id=" + sender_id
				+ ", receiver_id=" + receiver_id + ", report_type=" + report_type + ", report_version=" + report_version
				+ "]";
	}

	public int getLink_num() {
		return link_num;
	}

	public void setLink_num(int link_num) {
		this.link_num = link_num;
	}

	public int getDoc_num() {
		return doc_num;
	}

	public void setDoc_num(int doc_num) {
		this.doc_num = doc_num;
	}

	public int getSender_id() {
		return sender_id;
	}

	public void setSender_id(int sender_id) {
		this.sender_id = sender_id;
	}

	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getReport_type() {
		return report_type;
	}

	public void setReport_type(String report_type) {
		this.report_type = report_type;
	}

	public int getReport_version() {
		return report_version;
	}

	public void setReport_version(int report_version) {
		this.report_version = report_version;
	}
}