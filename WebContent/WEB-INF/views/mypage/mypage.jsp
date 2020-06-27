<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%-- import header.jsp --%>
<c:import url="/WEB-INF/views/layout/header_doc.jsp" />

<%-- import aside.jsp --%>
<c:import url="/WEB-INF/views/layout/aside_mypage.jsp" />

<style type="text/css">
#loginForm {
	padding: 80px 60px;
	width: 430px;
	background: white;
	vertical-align: middle;
}

.Form-title {
	margin: 0 auto;
	margin-bottom: 3px;
	width: 345px;
	text-align: left;
	font-size: 1.3em;
	font-weight: bold;
	padding-left: 5px;
	clear: both;
}

.Form-content {
	width: 350px;
	margin: 0 auto;
	margin-bottom: 40px;
}

.Form-content:last-child {
	margin-bottom: 0px;
}

.Form-content > input, button, select, option {
	width: 100%;
	height: 45px;
	margin: 0 auto;
	font-size: 0.9em;
	padding: 10px;
	border-radius: 5px;
}

.Form-content > select, option, .content-birth > select, option {
	border-radius: 5px;
	border: 2px solid black;
	height: 45px;
	font-size: 1.0em;
}

.Form-content > button {
	background: #0f4c81;
	font-size: 1.2em;
	color: white;
	cursor: pointer;
	font-weight: bold;
}

.Form-content > a {
	text-decoration: none;
	font-weight: bold;
}

.Form-content > a:hover {
	text-decoration: underline;
}

.Form-content > input[name="useraddrDetail"] {
	margin-top: 10px;
}

.Form-name-Layout {
	border-bottom: 5px solid #add3f0;
	margin-bottom: 25px;
}

.Form-name {
	font-size: 1.9em;
	font-weight: bold;
	border-bottom: 5px solid #0f4c81;
}

.notice {
	font-size: 1.1em;
	font-weight: bold;
	height: auto;
	margin-bottom: 50px;
}

.notice-icon {
	display: inline-block;
}


#addrBtn {
	width: auto;
    height: 30px;
    vertical-align: bottom;
    line-height: 1px;
    font-size: 0.7em;
    margin-left: 25px;
    cursor: pointer;
    border-radius: 5px;
    background: white;
}

.agree-checkbox {
	width: 350px;
	margin: 0 auto;
	margin-bottom: 40px;
	font-size: 1.1em;
	font-weight: bold;
	
}

.agree-checkbox > input[type=checkbox] {
	width: 20px;
	height: 20px;
	
}

.agree-checkbox > label {
	cursor: pointer;
}

#userphoto {
	width: 200px;
	height: 200px;
	border: 2px solid black;
	display: inline-block;
}

.Form-content > input[name="uphoto"] {
	width: 75px;
    height: auto;
    padding: 0px;
    margin-left: 5px;
    vertical-align: bottom;
}

.Form-content > input[id="btnForm"]{
	background: #0f4c81;
	font-size: 1.2em;
	color: white;
	cursor: pointer;
	font-weight: bold;
	width: 100%;
	height: auto;
	margin: 0 auto;
	padding: 10px;
	border-radius: 5px;
}

.content-birth {
	width: 105px;
}

.content-birth:nth-child(2), .content-birth:nth-child(3) {
	margin-left: 17px;
}

.err_msg {
 	text-align: left;
}
</style>

<script src="https://code.jquery.com/jquery-2.2.4.min.js"></script>

