//XMLHttpRequst 객체를 생성
function getXMLHttpRequest() {
	if (window.ActiveXObject) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e1) { return null; }
		}
	} else if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else {
		return null;
	}
}

//생성된 XMLHttpRequst 객체 전역변수
var httpRequest = null;

//지정 메소드(GET/POST), 지정 URL, 파라미터 값을 사용하여 웹 서버에 요청을 전송
function sendRequest(method, url, params, callback) {
	httpRequest = getXMLHttpRequest();

	// POST로 들어오면 POST 처리, POST 이외의 문자열은 GET 처리
	var httpMethod = method ? method : 'GET';
	if (httpMethod != 'GET' && httpMethod != 'POST') {
		httpMethod = 'GET';
	}
	
	var httpUrl = url;
	
	var httpParams = (params == null || params == '') ? null : params;
	
	// GET 메소드면 URL 뒤에 파라미터를 붙임
	if (httpMethod == 'GET' && httpParams != null) {
		httpUrl = httpUrl + "?" + httpParams;
	}
	
	// 비동기식으로 XMLHttpRequest 객체 사용
	httpRequest.open(httpMethod, httpUrl, true);
	
	// 웹 서버에 전송할 컨텐트 타입 지정
	httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	
	// 콜백 함수 지정
	httpRequest.onreadystatechange = callback;
	
	// HTTP 요청 방식이 'POST'면 send() 함수를 통해 파라미터 전송
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}
