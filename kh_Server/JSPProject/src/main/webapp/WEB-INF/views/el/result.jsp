<!-- Person Ŭ���� import -->
<%@page import="edu.kh.jsp.controller.Person"%>

<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<!--
		EL�� Ư¡
		
		1. get�̶�� �ܾ ������� ����
		
		2. EL�� null�� ��ĭ���� �����
			(null�� ���õ� ���� ��� ��ĭ)
 	-->
	<h3>request���� Parameter ������</h3>
	
	<pre>
		EL�� Parameter ���ͼ� ����ϴ� ���
		\${ param.name�Ӽ��� }
	</pre>
	
	1) JSP ǥ���� :
	<%= request.getParameter("inputName")%> /
	<%= request.getParameter("inputAge") %> /
	<%= request.getParameter("inputAddress")%>
	
	<%= request.getParameter("inputAddress2")%>
	<!-- null -->
	
	<br><br>
	
	2) EL(ǥ�� ���) :
	${ param.inputName } /
	${ param.inputAge } /
	${ param.inputAddress }
	
	${ param.inputAddress2 }
	<!-- ��ĭ -->
	
	<h3>request���� �Ӽ�(Attribute) ������</h3>
	
	<pre>
		Servlet���� �߰��� �Ӽ��� ǥ��(���)�Ϸ��� ���
		request�� ���õ� �Ӽ�(Attribute)�� key���� �ۼ��Ͽ� ����� �� �ִ�!
		
		\${ �Ӽ�key }
		
		\${ �Ӽ�key.�ʵ�� }
		(��, getter�� �ۼ��Ǿ� �־������ �����ϴ�!)
		
	</pre>
	
	<%
		String menu = (String)request.getAttribute("menu");
		Person person = (Person)request.getAttribute("person");
	%>
	
	1) JSP ǥ���� : <%=menu%>
	
	<br> <%= person %>
	
	<br> <%= person.getName() +", ���� : "+ person.getAge() +", �ּ� : "+ person.getAddress() %>
	
	<br><br>
	
	2) EL(ǥ�� ���) : ${ menu }
	
	<br> ${ person }
	<br> ${ person.name }
	<br> ${ person.age }
	<br> ${ person.address }
	
</body>
</html>