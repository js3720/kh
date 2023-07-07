package edu.kh.community.member.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;

import edu.kh.community.member.model.dao.MemberDAO;
import edu.kh.community.member.model.vo.Member;

public class MemberService {

   private MemberDAO dao = new MemberDAO();
   
   /** 로그인 서비스
    * @param mem
    * @return loginMember
    * @throws Exception
    */
   public Member login(Member mem) throws Exception {
      
      // Connection 얻어오기
      Connection conn = getConnection();
      
      // DAO 수행
      Member loginMember = dao.login(conn,mem);
      
      // Connection 반환
      close(conn);
      
      // 결과 반환
      return loginMember;
   }

   /** 회원가입 Service
    * @param mem
    * @return result
    * @throws Exception
    */
	public int signUp(Member mem) throws Exception{
		// 1) 커넥션 얻어오기
		Connection conn = getConnection(); // DBCP에서 얻어옴
		
		// 2) DAO 메소드 호출 후 결과 반환 받기
		int result = dao.signUp(conn, mem);
		
		// 3) 트랜잭션 처리
		if(result >0) conn.commit();
		else conn.rollback();
		
		close(conn);
		return result;
	}

}