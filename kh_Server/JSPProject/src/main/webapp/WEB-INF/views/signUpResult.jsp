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
<title><%=memberName %>�� ���� ���</title>
</head>
<body>
	<ul>
		<li>���̵� : <%=memberId %> </li>
		<li>��й�ȣ : <%=memberPw %> </li>
		<li>�̸� : <%=memberName %> </li>
		<li>�ڱ�Ұ� : <%=intro %> </li>
	</ul>
	
	<h1><%=message%></h1>

</body>
</html>