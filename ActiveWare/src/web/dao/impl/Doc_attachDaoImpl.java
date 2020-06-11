package web.dao.impl;

import java.sql.Connection;

import web.dao.face.Doc_attachDao;
import web.dto.Doc_attach;

public class Doc_attachDaoImpl implements Doc_attachDao {

	@Override
	public int insertDoc_attach(Connection conn, Doc_attach doc_attach) {
		
		return 0;
	}

	@Override
	public int updateDoc_attach(Connection conn, Doc_attach doc_attach) {
		
		return 0;
	}

	@Override
	public int deleteDoc_attach(Connection conn, Doc_attach doc_attach) {
		
		return 0;
	}

	@Override
	public Doc_attach selectDocAttach(Doc_attach doc_attach) {
		
		return null;
	}
}