<script type="text/javascript">
$(document).ready(function() {
	
	
	// 프로필사진 미리보기
	$("#uphoto").change(function(e) {
		
		// 선택한 파일들 변수
		var files = e.target.files; // FileList 객체
		
		if(!files[0].type.includes("image")) {
			alert("이미지가 아닙니다")
			e.target.value = null;
			return false;
		}
		
		// * File객체에는 파일의 정보가 들어있긴 하지만
		//   해당 파일의 내용물(컨텐츠) 정보는 없다
		//		> FileReader 객체를 이용해 파일 내용을 읽어들여야한다
		
		// FileReader 객체 생성
		var reader = new FileReader();
		
		// 파일을 다 읽었을때 load발생
		reader.onload = function(ev) {
			
			// 이미지가 한장만 유지됨
			$("#userphoto").html($("<img>").attr({
								"src": ev.target.result,
								"width": 200,
								"height": 200 }))
		}

		// FileReader 객체를 이용한 File 객체 정보 읽기
		reader.readAsDataURL(files[0]); // BLOB 또는 File 형식으로 읽기
	})
	
	

	
	
	// 입력값 검증
	// 값 있으면 에러창 없애기
	
	// pw - 특수문자 / 문자 / 숫자 포함 형태의 8~15자리 이내의 암호 정규식
	var pwReg = /^.*(?=^.{8,15}$)(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&+=]).*$/;
	
	// phone - 숫자3-숫자4-숫자4
	var phoneReg = /^\d{3}-\d{4}-\d{4}$/;
	
	
	// 비밀번호 정규식 검증
	$("#userpw").blur(function() {
		if(pwReg.test($(this).val())) {
			$("#pw_err_msg").text("");
			$("#userpwck").attr("disabled", false)
		} else {
			$("#pw_err_msg").text("특수문자, 문자, 숫자를 1개 이상 포함한 8~15자의 값을 입력해주세요.");
			$("#pw_err_msg").css("color", "red")
		}
	})
	
	// 비밀번호 재확인 검증
	$("#userpwck").blur(function() {
		if($("#userpw").val() != $(this).val()) {
			$("#pwck_err_msg").text("비밀번호가 일치하지 않습니다.");
			$("#pwck_err_msg").css("color", "red")
		} else {
			$("#pwck_err_msg").text("");
		}
	})
	
	// 휴대전화 정규식 검증
	$("#userphone").blur(function() {
		if(phoneReg.test($(this).val())) {
			$("#phone_err_msg").text("");
		} else {
			$("#phone_err_msg").text("(-)을 포함시키거나 올바른 값을 입력해주세요.");
			$("#phone_err_msg").css("color", "red")
		}
	})
	
	$("#useraddr").blur(function() {
		if($(this).val() != 0) {
			$("#addr_err_msg").text("");
		} else {
			$("#addr_err_msg").text("우편번호 찾기를 통해 입력해주세요.");
			$("#addr_err_msg").css("color", "red")
		}
	})
	
	
	
	// form submit 전 검증
	$("#joinForm").submit(function() {
	
		var cnt=0;
	
		
		if(!pwReg.test($("#userpw").val())) {
			$("#pw_err_msg").text("필수 정보입니다.");
			$("#pw_err_msg").css("color", "red")
			cnt++;
		}
		
		if($("#userpwck").val() == "") {
			$("#pwck_err_msg").text("필수 정보입니다.");
			$("#pwck_err_msg").css("color", "red")
			cnt++;
		}
		
		if($("#userpw").val() != $("#userpwck").val()) {
			$("#pwck_err_msg").text("비밀번호가 일치하지 않습니다.");
			$("#pwck_err_msg").css("color", "red")
			cnt++;
		}
		
		if(!phoneReg.test($("#userphone").val())) {
			$("#phone_err_msg").text("필수 정보입니다.");
			$("#phone_err_msg").css("color", "red")
			cnt++;
		}
		
		if($("#useraddr").val() == "") {
			$("#addr_err_msg").text("필수 정보입니다.");
			$("#addr_err_msg").css("color", "red")
			cnt++;
		}
		
		// cnt>0 이면 submit 수행x
		if(cnt>0) {
			return false;
		} else {
			$(this).submit()
		}
	})
	
	
	
	
})
</script>

