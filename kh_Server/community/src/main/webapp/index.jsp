<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>KH 커뮤니티</title>
    <link rel="stylesheet" href="resources/css/main-style.css">
    <script src="https://kit.fontawesome.com/51fc103959.js" crossorigin="anonymous"></script>
</head>
<body>

    <main>
    	<!-- jsp:include 태그
    		다른 jsp파일의 내용을 해당 위치에 포함시킴
    		
    		* 다른 경로 작성 시
    			외부 요청 주소X(인터넷 주소, 최상위 : /community),
    			내부 접근 경로 O(파일 경로, 최상위 : /webapp) 
    		
    	-->
		<jsp:include page="/WEB-INF/views/common/header.jsp"/>
        <section class="content">
            <section class="content-1">
                ${ sessionScope.loginMember }
                
                <hr>
                
                ${sessionScope.message}
            
            </section>
            <section class="content-2">
            
                    <!-- if - else -->
                <c:choose>
                    
                    <%-- ★★★ choose 내부에는 jsp 주석만 사용가능 ★★★ --%>
                    <c:when test="${ empty sessionScope.loginMember}">
                    
                        <form action="member/login" method="post" name="login-form" >
                
                            <!-- 아이디/비밀번호/로그인버튼 영역 -->
                            <fieldset id="id-pw-area">
                                <section>
                                    <input type="text" name="inputEmail" placeholder="아이디(이메일)" autocomplete="off" value="${cookie.saveId.value}">
                                                                                                                            <%-- 현재 페이지 쿠키 중 "saveId"의 내용을 출력 --%>
                                    <input type="password" name="inputPw" placeholder="비밀번호">
                
                                </section>
                
                                <section>
                                    <button>로그인</button>
                                </section>
                            </fieldset>
                
                            <!-- 회원가입 / ID / PW 찾기 영역 -->
                            <article id="signup-find-area">
                                <!-- WEB-INF 폴더는 외부로부터 직접적으로 요청할 수 없는 폴더
                                    왜? 중요한 코드(자바, sql, 설정관련)가 위치하는 폴더로서
                                    외부로부터 접근을 차단하기 위해서

                                    -> 대신 Servlet을 이용하여 내부 접근(forward)은 가능
                                -->
                                <!-- <a href="/community/WEB-INF/views/member/signUp.jsp">회원가입</a> -->
                                <a href="/community/member/signUp">회원가입</a>
                                <span>|</span>
                                <a href="#">ID/PW 찾기</a>
                            </article>
                            
                            <%-- 쿠키에 saveId가 있는 경우 --%>
                            <c:if test="${ !empty cookie.saveId.value }">
                                <%-- chk 변수 생성(page scope) --%>
                                <c:set var="chk" value="checked"></c:set>
                            </c:if>
        
        
                            <label>
                                <input type="checkbox" name="saveId" ${chk}>아이디 저장
                            </label>
                        </form>
            
                    </c:when>
                    
                    <%-- 로그인이 되어있는 경우 --%>
                    <c:otherwise>
                        <article class="login-area">
                        
                        <!-- 회원 프로필 이미지-->
                        <a href="#">
                            <img src="/community/resources/images/user.png" id="member-profile">
                        </a>
                        
                        <!-- 회원 정보 + 로그아웃 버튼 -->
                        <div class="my-info">
                            <div>         <!-- page > request > session > application 이여서 생략해도 자동으로 session -->
                                <a href="${ contextPath }/member/myPage/info" id="nickname">${loginMember.memberNickname }</a>
                                
                                <a href="/community/member/logout" id="logout-btn">로그아웃</a>
                            </div>
                            
                            <p>
                                ${ loginMember.memberEmail }
                            </p>
                        </div>
                        </article>
                    
                    </c:otherwise>
                
                </c:choose>
                <!-- 절대경로 : /community/member/login-->
                <!-- 상대 경로 (index.jsp) 기준 -->
                
            </section>
        </section>
        </main>
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>