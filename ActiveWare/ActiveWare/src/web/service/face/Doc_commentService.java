package web.service.face;

import web.dto.Doc_comment;
import web.dto.Document;

public interface Doc_commentService {

	/**
	 * 문서 정보에서 의견/지시 조회
	 * @param doc - 조회할 Documentno를 포함하는 객체
	 * @return Doc_comment - 조회된 의견/지시 객체
	 */
	public Doc_comment getDoc_comment(Document doc);
	
	
	
	
}