package edu.kh.community.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import edu.kh.community.board.model.service.ReplyService;
import edu.kh.community.board.model.vo.Reply;

// Controller : 요청에 따라 알맞은 서비스를 호출하고
// 요청 처리 결과를 내보내줄(응답할) view를 선택

// *** Front Controller 패턴 ***
// 하나의 Servlet이 여러 요청을 받아들이고 제어하는 패턴

@WebServlet("/reply/*") // reply로 시작하는 모든 요청을 받음
public class ReplyController extends HttpServlet{
   
   // /reply/selectReplyList
   // /reply/insert
   // /reply/update
   // /reply/delete
   
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // GET방식 요청 처리
      String uri = req.getRequestURI(); // /community/reply/test
      String contextPath = req.getContextPath(); // /community
      String command = uri.substring(  (contextPath + "/reply/").length()  );// test (/reply/ 뒤)
      // /community/reply/ 뒤부터 끝까지를 잘라내겠다.

      ReplyService service = new ReplyService();
      
      // 댓글 목록 조회 요청인 경우
         
         try {
            if(command.equals("selectReplyList")){
            
            // 파라미터를 얻어와 정수 형태로 parsing
            int boardNo = Integer.parseInt(req.getParameter("boardNo"));
            
            // 댓글 목록 조회 서비스 호출 후 결과 반환 받기
            
            List<Reply> replyList = service.selectReplyList(boardNo);
            
            // JSON 변환 + 응답
            new Gson().toJson(replyList, resp.getWriter());
            }
            
            // 댓글 등록
            if(command.equals("insert")) {
               
               // 파라미터 얻어오기
               String replyContent = req.getParameter("replyContent");
               int memberNo = Integer.parseInt(req.getParameter("memberNo"));
               int boardNo = Integer.parseInt(req.getParameter("boardNo"));
               
               // Reply 객체를 생성해서 파라미터 담기
               Reply reply = new Reply();
               reply.setReplyContent(replyContent);
               reply.setMemberNo(memberNo);
               reply.setBoardNo(boardNo);
               
               System.out.println(replyContent);
               System.out.println(memberNo);
               System.out.println(boardNo);
               
               // 댓글 등록(insert) 서비스 호출후 결과 반환 받기
               int result = service.insertReply(reply);
               
               // 서비스 호출 결과를 그대로 응답 데이터로 내보냄
               resp.getWriter().print(result);
            }
            
            // 댓글 삭제
            if(command.equals("delete")) {
               
               int replyNo = Integer.parseInt(req.getParameter("replyNo"));
               
               int result = service.deleteReply(replyNo);
               
               resp.getWriter().print(result);
               
            }
            
            // 댓글 수정
            if(command.equals("update")) {
            	
            	int replyNo = Integer.parseInt(req.getParameter("replyNo"));
            	String replyContent = req.getParameter("replyContent");
            	int result = service.updateReply(replyNo, replyContent);
            	resp.getWriter().print(result);
            }
            
         }catch(Exception e) {
            e.printStackTrace();
         }
         
   }
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      // POST방식 요청 처리
      doGet(req,resp); // POST방식으로 전달된 요청을 doGet()으로 전달하여 수행
      
   }
   
}