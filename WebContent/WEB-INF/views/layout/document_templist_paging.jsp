<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="text-center">
<ul class="pagination pagination-sm">

	<!-- 첫 페이지로 가기 -->
	<c:if test="${paging.curPage ne 1 }"><!-- 첫 페이지가 아닐 때 보여줌 -->
	<li><a href="/document/list/all?search=${param.search }">&larr;</a></li>
	</c:if>
	
	
	
	<!-- 이전 페이징 리스트로 가기 -->
	<c:if test="${paging.startPage gt paging.pageCount }">
	<li><a href="/document/list/all?curPage=${paging.startPage - paging.pageCount }&search=${param.search }">&laquo;</a></li>
	</c:if>

	<c:if test="${paging.startPage le paging.pageCount }">
	<li class="disabled"><a>&laquo;</a></li>
	</c:if>
	
	
	
	<!-- 이전 페이지로 가기 -->
	<c:if test="${paging.curPage ne 1 }">
	<li><a href="/document/list/all?curPage=${paging.curPage - 1 }&search=${param.search }">&lt;</a></li>
	</c:if>
	


	<!-- 페이징 리스트 -->
	<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="i">
	
	<!-- 보고 있는 페이지번호 강조 (.active) -->
	<c:if test="${paging.curPage eq i }">
		<li class="active"><a href="/document/list/all?curPage=${i }&search=${param.search }">${i }</a></li>
	</c:if>
	
	<!-- 보고 있는 페이지번호가 아니면 평소 모양으로 보여주기 -->
	<c:if test="${paging.curPage ne i }">
		<li><a href="/document/list/all?curPage=${i }&search=${param.search }">${i }</a></li>
	</c:if>
	
	</c:forEach>
	
	
	
	<!-- 다음 페이지로 가기 -->
	<c:if test="${paging.curPage ne paging.totalPage }">
	<li><a href="/document/list/temp?curPage=${paging.curPage + 1 }&search=${param.search }">&gt;</a></li>
	</c:if>
	
	
	
	<!-- 다음 페이징 리스트로 가기 -->
	<c:if test="${paging.endPage ne paging.totalPage }">
	<li><a href="/document/list/temp?curPage=${paging.startPage + paging.pageCount }&search=${param.search }">&raquo;</a></li>
	</c:if>

	<c:if test="${paging.endPage eq paging.totalPage }">
	<li class="disabled"><a>&raquo;</a></li>
	</c:if>
	
	
	
	<!-- 마지막 페이지로 가기 -->
	<c:if test="${paging.curPage ne paging.totalPage }"><!-- 끝 페이지가 아닐 때 보여준다 -->
	<li><a href="/document/list/temp?curPage=${paging.totalPage }&search=${param.search }">&rarr;</a></li>
	</c:if>
</ul>
</div>