<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<% 	// �ڹ� �ڵ� �ۼ� ����
	// ����� JSP -> Servlet���� ���� ���� ���� req, resp�� ����
	// -> req, resp�� ����� �� �ִ�!
	// -> ��� �̸��� request, response�� �ٲ�
	
	String r = (String)request.getAttribute("res");
	
	// getAttribute("key")
	// -��ȯ�� Object -> ����Ÿ������ ���� ����ȯ�� �ʿ���
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�α��� ��� ������</title>
</head>
<body>
	<!-- ���� ����� ���� r�� ����� �� ��� -->
	<h1><%=r%></h1>
</body>
</html>