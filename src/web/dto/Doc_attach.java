package web.dto;

public class Doc_attach {
	private int attach_num; 	// 첨부파일번호
	private int doc_num; 		// 문서번호
	private String attach_originname; // 첨부파일명
	private String attach_rename; // 첨부파일명
	private String attach_ext; 	// 첨부파일확장자
	private int attach_size;	// 첨부파일크기
	
	
	

	@Override
	public String toString() {
		return "Doc_attach [attach_num=" + attach_num + ", doc_num=" + doc_num + ", attach_originname="
				+ attach_originname + ", attach_rename=" + attach_rename + ", attach_ext=" + attach_ext
				+ ", attach_size=" + attach_size + "]";
	}

	public int getAttach_num() {
		return attach_num;
	}

	public void setAttach_num(int attach_num) {
		this.attach_num = attach_num;
	}

	public int getDoc_num() {
		return doc_num;
	}

	public void setDoc_num(int doc_num) {
		this.doc_num = doc_num;
	}


	public String getAttach_originname() {
		return attach_originname;
	}

	public void setAttach_originname(String attach_originname) {
		this.attach_originname = attach_originname;
	}

	public String getAttach_rename() {
		return attach_rename;
	}

	public void setAttach_rename(String attach_rename) {
		this.attach_rename = attach_rename;
	}

	public String getAttach_ext() {
		return attach_ext;
	}

	public void setAttach_ext(String attach_ext) {
		this.attach_ext = attach_ext;
	}

	public int getAttach_size() {
		return attach_size;
	}

	public void setAttach_size(int attach_size) {
		this.attach_size = attach_size;
	}
}