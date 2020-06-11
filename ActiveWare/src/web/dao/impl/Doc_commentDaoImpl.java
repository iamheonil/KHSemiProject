package web.dao.impl;

import java.sql.Connection;

import web.dao.face.Doc_commentDao;
import web.dto.Doc_comment;

public class Doc_commentDaoImpl implements Doc_commentDao {

	@Override
	public Doc_comment selectDoc_commentByDocnum(int doc_num) {
		
		return null;
	}

	@Override
	public int insertDoc_comment(Connection conn, Doc_comment doc_comment) {
		
		return 0;
	}

	@Override
	public Doc_comment selectDoc_comment(Doc_comment doc_comment) {
		
		return null;
	}
}