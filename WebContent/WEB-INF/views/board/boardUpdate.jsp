<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:import url="/WEB-INF/views/layout/header_doc.jsp" />
<c:import url="/WEB-INF/views/layout/aside_board.jsp" />

<script type="text/javascript"
 src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8"></script>

<script type="text/javascript">
	//<form>의 submit이 수행되면 스마트에디터의 내용이 <textarea>에 적용됨	
function submitContents(elClickedObj){
	//에디터의 내용을 #content에 반영한다
	oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
	
	try {
		elClickedObj.form.submit();
		
	} catch (e) {
		
	}

}
</script>

 <script type="text/javascript">
 $(document).ready(function(){
	 
	 //작성버튼 동작
	 $("#btnUpdate").click(function(){
		 
		 //스마트에디터 -> textarea에 적용
		 submitContents($("#btnUpdate"));
		 
		//form submit 수행
			$("form").submit();
	 });
	 
		//취소버튼 동작
		$("#btnCancel").click(function() {
			history.go(-1);
		});
 })
 
 
 </script>
 
 <style type="text/css">
#content {
	width: 98%;
}

.container{
	width: 50%;
	height: auto;
}

</style>

<div class="container">

<h3>게시글 수정</h3>
<hr>

<div>
<form action="/board/update" method="post">
<input type="hidden" id="b_num" name="b_num" value="${viewBoard.b_num }" />
<table class="table table-bordered">
<tr><td class="info">카테고리</td>
<td>
<select id="category" name="category">
<c:if test="${userrank == '차장' or userrank == '부장' or userrank == '팀장'}">
 <option value="공지사항">공지사항</option>
</c:if> 
 <option value="스터디">스터디모집</option>
 <option value="사내게시판">사내게시판</option>
</select>

</td>
</tr>

<tr><td class="info">아이디</td><td>${userid }</td></tr>
<tr><td class="info">이름</td><td>${username }</td></tr>
<tr><td class="info">부서</td><td>${userdept }</td></tr>
<tr><td class="info">직급</td><td>${userrank }</td></tr>
<tr><td class="info">제목</td><td><input type="text" name="title" style="width:100%" value="${viewBoard.b_title }"/></td></tr>
<tr><td class="info" colspan="2">내용</td></tr>
<tr><td colspan="2">
	<textarea id="content" name="content" rows="10" cols="100">${viewBoard.b_content }</textarea></td></tr>
</table>

</form>
</div>

<div class="text-center">	
	<button type="button" id="btnUpdate" class="btn btn-info">수정 적용</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>
</div>



<!-- 스마트 에디터를 생성하는 코드 -->
<!-- 스마트 에디터의 스킨을 입히는 코드 -->
<script type="text/javascript">
var oEditors = [];
nhn.husky.EZCreator.createInIFrame({
	oAppRef: oEditors,
	elPlaceHolder: "content",	//<textarea>의 id 를 입력
	sSkinURI: "/resources/se2/SmartEditor2Skin.html",
	fCreator: "createSEditor2",
	htParams: {
		bUseToolbar: true, //툴바 사용여부
		bUseVerticalResizer: false, //입력창 크기 조절 바
		bUseModeChanger: true //글쓰기 모드 탭
	}
});
</script>

<c:import url="/WEB-INF/views/layout/footer.jsp" />
