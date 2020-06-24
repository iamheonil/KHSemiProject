package web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import web.dao.face.Doc_commentDao;
import web.dao.impl.Doc_commentDaoImpl;
import web.dto.Doc_comment;
import web.dto.Document;
import web.service.face.Doc_commentService;

public class Doc_commentServiceImpl implements Doc_commentService {

	private Doc_commentDao doc_commentDao = new Doc_commentDaoImpl();
	
	@Override
	public ArrayList<Map<String, Object>> getDoc_comment(Document doc) {
		return doc_commentDao.selectDoc_commentByDocno(doc);
	}

}