<!-- 카카오 우편번호 api 시작 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function sample6_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
//                     document.getElementById("sample6_extraAddress").value = extraAddr;
                
                } else {
//                     document.getElementById("sample6_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
//                 document.getElementById('sample6_postcode').value = data.zonecode;
                document.getElementById("useraddr").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("useraddrDetail").focus();
            }
        }).open();
    }
    
    
</script>
<!-- 카카오 우편번호 api 끝 -->









<div id="contents">

<div id="loginForm">
			<p class="Form-name-Layout">
				<span class="Form-name">회원가입</span>
			</p>
			<div class="notice">
				<p style="margin-bottom: 3px">
					${userdept} ${userrank } ${username }님 환영합니다!
				</p>
				<p>
					계속해서 아래 정보를 입력해주세요.
				</p>
			</div>
			

			<form action="/user/join" method="post" id="joinForm"  enctype="multipart/form-data">
			
			<div class="Form-title">
				프로필 사진
			</div>
			<div class="Form-content" style="text-align: left;">
				<div id="userphoto"><img alt="프로필사진" src="/upload/2020062604131912.jpg" style="width:200px; height:200px;"></div>
				<input type="file" name="uphoto" id="uphoto" style="display: inline;"/>
				<div id="photo_err_msg" class="err_msg"></div>
			</div>
			<div class="Form-title">
				<label for="userid">사번</label>
			</div>
			<div class="Form-content">
				<input type="text" value="${user_detail.userid }" disabled="disabled" /> <!-- 값 보여주기만 함. 전송x -->
			</div>
			<div class="Form-title">
				<label for="userpw">비밀번호</label>
			</div>
			<div class="Form-content">
				<input type="password" id="userpw" name="userpw" />
				<div id="pw_err_msg" class="err_msg"></div>
			</div>
			<div class="Form-title">
				<label for="userpwck">비밀번호 재확인</label>
			</div>
			<div class="Form-content">
				<input type="password" id="userpwck" name="userpwck" disabled=""/>
				<div id="pwck_err_msg" class="err_msg"></div>
			</div>
			<div class="Form-title">
				<label for="userphone">생년월일</label>
				<c:set value="${user_detail.userbirth }" var="userbirth" />
			</div>
			<div class="Form-content" style="display: flex;">
				<div class="content-birth">
					<select disabled="disabled">
							<option>${fn:substring(userbirth,0,4) }년</option>
					</select>
				</div>
				<div class="content-birth">
					<select disabled="disabled">
							<option>${fn:substring(userbirth,5,7) }월</option>
					</select>
				</div>
				<div class="content-birth">
					<select disabled="disabled">
							<option>${fn:substring(userbirth,8,10) }일</option>
					</select>
				</div>
			</div>
			
			<div class="Form-title">
				성별
			</div>
			<div class="Form-content">
				<select disabled="disabled">
					<option>${user_detail.usergender }</option>
				</select>
				<div id="gender_err_msg" class="err_msg"></div>
			</div>
			<div class="Form-title">
				<label for="userphone">휴대전화</label>
			</div>
			<div class="Form-content">
				<input type="text" id="userphone" name="userphone" value="${user_detail.userphone }" placeholder="(-)을 포함해서 입력하세요."/>
				<div id="phone_err_msg" class="err_msg"></div>
			</div>
			<div class="Form-title">
				주소<input type="button" id="addrBtn" onclick="sample6_execDaumPostcode()" value="우편번호 찾기"><br>
			</div>
			<div class="Form-content">
				<input type="text" id="useraddr" name="useraddr" value="${user_detail.useraddr }" placeholder="주소"/>
				<div id="addr_err_msg" class="err_msg"></div>
				<input type="text" id="useraddrDetail" name="useraddrDetail" placeholder="상세주소"/>
				
			</div>
			
			<div class="Form-content">
				<input type="submit" value="회원정보변경" id="btnForm" />
			</div>		
			
			
	
			</form>
			
		</div>



</div>

<%-- import footer --%>
<c:import url="/WEB-INF/views/layout/footer.jsp" />