<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/header.jsp"/>
<c:import url="/WEB-INF/views/layout/aside.jsp" />   
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
});


</script>

<script type="text/javascript">
$(document).ready(function(){ //댓글 입력
	
	$("#btnCommInsert").click(function(){
		
		$form = $("<form>").attr({
			action: "/comment/insert",
			method: "post"
		}).append(
			$("<input>").attr({
				type:"hidden",
				name:"b_num",
				value:"${viewBoard.b_num}"
			})	
		).append(
			$("<input>").attr({
				type:"hidden",
				name:"userid",
				value:"${sessionScope.userid }"
			})
		).append(
			$("<textarea>")
			.attr("name", "content")
			.css("display", "none")
			.text($("#commentContent").val())
		);
		$(document.body).append($form);
		$form.submit();
		
		
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
<table>
<tr>
	<th> 글 번호 </th>
	<td> ${viewBoard.b_num }</td>
	<th> 카테고리 </th>
	<td> &nbsp;${viewBoard.category }</td>
</tr>
<tr>
	<th> 부서</th>
	<td>${viewBoard.dept }</td>
	<th> 직급 </th>
	<td>${viewBoard.userrank }</td>
	<th> 작성자 </th>
	<td> &nbsp; ${name }</td>
</tr>
<tr>	
	<th> 제목 </th>
	<td> ${viewBoard.b_title }</td>
</tr>
<tr>
	<th> 조회수 </th>
	<td> ${viewBoard.hits }</td>
	<th> 작성일 </th>
	<td> ${viewBoard.b_date }</td>
</tr>

</table>
<hr>
<table>	
<tr>
	<th>본문</th>
	<td><br>${viewBoard.b_content }</td>
</tr>	
</table>
<div>	
	<c:if test="${userid eq viewBoard.userid }">
		<button id="btnDelete" class="btn btn-danger pull-right">삭제</button>
		<button id="btnUpdate" class="btn btn-info pull-right">수정</button>
	</c:if>
	<button id="btnList" class="btn btn-primary pull-right">목록</button>
<hr>
</div>
<!-- 댓글 처리 -->
<!-- <div> -->
<!-- <hr> -->

<!--  비로그인  -->
<%-- <c:if test="${not login }"> --%>
<!-- <strong>로그인이 필요합니다</strong> -->

<%-- </c:if> --%>

<!--  댓글 입력 -->
<!-- <div class="form-inline"> -->
<%-- 	<input type="text" size="10" class="form-control" id="commentWriter" value="${name }" readonly="readonly"/> --%>
<!-- 	<textarea rows="2" style="resize: none;" cols="60" class="form-control" id="commentContent"></textarea> -->
<!-- 	<button id="btnCommInsert" class="btn">입력</button> -->

<!-- </div> -->


<!--  댓글 리스트  -->
<table>
<tbody id="commentBody">
<c:forEach items="${commentList }" var="comment">
<tr data-c_num="${comment.c_num }">
	<th >[${comment.dept }&nbsp;${comment.userrank }]&nbsp;${name }
	(<fmt:formatDate value="${comment.c_date }" pattern="yy-MM-dd hh:mm" />)
<%-- 		<c:if test="${sessionScope.userid eq comment.userid }"> --%>
		<button class="btn btn-defalut btn-xs"
			onclick="deleteComment(${comment.c_num});">삭제	
		</button>
<%-- 		</c:if> --%>
	</th>
	
</tr>
<tr style="text-align: left;">	<td >${comment.c_content }<hr></td></tr>
</c:forEach>
</tbody>
</table>
<!--  댓글 입력 -->
<table>
<div class="form-inline">
	<input type="text" size="10" class="form-control" id="commentWriter" value="${name }" readonly="readonly"/>
	<textarea rows="3" style="resize: none;" cols="100" class="form-control" id="commentContent"></textarea>
	<button id="btnCommInsert" class="btn">입력</button>
</div>
</table>


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
<c:import url="/WEB-INF/views/layout/footer.jsp"/>
