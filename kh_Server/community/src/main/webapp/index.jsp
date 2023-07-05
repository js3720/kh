<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <header>

            <!-- 클릭 시 메인페이지로 이동하는 로고 -->
            <section >
                <a href="#">
                    <img src="resources/images/kh-logo.jpg" id="home-logo">
                </a>
            </section>

            <!-- header의 두번째 자식 div -->
            <section>
                <article class="search-area">
                    
                    <!--form 내부 input태그 값을 서버 또는 페이지로 전달  -->
                    <form action="#" name="search-form">
                        
                        <!-- fieldeset : from 내부에서 input을 종류별로 묶는 용도로 많이사용 -->
                        <fieldset>
                            <input type="search" id="query" name="query" 
                            placeholder="검색어를 입력해주세요." autocomplete="off">

                            <!-- 검색 버튼 -->
                            <button type="submit" id="search-btn" class="fa-solid fa-magnifying-glass"></button>
                        </fieldset>

                    </form>
                </article>
            </section>
            <section></section>
        </header>

        <nav>
            <ul>
                <li><a href="#">공지사항</a></li>
                <li><a href="#">자유 게시판</a></li>
                <li><a href="#">질문 게시판</a></li>
                <li><a href="#">FAQ</a></li>
                <li><a href="#">1:1문의</a></li>
            </ul>
        </nav>

        <section class="content">
            <section class="content-1">
               ${ sessionScope.loginMember }
               
               <hr>
               
               message : ${sessionScope.message}
            
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
                                 <input type="text" name="inputEmail" placeholder="아이디(이메일)">
                                 <input type="password" name="inputPw" placeholder="비밀번호">
             
                             </section>
             
                             <section>
                                 <button>로그인</button>
                             </section>
                         </fieldset>
             
                         <!-- 회원가입 / ID / PW 찾기 영역 -->
                         <article id="signup-find-area">
                             <a href="#">회원가입</a>
                             <span>|</span>
                             <a href="#">ID/PW 찾기</a>
                         </article>
      
                         <label>
                             <input type="checkbox">아이디 저장
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
                              <a href="#" id="nickname">${loginMember.memberNickname }</a>
                              
                              <a href="#" id="logout-btn">로그아웃</a>
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
        <footer>
        <p>Copyright &copy; KH Information Educational Institue M-Class</p>
        
        <article>
            <a href="#">프로젝트 소개</a>
            <span>|</span>
            <a href="#">이용약관</a>
            <span>|</span>
            <a href="#">개인정보처리방침</a>
            <span>|</span>
            <a href="#">고객센터</a>   
        </article>
        </footer>
    
</body>
</html>