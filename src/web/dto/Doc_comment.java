package web.dto;

import java.sql.Date;

public class Doc_comment {
	private int comm_num;		// 의견/지시 번호
	private int doc_num;		// 문서번호
	private String comm_type;	// 결재종류
	private int receiver_id;	// 결재자
	private String comm_content;// 의견/지시
	private Date comm_date;		// 처리시간
	
	

	@Override
	public String toString() {
		return "Doc_comment [comm_num=" + comm_num + ", doc_num=" + doc_num + ", comm_type=" + comm_type
				+ ", receiver_id=" + receiver_id + ", comm_content=" + comm_content + ", comm_date=" + comm_date + "]";
	}

	public String getComm_type() {
		return comm_type;
	}

	public void setComm_type(String comm_type) {
		this.comm_type = comm_type;
	}

	public int getComm_num() {
		return comm_num;
	}

	public void setComm_num(int comm_num) {
		this.comm_num = comm_num;
	}

	public int getDoc_num() {
		return doc_num;
	}

	public void setDoc_num(int doc_num) {
		this.doc_num = doc_num;
	}

	public int getReceiver_id() {
		return receiver_id;
	}

	public void setReceiver_id(int receiver_id) {
		this.receiver_id = receiver_id;
	}

	public String getComm_content() {
		return comm_content;
	}

	public void setComm_content(String comm_content) {
		this.comm_content = comm_content;
	}

	public Date getComm_date() {
		return comm_date;
	}

	public void setComm_date(Date comm_date) {
		this.comm_date = comm_date;
	}
}