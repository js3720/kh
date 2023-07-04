<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 목록 조회</title>
</head>
<body>
    <table border="1">
    	<thead>
    	<tr>
    		<td>회원번호</td>
    		<td>아이디</td>
    		<td>비밀번호</td>
    		<td>이름</td>
    		<td>성별</td>
    		<td>가입일</td>
    		<td>탈퇴여부</td>
    	</tr>
    	</thead>
    	
    	<tbody>
    		<c:forEach var="member" items="${ requestScope.list }">
    			<tr>
    				<td>${ member.memberNo }</td>
    				<td>${ member.memberId }</td>
    				<td>${ member.memberPw }</td>
    				<td>${ member.memberName }</td>
    				<td>${ member.memberGender }</td>
    				<td>${ member.enrollDate }</td>
    				<td>${ member.secessionFlag }</td>
    			</tr>
    		</c:forEach>
    	</tbody>
    </table>
</body>
</html>