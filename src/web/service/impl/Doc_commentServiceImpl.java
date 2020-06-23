package web.service.impl;

import web.dao.face.Doc_commentDao;
import web.dao.impl.Doc_commentDaoImpl;
import web.dto.Doc_comment;
import web.dto.Document;
import web.service.face.Doc_commentService;

public class Doc_commentServiceImpl implements Doc_commentService {

	private Doc_commentDao doc_commentDao = new Doc_commentDaoImpl();
	
	@Override
	public Doc_comment getDoc_comment(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

}