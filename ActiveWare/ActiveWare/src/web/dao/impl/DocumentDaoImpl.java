package web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import web.dao.face.DocumentDao;
import web.dto.Document;
import web.util.Paging;

public class DocumentDaoImpl implements DocumentDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	@Override
	public void insertDoc(Document doc) {
		
	}
	@Override
	public int selectnextDocno() {
		
		return 0;
	}

	@Override
	public int selectTempCntAll() {
		
		return 0;
	}
	@Override
	public int selectTempSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectTempSearch(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectTempAll(Paging paging) {
		
		return null;
	}
	@Override
	public void deleteTemp(Document doc) {
		
	}
	@Override
	public void updateDocument(Document doc) {
		
	}
	@Override
	public int selectWaitApproveCntAll() {
		
		return 0;
	}
	@Override
	public int selectWaitApproveSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectWaitApproveSerach(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectWaitApproveAll(Paging paging) {
		
		return null;
	}
	@Override
	public Document selectDocumentByDocno(Document doc) {
		
		return null;
	}
	@Override
	public int selectProgressCntAll() {
		
		return 0;
	}
	@Override
	public int selectProgressSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectProgressSerach(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectProgressAll(Paging paging) {
		
		return null;
	}
	@Override
	public int selectDraftCntAll() {
		
		return 0;
	}
	@Override
	public int selectDraftSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectDraftSearch(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectDraftAll(Paging paging) {
		
		return null;
	}
	@Override
	public int selectApproveCntAll() {
		
		return 0;
	}
	@Override
	public int selectApproveSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectApproveSearch(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectApproveAll(Paging paging) {
		
		return null;
	}
	@Override
	public int selectDocumentCntAll() {
		
		return 0;
	}
	@Override
	public int selectDocumentSearchCntAll() {
		
		return 0;
	}
	@Override
	public List<Document> selectDocumentAllSearch(String search, Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectDocumentAll(Paging paging) {
		
		return null;
	}
	@Override
	public List<Document> selectDoListWaitApprove() {
		
		return null;
	}
	@Override
	public List<Document> selectDoListProgress() {
		
		return null;
	}


	
	
}