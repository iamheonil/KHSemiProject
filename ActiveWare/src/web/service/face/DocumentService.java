package web.service.face;

import java.sql.Connection;
import java.util.List;

import web.dto.Document;

public interface DocumentService {
	
	public List<Document> selectDocTmp();
	
	public List<Document> selectDocWaitAppro();
	
	public List<Document> selectDocProg();
	
	public List<Document> selectDocDraft();

	public List<Document> selectDocAppro();
	
	public List<Document> selectDocAll();
	
	public Document selectDocByDocnum();
	
	public void insertDoc(Connection conn, Document doc);
	
	public void updateDoc(Connection conn, Document doc);
	
	public void deleteDoc(Connection conn, Document doc);
	
	public Document selectDocument(Document doc);

}
