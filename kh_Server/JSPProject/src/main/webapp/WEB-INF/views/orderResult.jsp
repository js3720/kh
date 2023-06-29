<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!-- HTML �ּ� (������ ������ ���� O) -->
<%-- JSP �ּ� (������ ������ ���� X) --%>

<%--
	<%@ %> : ������ -> �˷��ְų� �����ϴ� �Ӽ��� ����
	"charset=UTF-8"			:���� ������ UTF-8 ���� ���ڵ� �������� �ۼ��Ǿ���
	pageEncoding="UTF-8"	:���� ������ �ؼ��� �� UTF-8 ���� ���ڵ��� �̿��ؼ� �ؼ�

	<% %> : ��ũ��Ʋ��(scriptlet) -> JSP���� �ڹ� �ڵ带 �ۼ��� �� �ִ� ����
	-> JSTL ���̺귯���� �̿��ؼ� �±� �������� ����
	
	<%= %> : ǥ����(Expression) -> �ڹ� �ڵ��� ���� HTML �������� ǥ��(���)
 --%>
    
<% // �ڹ� �ڵ� �ۼ� ���� (scliptlet, ��ũ��Ʋ��)
	int result = (int)request.getAttribute("res");
	String pizza = (String)request.getAttribute("pizza");
	String size = (String)request.getAttribute("size");
	int amount = (int)request.getAttribute("amount");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
	<title>�ֹ� ���</title>
	<style>
		#area{
			font-size : 18px;
			font-weight : bold;
		}
		h1{color : red;}
	</style>
</head>
<body>
	<!-- webapp ���� ���� html/css/jsp ���� ������ ���� �ʰ� ���� ���� -->
	<div id="area">
		���� : <%=pizza%>
		<br>
		������ : <%=size.equals("R") ? "Regular" : "Large"%>
		<%-- 
			<% if(size.equals("R")){%>
         	Regular
      		<% } else{ %>
         	Large
      		<% } %>
		 --%>
		<br>
		���� : <%=amount%>��
	</div>
	<h1>��� ��� : <%=result%>��</h1>
	
	<% for(int i=1; i<6; i++){%>
		<h<%=i%>><%=i%>��° �����</h<%=i%>>
	<%}%>
	
</body>
</html>