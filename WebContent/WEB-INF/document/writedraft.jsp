<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(document).on("click",".guideBox > p",function(){
    if($(this).next().css("display")=="none"){
      $(this).next().show();
      $(this).children("span").text("[닫기]");
    }else{
      $(this).next().hide();
      $(this).children("span").text("[열기]");
    }
});


</script>
</head>
<body>

<div class="guideBox">
  <p>검색조건<span class="textbtn">[열기]</span></p>
  <div style="display:none">
 
    <div>
      <dl>
        <dd>
          <select id="a" name="a">
            <option value="a1">A1</option>
            <option value="a2">A2</option>
            <option value="a3">A3</option>
          </select>
        </dd>
      </dl>
    </div>
 
  </div>
</div>


</body>
</html>