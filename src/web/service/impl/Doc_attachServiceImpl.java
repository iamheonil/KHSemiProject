package web.service.impl;

import web.dao.face.Doc_attachDao;
import web.dao.impl.Doc_attachDaoImpl;
import web.dto.Doc_attach;
import web.dto.Document;
import web.service.face.Doc_attachService;

public class Doc_attachServiceImpl implements Doc_attachService {

	private Doc_attachDao doc_attachDao = new Doc_attachDaoImpl();
	
	@Override
	public Doc_attach getDoc_attach(Document doc) {
		
		return doc_attachDao.selectDoc_attachByDoc(doc);
	}

}