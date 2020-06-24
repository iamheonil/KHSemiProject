package web.util;

public class SearchPaging {
	private int curPage;	//현재 페이지 번호

	private int totalCount;	//총 게시글 수
	private int listCount;	//한 페이지 당 출력될 게시글 수
	private int totalPage;	//총 페이지 수 

	private int pageCount;	//한 화면에 보여질 페이지네이션 수
	private int startPage;	//화면에 보이는 시작 페이지 번호
	private int endPage;	//화면에 보이는 끝 페이지 번호
	
	private int startNo;	//화면에 보이는 페이지의 시작 게시글 번호(rownum)
	private int endNo;		//화면에 보이는 페이지의 끝 게시글 번호(rownum)
	
	private String search; // 검색어
	
	//--- 생성자 4개 ---
	
	//총 게시글 수만 입력하는 생성자
	public SearchPaging(int totalCount) {
		setTotalCount(totalCount);
		
		makePaging();
	}
	
	//위에꺼보다 이걸 많이 쓰게 될거다
	//총 게시글 수, 현재 페이지를 입력하는 생성자
	public SearchPaging(int totalCount, int curPage) {
		setTotalCount(totalCount);
		setCurPage(curPage);
		
		makePaging();
	}
	
	//총 게시글 수, 현재 페이지, 보여질 게시글 수를 입력하는 생성자
	public SearchPaging(int totalCount, int curPage, int listCount) {
		setTotalCount(totalCount);
		setCurPage(curPage);
		setListCount(listCount);
		
		makePaging();
	}

	//총 게시글 수, 현재 페이지, 보여질 게시글 수, 보여질 페이지 수를 입력하는 생성자
	public SearchPaging(int totalCount, int curPage, int listCount, int pageCount) {
		setTotalCount(totalCount);
		setCurPage(curPage);
		setListCount(listCount);
		setPageCount(pageCount);
		
		makePaging();
	}
	
	
	
	//페이징 정보를 생성하는 메소드
	private void makePaging() {
		
		//게시글이 없는 경우
		if(totalCount == 0)	return;
		
		//기본값 설정
		if(curPage == 0)	setCurPage(1); //첫 페이지를 기본값으로 세팅
		if(listCount == 0)	setListCount(10); //화면에 보여질 게시글 수 기본값
		if(pageCount==0)	setPageCount(10); //화면에 보여질 페이지 수 기본값
		
		//총 페이지 수 계산
		totalPage = totalCount / listCount;
		if(totalCount % listCount > 0)	totalPage++;
		
		//현재 페이지 보정값
		//현재 페이지 번호가 총 페이지 수 보다 클 때 마지막 페이지로 고정
		if(curPage > totalPage) curPage = totalPage;
		
		
		//화면에 보여질 페이지네이션의 시작번호와 끝번호
		startPage = ( (curPage-1)/pageCount ) * pageCount + 1;
		endPage = startPage + pageCount - 1;
		
		//끝페이지 번호 보정
		//끝 페이지 번호가 총 페이지 수보다 클 때 마지막 페이지로 고정
		if(endPage > totalPage)	endPage=totalPage;
		
		//화면에 보여질 게시글 시작번호와 끝번호
		startNo = (curPage-1) * listCount + 1;
		endNo = curPage * listCount;
		
	}

	@Override
	public String toString() {
		return "SerachPaging [curPage=" + curPage + ", totalCount=" + totalCount + ", listCount=" + listCount
				+ ", totalPage=" + totalPage + ", pageCount=" + pageCount + ", startPage=" + startPage + ", endPage="
				+ endPage + ", startNo=" + startNo + ", endNo=" + endNo + ", search=" + search + "]";
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
