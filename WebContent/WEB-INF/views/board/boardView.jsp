<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />
<c:import url="/WEB-INF/views/layout/aside_board.jsp" />

<script type="text/javascript">

$(document).ready(function() {
	
	// 목록버튼 동작
	$("#btnList").click(function(){
		$(location).attr("href", "/board/list");
	});
	
	$("#btnUpdate").click(function(){
		$(location).attr("href", "/board/update?b_num=${viewBoard.b_num}")
	})
	
	// 삭제버튼 동작
	$("#btnDelete").click(function() {
		$(location).attr("href", "/board/delete?b_num=${viewBoard.b_num}");
	});
	
// 	$("#commentbody").append($("#reply"));
	
	
	
});


</script>

<script type="text/javascript">
$(document).ready(function(){ //댓글 입력
	
// 	$("#btnCommInsert").click(function(){
		
// 		$form = $("<form>").attr({
// 			action: "/comment/insert",
// 			method: "post"
// 		}).append(
// 			$("<input>").attr({
// 				type:"hidden",
// 				name:"b_num",
// 				value:"${viewBoard.b_num}"
// 			})	
// 		).append(
// 			$("<input>").attr({
// 				type:"hidden",
// 				name:"userid",
// 				value:"${sessionScope.userid }"
// 			})
// 		).append(
// 			$("<input>").attr({
// 				type:"hidden",
// 				name:"userrank",
// 				value:"${sessionScope.userrank }"
// 			})		
// 		).append(
// 			$("<textarea>").attr("username", "content")
// 			.css("display", "block")
// 			.text($("#content").val())
// 		);
// 		$(document.body).append($form);
// 		$form.submit();
		
		
// 	});
	$("#btnCommInsert").click(function() {
		//스마트에디터의 내용을<textarea>에 적용하는 함수를 호출한다
		submitContents( $("#btnCommInsert"));
		$("form").submit();
	});
	
});

//댓글 삭제
function deleteComment( c_num ) {
	$.ajax({
		type: "post"
		, url: "/comment/delete"
		, dataType: "json"
		, data: {
			c_num : c_num
		}
		, succes: function(data){
			if(data.succes) {
				
				$("[data-c_num='"+c_num+"']").remove();				
			} else {
				alert("댓글 삭제 실패");
			}
			
		}
		, error: function() {
			console.log("error");
			
		}
	});
	
}


</script>
<div id="contents" class="container">
<div style="border: 1px solid black;">

<div class="padding_view" style="padding: 20px;">


<!-- 카테고리 -->
<div id="b_num" style="text-align: left; font-size: 13px;">
글번호 &nbsp;${viewBoard.b_num } 
</div>
<div class="category" style="text-align: left; font-size: 13px; color:rgb(38, 114, 165);">
	카테고리 &nbsp;[${viewBoard.category }]
</div>

<!-- 제목 -->
<div class="title-area" style="text-align: left; ">
<h3> ${viewBoard.b_title } </h3>
</div>

<!-- 글쓴이 정보 -->
<div class="writer-info" style="text-align: left; font-size: 13px;">
<ul>
<li style="font-weight: bold;">
 ${viewBoard.dept } ${viewBoard.userrank }
 ${name }
</li>

<li>
${viewBoard.b_date } 조회수 &nbsp; ${viewBoard.hits }
	<c:if test="${userid eq viewBoard.userid }">
		<button id="btnDelete" class="btn btn-danger pull-right" onclick="alert('삭제되었습니다.');">삭제</button>
		<button id="btnUpdate" class="btn btn-info pull-right">수정</button>
	</c:if>
	<button id="btnList" class="btn btn-primary pull-right">목록</button>
</li>
</ul>
</div>

<div id="content" style="text-align: left;">

<ul>
<li>
<hr>
${viewBoard.b_content }
</li>
</ul>

</div>


<hr>
<!-- 댓글 처리 -->
<!-- <div> -->
<!-- <hr> -->




<!--  댓글 리스트  -->
<!-- <table> -->
<!-- <tbody id="commentBody"> -->
<%-- <c:forEach items="${commentList }" var="comment"> --%>
	
<%-- 	<div style="border: 1px solid gray; width: 600px; padding: 5px; margin-top: 5px; --%>
<%-- 		margin-left: <c:out value="${20*comment.c_depth }"/>px; display: inline-block"> --%>
<%-- 		<c:out value="${comment.dept }"/><c:out value="${comment.userrank }"/><c:out value="${comment.username }"/> --%>
<%-- 		(<fmt:formatDate value="${comment.c_date }" pattern="yy-MM-dd hh:mm" />) --%>
<%-- 		<c:out value="${comment.c_num }"/> --%>
<!-- 		</div> -->
<%-- 		<c:if test="${sessionScope.userid eq comment.userid }"> --%>
<!-- 		<button class="btn btn-defalut btn-xs" -->
<%-- 			onclick="alert('삭제되었습니다.'); deleteComment(${comment.c_num}); history.go(0);">삭제	 --%>
<!-- 		</button> -->
<%-- 		</c:if> --%>

