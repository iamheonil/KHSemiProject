<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

 <br>
 
<input type="text" id="cInput"><br><br>
<input type="button" value="전달" onclick="setChildText()">

  <div class="modal-content">
    <span class="close">&times;</span>
	<h3>문서 처리</h3>
	<table class="table table-bordered" style="width: 100%;">
	<tr>
		<td class="active" id="doc_title">제목</td>
		<td>제목1</td>
	</tr>
	
	<tr>
		<td class="active">처리구분</td>
		<td><input type="radio" id="doc_type" name="doc_title"/>결재</td>
	</tr>
	
	<tr>
	<td class="active">의견/지시</td>
	<td><textarea id="doc_comment"></textarea></td>
	</tr>
	</table>                                                         
<!--     <p>Some text in the Modal..</p> -->

<button>확인</button>
<input type="button" value="창닫기" onclick="window.close()">
<!-- 	<button>닫기</button> -->
  </div>


</body>
</html>