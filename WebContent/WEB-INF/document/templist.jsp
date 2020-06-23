<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- jQuery 2.2.4.min -->
<script type="text/javascript" src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<!-- 부트스트랩 3.3.2 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header.jsp" />
<script type="text/javascript">
$(document).ready(function() {
	// 선택체크 삭제
	$("#btnDelete").click(function() {
		// 선택된 체크박스
		var $checkboxes = $("input:checkbox[name='checkRow']:checked");
		
			
		
		//방법1
		// 체크된 대상들을 하나씩 꺼내서 문자열로 합치기
	//		var names = "";
	//		var len = $checkboxes.length;
	//		$checkboxes.each( function(idx) {
	//			names += $(this).val();
			
	//			if( len-1 != idx ) {
	//				names += ",";
	//			}
	//		});
	//		console.log(names);
	
	
	
		//방법2
		// 체크된 대상들을 map으로 만들고 map을 문자열로 만들기
		var map = $checkboxes.map(function() {
			return $(this).val();
		});
		var names = map.get().join(",");
	//		console.log("names : " + names);
	
	//		console.log($checkboxes);
	//		console.log( "map:" + map );	// 맵
	//		console.log( "map->array : " + map.get() );	// 맵->배열
	//		console.log( "array tostring : " + map.get().join(",") ); // toString
		
	
		
		
		// 전송 폼
		var $form = $("<form>")
			.attr("action", "/board/listDelete")
			.attr("method", "post")
			.append(
				$("<input>")
					.attr("type", "hidden")
					.attr("name", "names")
					.attr("value", names)
			);
		$(document.body).append($form);
		$form.submit();
	
	});
});


//전체 체크/해제
function checkAll() {
	// checkbox들
	var $checkboxes=$("input:checkbox[name='checkRow']");

	// checkAll 체크상태 (true:전체선택, false:전체해제)
	var check_status = $("#checkAll").is(":checked");
	
	if( check_status ) {
		// 전체 체크박스를 checked로 바꾸기
		$checkboxes.each(function() {
			this.checked = true;	
		});
	} else {
		// 전체 체크박스를 checked 해제하기
		$checkboxes.each(function() {
			this.checked = false;	
		});
	}
}
</script>
<style type="text/css">
h3{
	color: #0A2D5D;
	font-weight: bold;
}
.form-control{
	height: 40px;
}
#dolistAppro{
	list-style: none;
	margin: 0;
	padding-left: 20px;
	background: #6794D4;
}

#templist{
	width: 930px;
/* 	padding-left: 15px; */
	padding: 35px;
}
h3{
	margin-top: 10px;
	padding: 0;
}
#dolistcon{
	padding: 20px;
}
.container{
	width: 900px;
}

.form-inline{
	display: inline-block;
}
</style>

		<div id="s_left">

			<ul>
				<ul id="personal">
					<li id="photo" style="border-radius: 100px; padding-top: 5px;"><br>사진</li>
					<li>소속팀 인사1팀 사원 홍길동</li>
					<li>사원번호 1571000367</li>
					<li><button>마이페이지</button> &nbsp;
						<button>로그아웃</button></li>
				</ul>
				<li>첫번째 메뉴
					<ul>

						<li>1</li>
						<li>2</li>
						<li>3</li>

					</ul>

				</li>
				<li>두번째 메뉴
					<ul>

						<li>1</li>
						<li>2</li>
						<li>3</li>

					</ul>
				</li>
				<li>세번째 메뉴
					<ul>

						<li>1</li>
						<li>2</li>
						<li>3</li>

					</ul>
				</li>
				<li>네번째 메뉴
					<ul>

						<li>1</li>
						<li>2</li>
						<li>3</li>

					</ul>
				</li>
				<li>다섯번째 메뉴
					<ul>

						<li>1</li>
						<li>2</li>
						<li>3</li>

					</ul>
				</li>
			</ul>
		</div>
		
<div id="contents">
<div id="templist">

<h3>임시저장함</h3><br>

<input id="someDate" type="date"> ~
 <input id="someDateTime" type="date">
 
&emsp;&emsp;
<div class="form-inline">
<!-- 	<select id="searchType" name="searchType"> -->
<!-- 		<option value="">검색조건</option> -->
<!-- 		<option value="t">제목</option>  -->
<!-- 	</select> -->
	<input class="form-control" type="text" id="keyword" name="keyword" 
		 placeholder="검색어를 입력하세요"/>
	<button id="searchBtn" class="btn btn-primary">Search</button>

</div> 
<br><br>


<div class="container">
<table class="table table-striped table-hover" style="width: 850px;"> <!-- 부트스트랩, table -->
<tr class="active">
	<th><input type="checkbox" id="checkAll" onclick="checkAll();"/></th>
	<th style="width: 10%;">구분</th>
	<th style="width: 20%;">보고일자</th>
	<th style="width: 40%;">제목</th>
	<th style="width: 10%;">부서</th>
	<th style="width: 10%;">직위</th>
	<th style="width: 10%;">보고자</th>
</tr>
<%-- <c:forEach items="${boardList }" var="board"> --%>
<tr>
	<td><input type="checkbox" name="checkRow"/></td>
	<td>기안</td>
<%-- 	<td><fmt:formatDate value="${board.writtendate }" pattern="yyyy-MM-dd"/></td> --%>
	<td>2020-05-23</td>
<%-- 	<td><a href="/board/view?boardno=${doc.doc_num }">${doc.doc_title }</a></td> --%>
	<td>제목1</td>
	<td>부서1</td>
	<td>사원</td>
	<td>이름1</td>
</tr>
<tr>
	<td><input type="checkbox" name="checkRow"/></td>
	<td>기안</td>
<%-- 	<td><fmt:formatDate value="${board.writtendate }" pattern="yyyy-MM-dd"/></td> --%>
	<td>2020-05-23</td>
<%-- 	<td><a href="/board/view?boardno=${doc.doc_num }">${doc.doc_title }</a></td> --%>
	<td>제목2</td>
	<td>부서2</td>
	<td>팀장</td>
	<td>이름2</td>
</tr>
<%-- </c:forEach> --%>
</table>
<button id="btnDelete" class="btn btn-primary">삭제</button>


<c:import url="/WEB-INF/views/layout/paging.jsp"/>
</div> <!-- div.container -->


</div> <!-- templist -->
</div> <!-- contents 닫는태그 -->
	
	
<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />
