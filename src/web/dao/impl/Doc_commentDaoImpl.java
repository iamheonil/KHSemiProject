package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import web.dao.face.Doc_commentDao;
import web.dto.Doc_comment;
import web.dto.Document;

public class Doc_commentDaoImpl implements Doc_commentDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	@Override
	public void deleteDoc_comment(Document doc) {
		
	}

	@Override
	public Doc_comment selectDoc_commentByDocno(Document doc) {
		return null;
	}

	@Override
	public void insertDoc_comment(Doc_comment doc_comment) {
		
	}
}