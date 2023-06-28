package edu.kh.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
// Servlet 클래스를 만들기 위해서는 
// javax.servlet.http.HttpServlet 추상클래스를 반드시 상속 받아야 함
// -> goGet() / doPost()를 필요한 형태로 오버라이딩 진행해야함
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletEx2 extends HttpServlet{
	// /ServletProject1/example1.do 주소로 요청이 왔을 때
	// 해당 클래스가 응답할 수 있도록 연결하는 작업이 필요함
	
	// -> web.xml 파일에서 연결 작업 수행

	// GET 방식 요청을 처리하는(do) 메소드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// HttpServletRequest : 클라이언트 + 요청 정보가 담긴 객체
		// HttpServletResponse : 서버가 클라이언트한테 응답하는 방법을 제공하는 객체
		
		// 요청 시 전달된 input 태그 값(== Parameter)을 얻어오는 방법
		// req.getParameter("input 태그 name 속성값")
		
		// 파라미터(Parameter) == 요청 시 전달된 input 태그의 값
		
		String orderer = req.getParameter("orderer");
		// getParameter()는 전달된 input태그의 name이 하나일 때 만 가능
		
		// -> 같은 name이 여러 개면 String[]로 반환하는
		// getParameterValues()를 사용
		String[] coffee = req.getParameterValues("coffee");
		// 체크박스에 체크된 메뉴들이 모두 배열에 담김
		// --> 체크가 안되면 배열에 하나도 담기지 않음
		
		if(coffee != null) for(String c : coffee) System.out.println(c);
		System.out.println("주문자 : "+orderer);
		
		// HttpServletRequest : 클라이언트 정보 + 전달된 값
		// HttpServletResponse : 서버가 클라이언트에게 응답할 방법을 제공
		
		// Write : 서버가 클라이언트에게 쓰다 == 출력
		// resp.getWriter() : 서버가 클라이언트에게 응답할 수 있는 출력 전용 스트림을 얻어옴
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		// ** 스트림을 통해서 그냥 문자열을 내보내면 정상 출력되지 않는 문제 발생 **
		// 왜? 전달되는 응답 데이터가 어떤 형식인지, 문자인코딩은 어떤건지 지정해주지 않아서
		
		// ****************************************************************
		/* Dynamic Web project(동적 웹 프로젝트)
		 * 
		 * - 요청에 따라서 응답되는 화면(HTML)을 실시간으로 만들어 내서 (동적)
		 * 	 클라이언트에게 응답하는 프로젝트
		 * */
		// ****************************************************************
		
		// HTML 코드를 자바(Servlet)에서 작성하여
		// 클라이언트와 연결된 응답 출력용 스트림(out)을 이용해 출력
		out.println("<!DOCTYPE html>"
				+ "<html>"
						
				+ "<head>"
				+ "<title>\"+ orderer +\"님의 주문 목록</title>"
				+ "</head>"
				
				+ "<body>"
				+ "<ul>");
		if(coffee != null) for(String c : coffee) out.println("<li>"+c+"</li>");
		out.println("</ul>"
				+ "</body>"
				
				+ "</html>");
		
	}
	

}
