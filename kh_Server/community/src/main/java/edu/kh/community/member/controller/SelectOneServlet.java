package edu.kh.community.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.Gson;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;

@WebServlet("/member/selectOne")
public class SelectOneServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 파라미터 얻어오기
		String memberEmail = req.getParameter("memberEmail");
		
		try {
			
			MemberService service = new MemberService();
			
			// 회원 정보 조회 Service 호출 후 결과(Member 객체) 반환 받기
			Member member = service.selectOne(memberEmail);
			
			// 조회 결과를 응답용 스트림으로 출력
			
			//resp.getWriter().print(member);
			
			// print 매개변수로 참조형 변수가 작성되면
			// 해당 참조형 변수의 toString() 메소드를 자동 호출해서 출력
			
			// *** Java 객체를 Javascript 객체로 변환하여 응답(출력) ***
			
			// Java 객체 -> Javasrcript 객체 형태의 문자열(JSON) -> Javascript 객체
			
			// 1) JSON 직접 작성 시 오타가 너무 많이 난다
			//String str = "{\"memberNickname\" : \""+ member.getMemberNickname() +"\"}";
	        //resp.getWriter().print(str);
	        
			// 2) JSON-Simple 라이브러리에서 제공하는 JSONObject 사용
			
//			if(member != null) {
//				JSONObject obj = new JSONObject();
//				
//				obj.put("memberEmail", member.getMemberEmail());
//		        obj.put("memberNickname", member.getMemberNickname());
//		        obj.put("memberTel", member.getMemberTel());
//		        obj.put("memberAddress", member.getMemberAddress());
//		        obj.put("enrollDate", member.getEnrollDate());
//		        
//		        // JSONObject의 toString() 메소드는
//		        // JSON 형태로 출력될 수 있도록 오버라이딩이 되어있다.
//		        
//		        resp.getWriter().print(obj);
//			}else {
//				resp.getWriter().print(member);
//			}
			
			// 3) GSON 라이브러리를 이용한 Java 객체 -> JSON 변환
			// new Gson().toJson(객체, 스트림);
			
			new Gson().toJson(member,resp.getWriter());
	        
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
