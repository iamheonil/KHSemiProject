<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/header.jsp" />

<script type="text/javascript" src="/resources/se2/js/service/HuskyEZCreator.js" charset="utf-8">
</script>

<script type="text/javascript">
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
$(document).ready(function() {
	
	//작성버튼 동작
	$("#btnWrite").click(function() {
		//스마트에디터의 내용을<textarea>에 적용하는 함수를 호출한다
		submitContents( $("#btnWrite"));
		$("form").submit();
	});
	
	//취소버튼 동작
	$("#btnCancel").click(function() {
		history.go(-1);
	});
});
</script>

<style type="text/css">
#content {
	width: 100%;
	height: 100px;
	realize:none;
	
}

</style>

<div>

<h3>게시글 작성</h3>
<hr>

<div>
<form action="/board/insert" method="post">

<table class="table table-bordered">
<tr><td class="info">카테고리</td>
<td>
<select id="category" name="category">
 <option value="공지사항">공지사항</option>
 <option value="스터디">스터디</option>
 <option value="자유수다">자유수다</option>
</select>
</td>
</tr>
<tr><td class="info">아이디</td><td>${userid }</td></tr>
<tr><td class="info">이름</td><td>${username }</td></tr>
<tr><td class="info">제목</td><td><input type="text" name="title" style="width:100%"/></td></tr>
<tr><td class="info">내용</td></tr>
<tr><td colspan="2"><textarea id="content" name="content"></textarea></td></tr>
</table>
</form>

</div>

<div class="text-center">	
	<button type="button" id="btnWrite" class="btn btn-info">작성</button>
	<button type="button" id="btnCancel" class="btn btn-danger">취소</button>
</div>
</div>

<c:import url="/WEB-INF/views/layout/footer.jsp" />

<script type="text/javascript">
var oEditors = [];

nhn.husky.EZCreator.createInIFrame({
	oAppRef : oEditors
	, elPlaceHolder : "content" //에디터가 적용될 <textarea>의 id
	, sSkinURI : "/resources/se2/SmartEditor2Skin.html" //에디터 스킨
	, fCreator : "createSEditor2"
})

</script>


