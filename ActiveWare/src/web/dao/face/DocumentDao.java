package web.dao.face;

import java.sql.Connection;
import java.util.List;

import web.dto.Document;

public interface DocumentDao {
	
	public List<Document> selectDocTmp();
	
	public List<Document> selectDocWaitAppro();
	
	public List<Document> selectDocProg();
	
	public List<Document> selectDocDraft();

	public List<Document> selectDocAppro();
	
	public List<Document> selectDocAll();
	
	public Document selectDocByDocnum();
	
	public int insertDoc(Connection conn, Document doc);
	
	public int updateDoc(Connection conn, Document doc);
	
	public int deleteDoc(Connection conn, Document doc);
	
	public Document selectDocument(Document doc);
	

}