<%-- <tr style="text-align: left;" id="content"><td>${comment.c_content }<hr></td></tr> --%>
		
<%-- </c:forEach> --%>


<!-- </tbody> -->
<!-- </table> -->
<table>
<tbody id="commentBody">
<c:forEach items="${commentList }" var="comment">

	<tr data-c_num="${comment.c_num }">
		<th>[${comment.dept }&nbsp;${comment.userrank }]&nbsp;${comment.username }
	(<fmt:formatDate value="${comment.c_date }" pattern="yy-MM-dd HH:mm" />)
		
		
		<c:if test="${sessionScope.userid eq comment.userid }">
		<button class="btn btn-default btn-xs"
			onclick="alert('삭제되었습니다.'); deleteComment(${comment.c_num}); history.go(0);">삭제	
		</button>
		</c:if>
		
	</th>
</tr>
<tr style="text-align: left;" id="content"><td>${comment.c_content }</td></tr>
</c:forEach>
</tbody>
</table>


<!-- <table id="reply" class="reply"  style="margint-left: 100px;"> -->
<%-- 	<c:forEach items="${commentList }" var="comment"> --%>
<!-- 	<th> -->
<%-- 		<c:if test="${comment.c_num eq comment.parent}"> --%>
<%-- 		  <th>[${comment.dept }&nbsp;${comment.userrank }]&nbsp;${comment.username } --%>
<%-- 		  	(<fmt:formatDate value="${comment.c_date }" pattern="yy-MM-dd" />) --%>
<%-- 				<c:if test="${sessionScope.userid eq comment.userid }"> --%>
<!-- 				<button class="btn btn-default btn-xs" -->
<%-- 					onclick="alert('삭제되었습니다.'); deleteComment(${comment.c_num}); history.go(0);">삭제	 --%>
<!-- 				</button> -->
<%-- 				</c:if>	 --%>
<!-- 		  </th>	 -->
<%-- 		</c:if> --%>
<!-- 	</th> -->
<%-- 	</c:forEach> --%>
<!-- </table> -->


<!-- ---------------------망한 대댓글 ---------------------- -->
<!-- <table> -->
<!-- <tbody id="c_c"> -->
<%-- <c:forEach items="${c_commentList}" var="c_comment"> --%>
<%-- <input type="hidden" class="c_num" id="c_num" name="c_num" value="${c_comment.c_cnum }"/> --%>
<%-- <tr data-c_num="${c_comment.c_num }"> --%>
<%-- 	<th>[${c_comment.dept }&nbsp;${c_comment.userrank }]&nbsp;${c_comment.username } --%>
<%-- 	(<fmt:formatDate value="${c_comment.c_cdate }" pattern="yy-MM-dd hh:mm" />) --%>

<%-- 		<c:if test="${sessionScope.userid eq c_comment.userid }"> --%>
<!-- 		<button class="btn btn-default btn-xs" -->
<%-- 			onclick="alert('삭제되었습니다.'); deleteComment(${c_comment.c_cnum}); history.go(0)">삭제 --%>
<!-- 			</button> -->
<%-- 		</c:if> --%>

<!-- 	</th> -->
<!-- </tr> -->
<%-- <tr style="text-align: left;" id="c_content"><td>${c_comment.c_ccontent }</td></tr> --%>
<%-- </c:forEach> --%>
<!-- </tbody> -->
<!-- </table> -->




<!-----------  댓글 입력  -------------->
<table>
<!--  비로그인  -->
<c:if test="${not login }">
<strong>로그인이 필요합니다</strong>
</c:if>



</table>
<form action="/comment/insert" method="post">
<div class="form-inline">
	<input type="hidden" class="form-control" id="b_num" name="b_num" value="${viewBoard.b_num }" readonly="readonly"/>
	<input type="hidden" class="form-control" id="userid" name="userid" value="${sessionScope.userid }" readonly="readonly"/>
	<input type="hidden" class="form-control" id="userdept" name="userdept" value="${sessionScope.userdept }" readonly="readonly"/>
	<input type="hidden" class="form-control" id="userrank" name="userrank" value="${sessionScope.userrank }" readonly="readonly"/>
	<input type="text" size="8" class="form-control" id="comment" name="username" value="  ${username }" readonly="readonly"/>
	<textarea rows="3" style="resize: none" cols="80" class="form-control" id="content" name="content"></textarea>
	<c:if test="${login }">
	<button id="btnCommInsert" class="btn">입력</button>
	</c:if>
</div>
</form>

<!-- <tbody id="commentBody"> -->
<%-- <c:forEach items="${commentList }" var="comment"> --%>
<%-- <tr data-c_num="${comment.c_num }"> --%>
<%-- 	<td>${comment.rnum }</td> --%>
<%-- 	<td>${comment.userid }</td> --%>
<%-- 		<c:if test="${sessionScope.userid eq comment.userid }"> --%>
<!-- </tr> -->
<%-- </c:forEach> --%>
<!-- </tbody> -->
</div>

</div>
</div>
<c:import url="/WEB-INF/views/layout/footer.jsp"/>
