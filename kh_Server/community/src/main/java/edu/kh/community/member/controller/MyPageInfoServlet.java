package edu.kh.community.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.kh.community.member.model.service.MemberService;
import edu.kh.community.member.model.vo.Member;


@WebServlet("/member/myPage/info")
public class MyPageInfoServlet extends HttpServlet {
	// 메인페이지 -> 별명 클릭시 요청(GET)

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = "/WEB-INF/views/member/myPage-info.jsp";
		req.getRequestDispatcher(path).forward(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String memberNickname = req.getParameter("memberNickname");
		String memberTel = req.getParameter("memberTel");
		
		String[] address = req.getParameterValues("memberAddress");
		String memberAddress = null;
		if(address[0].length()!=0) memberAddress = String.join(",,", address);
		
		// *** 세션에서 로그인한 회원 정보 얻어오기 ***
		HttpSession session = req.getSession();
		
		// 얕은 복사(세션에 있는 회원 정보 객체 주소)
		// loginMember를 수정하면 세션에 저장된 내용이 수정 된다!
		Member loginMember = (Member)(session.getAttribute("loginMember"));	
		
		int memberNo = loginMember.getMemberNo(); // 회원 번호 얻어오기 성공
		
		// 업데이트에 필요한 정보를 모아둔 Member 객체 생성
		Member mem = new Member();
		mem.setMemberNo(memberNo);
		mem.setMemberNickname(memberNickname);
		mem.setMemberTel(memberTel);
		mem.setMemberAddress(memberAddress);
		
		try {
			MemberService service = new MemberService();
			int result = service.updateMember(mem);
			
			// 수정 성공/실패에 따른 메세지 출력 제어
			session.setAttribute("message", result >0 ? "회원정보가 수정되었습니다" : "회원정보 수정 실패ㅠㅠ");
			
			if(result>=0) {
				loginMember.setMemberNickname(memberNickname);
				loginMember.setMemberTel(memberTel);
				loginMember.setMemberAddress(memberAddress);
			}
			
			// 성공/실패 여부 관계 없이 "내 정보" 화면 재요청
			
			// 절대경로
			// resp.sendRedirect(req.getContextPath()+"/member/myPage/info");
			// 상대경로
			resp.sendRedirect("info");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
}
