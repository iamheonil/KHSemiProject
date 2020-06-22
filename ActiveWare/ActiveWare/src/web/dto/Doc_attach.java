package web.dto;

public class Doc_attach {
	private int attach_num; 	// 첨부파일번호
	private int doc_num; 		// 문서번호
	private String attach_name; // 첨부파일명
	private String attach_ext; 	// 첨부파일확장자
	private int attach_size;	// 첨부파일크기
	
	@Override
	public String toString() {
		return "Doc_attach [attach_num=" + attach_num + ", doc_num=" + doc_num + ", attach_name=" + attach_name
				+ ", attach_ext=" + attach_ext + ", attach_size=" + attach_size + "]";
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

	public String getAttach_name() {
		return attach_name;
	}

	public void setAttach_name(String attach_name) {
		this.attach_name = attach_name;
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