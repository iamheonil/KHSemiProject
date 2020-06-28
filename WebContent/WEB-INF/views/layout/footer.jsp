<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- 일정 추가 Modal -->
	<div class="modal fade" id="personality" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">×</button>
					<h3 class="modal-title">개인정보 처리방침</h3>
				</div>
				<div class="modal-body">
					<div>
						<c:import url="/resources/policy/Personal_Information_Processing_Policy.jsp"></c:import>
					</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>
	</div>


		<div id="footer">
			<h3 style="text-align: left; margin-left: 80px; margin-top:30px;">
				<a href="#"><img src="/logo2.png" width="170px;"></a>
			</h3>
			<div style="text-align: right; margin-right: 80px; margin-bottom:20px;">
				<h5>
					<a href="#">공지사항</a> | <a href="#">쭈우우우우욱</a> | <a data-toggle="modal" href="#personality"><b>개인정보 처리방침</b></a> | &copy; ActiveWare
				</h5>
			</div>

		</div>

</body>
</html>