package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/member")
@Controller
@SessionAttributes({"loginMember"})
public class MemberController {
   
   @Autowired
   private MemberService service;
   
   /** 로그인 요청 처리(찐)
    * @return 메인페이지 redirect 주소
    */
   @PostMapping("/login")
      public String login(Member inputMember, Model model
                     , @RequestHeader(value="referer") String referer
                     , @RequestParam(value="saveId", required=false) String saveId
                     , HttpServletResponse resp
                     , RedirectAttributes ra) {

      // 로그인 서비스 호출
      Member loginMember = service.login(inputMember);
   
      // 로그인 결과에 따라 리다이렉트 경로를 다르게 지정
      String path = "redirect:";
      
      if(loginMember != null) { // 로그인 성공 시
         path += "/"; // 메인페이지로 리다이렉트
       
         model.addAttribute("loginMember", loginMember);
         
         Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
         
         
         if(saveId != null) { // 체크 되었을 때
            // 한 달(30일) 동안 유지되는 쿠키 생성
            
            cookie.setMaxAge(60 * 60 * 24 * 30); // 초 단위로 지정
            
         }else { // 체크 안되었을 때
            cookie.setMaxAge(0);
         }
         
         // 클라이언트가 어떤 요청을 할 때 쿠키가 첨부될 지 경로(주소)를 지정
         cookie.setPath("/"); // localhost/ 이하 모든 주소
                         
         resp.addCookie(cookie);
         
      }else { // 로그인 실패 시
         path += referer; // HTTP Header - referer(이전 주소)
         
         ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
         
      }
      
      return path;
   }
   
   // 로그아웃
   @GetMapping("/logout")
   public String logout(SessionStatus status, HttpSession session) {
      status.setComplete();      
      return "redirect:/";
   }
   
   // 회원 가입 페이지 이동
   @GetMapping("/signUp")
   public String signUp() {
	   
      return "member/signUp";
   }
   
// 회원 가입 진행
   @PostMapping("/signUp")
   public String signUp(Member inputMember
                  , String[] memberAddress
                  , RedirectAttributes ra) {
      
      if(inputMember.getMemberAddress().equals(",,")) {
         inputMember.setMemberAddress(null);
         
      } else {

         String addr = String.join("^^^", memberAddress);
         inputMember.setMemberAddress(addr);
      }
      
      // 회원 가입 서비스 호출
      int result = service.signUp(inputMember);
      
      // 가입 성공 여부에 따라 주소 결정
      String path = "redirect:";
      String message = null;
      
      if(result > 0) { // 가입 성공
         path += "/"; // 메인 페이지
         
         message = inputMember.getMemberNickname() + "님의 가입을 환영합니다.";
         
      } else { // 가입 실패
  
         path += "signUp"; // 상대경로
         
         message = "회원 가입 실패!";
         
      }
      
      ra.addFlashAttribute("message", message);
      
      return path;
   }
   
}