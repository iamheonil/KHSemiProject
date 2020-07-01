package web.service.impl;

import java.util.ArrayList;
import java.util.Map;

import web.dao.face.Doc_commentDao;
import web.dao.face.DocumentDao;
import web.dao.impl.Doc_commentDaoImpl;
import web.dao.impl.DocumentDaoImpl;
import web.dto.Doc_comment;
import web.dto.Document;
import web.service.face.Doc_commentService;

public class Doc_commentServiceImpl implements Doc_commentService {

	private Doc_commentDao doc_commentDao = new Doc_commentDaoImpl();
	private DocumentDao documentDao = new DocumentDaoImpl(); 
	
	@Override
	public ArrayList<Map<String, Object>> getDoc_comment(Document doc) {
		return doc_commentDao.selectDoc_commentByDocno(doc);
	}

	@Override
	public void insertDoc_comment(Doc_comment comm) {
		doc_commentDao.insertDoc_comment(comm);
	}
	
	@Override
	public void updateDoc_comment(Doc_comment comm) {
		
		doc_commentDao.updateDoc_comment(comm);
		
		
		if(comm.getComm_type().equals("중단")) {
			documentDao.updateDocStateStop(comm);
		}
		
		
		if(doc_commentDao.getMaxCommNumByDocNum(comm) > 0) {
			documentDao.updateDocState(comm);
		}
			
	}
	
	

}