<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	String memberId = (String)request.getAttribute("memberId");
	String memberPw = (String)request.getAttribute("memberPw");
	String memberName = (String)request.getAttribute("memberName");
	String intro = (String)request.getAttribute("intro");
	String message = (String)request.getAttribute("message");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><%=memberName %>님 가입 결과</title>
</head>
<body>
	<ul>
		<li>아이디 : <%=memberId %> </li>
		<li>비밀번호 : <%=memberPw %> </li>
		<li>이름 : <%=memberName %> </li>
		<li>자기소개 : <%=intro %> </li>
	</ul>
	
	<h1><%=message%></h1>

</body>
</html>