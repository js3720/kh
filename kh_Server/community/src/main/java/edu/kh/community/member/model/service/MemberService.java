package edu.kh.community.member.model.service;

import static edu.kh.community.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

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

	/** 회원 정보 수정 SErvice
	 * @param mem
	 * @return result
	 * @throws Exception
	 */
	public int updateMember(Member mem) throws Exception{
		Connection conn = getConnection();
		
		int result = dao.updateMember(conn, mem);
		
		if(result>0) conn.commit();
		else conn.rollback();
		
		close(conn);
		return result;
	}

	/** 비밀번호 변경 Service
	 * @param currentPw
	 * @param newPw
	 * @param memberNo
	 * @return result
	 * @throws Exception
	 */
	public int changePw(String currentPw, String newPw, int memberNo) throws Exception{
		// 1) 커넥션 얻어오기
		Connection conn = getConnection(); // DBCP에서 얻어옴
		
		// 2) DAO 메소드 호출 후 결과 반환 받기
		int result = dao.changePw(conn, currentPw, newPw, memberNo);
		
		// 3) 트랜잭션 처리
		if(result >0) conn.commit();
		else conn.rollback();
		
		close(conn);
		return result;
	}

	/** 회원 탈퇴 Service
	 * @param memberNo
	 * @param memberPw
	 * @return result
	 * @throws Exception
	 */
	public int secession(int memberNo, String memberPw) throws Exception{
		// 1) 커넥션 얻어오기
		Connection conn = getConnection(); // DBCP에서 얻어옴
		
		// 2) DAO 메소드 호출 후 결과 반환 받기
		int result = dao.secession(conn, memberNo, memberPw);
		
		// 3) 트랜잭션 처리
		if(result >0) conn.commit();
		else conn.rollback();
		
		close(conn);
		return result;
	}

	/** 이메일 중복 검사 Service
	 * @param memberEmail
	 * @return result
	 * @throws Exception
	 */
	public int emailDupCheck(String memberEmail) throws Exception{
		
		Connection conn = getConnection(); // DBCP에서 만들어둔 커넥션 얻어오기
		
		int result = dao.emailDupCheck(conn, memberEmail);
		
		if(result>0) conn.commit();
		else conn.rollback();
		
		close(conn);
		
		return result;
	}

	/** 닉네임 검사 Service
	 * @param memberNickname
	 * @return result
	 * @throws Exception
	 */
	public int nicknameDupCheck(String memberNickname) throws Exception{

		Connection conn = getConnection();
		
		int result = dao.nicknameDupCheck(conn, memberNickname);
		
		if(result>0) conn.commit();
		else conn.rollback();
		
		close(conn);
		
		return result;
	}

	/** 회원 정보 조회 Service
	 * @param memberEmail
	 * @return member
	 * @throws Exception
	 */
	public Member selectOne(String memberEmail) throws Exception{
		Connection conn = getConnection();
		
		Member member = dao.selectOne(conn, memberEmail);
		
		close(conn);
		
		return member;
	}

	/** 회원 목록 조회 Service
	 * @return memberList
	 * @throws Exception
	 */
	public List<Member> selectAll() throws Exception{

		Connection conn = getConnection();
		
		List<Member> memberList = dao.selectAll(conn);
		
		close(conn);
		
		return memberList;
	}

	/**
	 * 회원 프로필 변경 Service
	 * @param memberNo
	 * @param profileImage
	 * @return result
	 * @throws Exception
	 */
	public int updateProfileImage(int memberNo, String profileImage) throws Exception{

		Connection conn = getConnection();
		
		int result = dao.updateProfileImage(conn, memberNo, profileImage);
		
		if(result>0) conn.commit();
		else conn.rollback();
		
		close(conn);
		
		return result;
	}
}