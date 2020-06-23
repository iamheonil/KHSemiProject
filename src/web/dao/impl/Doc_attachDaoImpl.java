package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import web.dao.face.Doc_attachDao;
import web.dto.Doc_attach;
import web.dto.Document;

public class Doc_attachDaoImpl implements Doc_attachDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void insertDoc_attach(Doc_attach doc_attach) {
		
	}

	@Override
	public void deleteDoc_attach(Document doc) {
		
	}

	@Override
	public Doc_attach selectDoc_attachByDoc(Document doc) {
		
		return null;
	}
}