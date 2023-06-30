package edu.kh.jsp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
// Tomcat(WAS == Servlet Container)에서 제공
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Servlet : 웹 서비스(요청, 응답)를 위한 자바 클래스

// @WebServlet("요청 주소") : Servlet 클래스 등록 + 요청 주소 매핑
@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//*** POST 방식의 한글 깨짐 문제 ***
		// - 데이터 전달 방식 차이점
		// GET : 주소(URL)을 통해서 데이터 전달
		//		 이 때, 문자 인코딩은 제출된 HTML파일의 문자 인코딩(charset)을 따른다
				
		// POST : HTTP Body를 통해서 데이터 전달
		//		  이 때, 문자 인코딩은 서버의 기본 문자 인코딩을 따름
		//		  우리 서버(Tomcat) -> ISO--8859-1이 기본 문자 인코딩
				
		// * 해결 방법 *
		// -POST 방식으로 전달 받은 데이터의 문자 인코딩을 변경
		req.setCharacterEncoding("UTF-8");
		// -> 문자 인코딩을 UTF-8로 변경
		// -> 한글이 깨지지 않음
				
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		String memberName = req.getParameter("memberName");
		String intro = req.getParameter("intro");
		String message = memberId+"님의 가입을 환영합니다!";
		
		//클라이언트와 연결된 출력 스트림을 이용해서 응답 화면을 출력
//		PrintWriter out = resp.getWriter();
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		// ...
//		out.println("</html>");
		
		// Servlet으로 응답 화면 만들기 너무 어렵다
		// -> 응답 화면 만드는 부분의 표기법만 HTML로 변경하자!
		// --> 이것이 JSP!!
		//		(눈에 보이는 코드는 HTML, 해석은 Java)
		
		// Servlet -> RequestDispatcher -> JSP
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUpResult.jsp");
		req.setAttribute("memberId", memberId);
		req.setAttribute("memberPw", memberPw);
		req.setAttribute("memberName", memberName);
		req.setAttribute("intro", intro);
		req.setAttribute("message", message);
		dispatcher.forward(req, resp);
	}


}
