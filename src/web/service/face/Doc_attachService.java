package web.service.face;

import web.dto.Doc_attach;
import web.dto.Document;

public interface Doc_attachService {
	

	/**
	 * 문서 정보에서 첨부파일 조회
	 * @param doc - 조회할 Documentno를 포함하는 객체
	 * @return Doc_attach - 조회된 첨부파일
	 */
	public Doc_attach getDoc_attach(Document doc);
	
	
	
	
	
	
}