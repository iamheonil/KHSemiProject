package web.dto;

import java.util.Date;

public class Document {
	
	private int doc_num; //문서번호
	private String doc_title; //문서제목
	private String doc_substance; //문서요지
	private String doc_content; //문서본문
	private String doc_state; //문서상태
	private int userid; //작성자 사번
	private Date doc_date; //작성일시
	private String doc_emergency; //긴급여부
	
	
	@Override
	public String toString() {
		return "Document [doc_num=" + doc_num + ", doc_title=" + doc_title + ", doc_substance=" + doc_substance
				+ ", doc_content=" + doc_content + ", doc_state=" + doc_state + ", userid=" + userid + ", doc_date="
				+ doc_date + ", doc_emergency=" + doc_emergency + "]";
	}
	public int getDoc_num() {
		return doc_num;
	}
	public void setDoc_num(int doc_num) {
		this.doc_num = doc_num;
	}
	public String getDoc_title() {
		return doc_title;
	}
	public void setDoc_title(String doc_title) {
		this.doc_title = doc_title;
	}
	public String getDoc_substance() {
		return doc_substance;
	}
	public void setDoc_substance(String doc_substance) {
		this.doc_substance = doc_substance;
	}
	public String getDoc_content() {
		return doc_content;
	}
	public void setDoc_content(String doc_content) {
		this.doc_content = doc_content;
	}
	public String getDoc_state() {
		return doc_state;
	}
	public void setDoc_state(String doc_state) {
		this.doc_state = doc_state;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Date getDoc_date() {
		return doc_date;
	}
	public void setDoc_date(Date doc_date) {
		this.doc_date = doc_date;
	}
	public String getDoc_emergency() {
		return doc_emergency;
	}
	public void setDoc_emergency(String doc_emergency) {
		this.doc_emergency = doc_emergency;
	}
	
	
	
	

}
